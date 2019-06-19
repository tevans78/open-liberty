/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.microprofile.reactive.messaging.fat.suite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.io.File;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testcontainers.containers.KafkaContainer;

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.ShrinkHelper.DeployOptions;
import com.ibm.ws.microprofile.reactive.messaging.fat.apps.kafka.BasicMessagingBean;
import com.ibm.ws.microprofile.reactive.messaging.fat.suite.ConnectorProperties.Direction;

import componenttest.annotation.Server;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;

/**
 *
 */
@RunWith(FATRunner.class)
public class KafkaMessagingTest {

    private static final String APP_NAME = "basicKafkaTest";

    @ClassRule
    public static KafkaContainer kafka = new KafkaContainer();

    @Server("SimpleRxMessagingServer")
    public static LibertyServer server;

    private static KafkaConsumer<String, String> kafkaConsumer;
    private static KafkaProducer<String, String> kafkaProducer;

    @BeforeClass
    public static void setup() throws Exception {
        ConnectorProperties sourceConfig = new ConnectorProperties(Direction.INCOMING, "kafkaSource")
                        .addProperty("bootstrap.servers", kafka.getBootstrapServers())
                        .addProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
                        .addProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
                        .addProperty("group.id", "test-consumer")
                        .addProperty("topic", "test-in");

        ConnectorProperties sinkConfig = new ConnectorProperties(Direction.OUTGOING, "kafkaSink")
                        .addProperty("bootstrap.servers", kafka.getBootstrapServers())
                        .addProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
                        .addProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        PropertiesAsset config = new PropertiesAsset()
                        .include(sourceConfig)
                        .include(sinkConfig);

        File libsDir = new File("lib/LibertyFATTestFiles/libs");

        WebArchive war = ShrinkWrap.create(WebArchive.class, APP_NAME + ".war")
                        .addPackage(BasicMessagingBean.class.getPackage())
                        .addAsResource(config, "META-INF/microprofile-config.properties")
                        .addAsLibraries(libsDir.listFiles());

        ShrinkHelper.exportDropinAppToServer(server, war, DeployOptions.SERVER_ONLY);
        server.startServer();
    }

    @BeforeClass
    public static void initializeKafkaClients() {
        Map<String, Object> consumerConfig = new HashMap<>();
        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "testClient");
        kafkaConsumer = new KafkaConsumer<>(consumerConfig, new StringDeserializer(), new StringDeserializer());

        Map<String, Object> producerConfig = new HashMap<>();
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
        kafkaProducer = new KafkaProducer<>(producerConfig, new StringSerializer(), new StringSerializer());
    }

    @Test
    public void testBasic() throws InterruptedException, ExecutionException, TimeoutException {
        kafkaConsumer.subscribe(Collections.singleton("test-out"));

        ProducerRecord<String, String> testRecord = new ProducerRecord<String, String>("test-in", "abc");
        kafkaProducer.send(testRecord).get(30, TimeUnit.SECONDS);
        ProducerRecord<String, String> testRecord2 = new ProducerRecord<String, String>("test-in", "xyz");
        kafkaProducer.send(testRecord2).get(30, TimeUnit.SECONDS);

        ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(5));

        Collection<String> values = StreamSupport
                        .stream(records.spliterator(), false)
                        .map(r -> r.value())
                        .collect(Collectors.toList());

        assertThat(values, contains("cba", "zyx"));
    }

    @AfterClass
    public static void teardownConsumer() {
        kafkaConsumer.close();
    }

    @AfterClass
    public static void testdownProducer() {
        kafkaProducer.close();
    }

    @AfterClass
    public static void teardownTest() throws Exception {
        server.stopServer();
    }

}
