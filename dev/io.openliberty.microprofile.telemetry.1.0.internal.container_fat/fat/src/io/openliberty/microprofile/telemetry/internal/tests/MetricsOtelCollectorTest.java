/*******************************************************************************
 * Copyright (c) 2024 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.microprofile.telemetry.internal.tests;

import static com.ibm.websphere.simplicity.ShrinkHelper.DeployOptions.SERVER_ONLY;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.File;
import java.util.List;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.runner.RunWith;
import org.testcontainers.containers.Network;

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.log.Log;

import componenttest.annotation.Server;
import componenttest.containers.SimpleLogConsumer;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.custom.junit.runner.RepeatTestFilter;
import componenttest.rules.repeater.MicroProfileActions;
import io.openliberty.microprofile.telemetry.internal_fat.shared.TelemetryActions;
import componenttest.rules.repeater.RepeatTests;
import componenttest.annotation.SkipForRepeat;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.HttpRequest;
import io.openliberty.microprofile.telemetry.internal.apps.spanTest.TestResource;
import io.openliberty.microprofile.telemetry.internal.suite.FATSuite;
import io.openliberty.microprofile.telemetry.internal.utils.TestConstants;
import io.openliberty.microprofile.telemetry.internal.utils.otelCollector.OtelCollectorContainer;
import io.openliberty.microprofile.telemetry.internal.utils.otelCollector.OtelCollectorQueryClient;
// In MpTelemetry-2.0 SemanticAttributes was moved to a new package, so we use import static to allow both versions to coexist
import static io.opentelemetry.semconv.SemanticAttributes.HTTP_ROUTE;
import static io.opentelemetry.semconv.SemanticAttributes.HTTP_REQUEST_METHOD;

/**
 * Test exporting metrics to a OpenTelemetry Collector
 */
@RunWith(FATRunner.class)
public class MetricsOtelCollectorTest {

    private static final String SERVER_NAME = "spanTestServer";

    public static Network network = Network.newNetwork();
    public static OtelCollectorContainer otelCollectorContainer = new OtelCollectorContainer(new File("lib/LibertyFATTestFiles/otel-collector-config-metrics.yaml"))
                                                                                                                                                                   .withNetwork(network)
                                                                                                                                                                   .withNetworkAliases("otel-collector-metrics")
                                                                                                                                                                   .withLogConsumer(new SimpleLogConsumer(MetricsOtelCollectorTest.class,
                                                                                                                                                                                                          "otelCol"));
    public static RepeatTests repeat = FATSuite.telemetry20Repeats(SERVER_NAME);

    @ClassRule
    public static RuleChain chain = RuleChain.outerRule(network)
                                             .around(otelCollectorContainer)
                                             .around(repeat);

    public OtelCollectorQueryClient client = new OtelCollectorQueryClient(otelCollectorContainer);

    @Server(SERVER_NAME)
    public static LibertyServer server;

    @BeforeClass
    public static void setUp() throws Exception {

        server.addEnvVar(TestConstants.ENV_OTEL_TRACES_EXPORTER, "otlp");
        server.addEnvVar(TestConstants.ENV_OTEL_LOGS_EXPORTER, "none");
        server.addEnvVar(TestConstants.ENV_OTEL_METRIC_EXPORT_INTERVAL, "1000");
        server.addEnvVar(TestConstants.ENV_OTEL_METRICS_EXPORTER, "logging");
        server.addEnvVar(TestConstants.ENV_OTEL_EXPORTER_OTLP_ENDPOINT, otelCollectorContainer.getOtlpGrpcUrl());
        server.addEnvVar(TestConstants.ENV_OTEL_SERVICE_NAME, "Test service");
        server.addEnvVar(TestConstants.ENV_OTEL_BSP_SCHEDULE_DELAY, "100"); // Wait no more than 100ms to send traces to the server
        server.addEnvVar(TestConstants.ENV_OTEL_SDK_DISABLED, "false"); //Enable tracing

        // Construct the test application
        WebArchive spanTest = ShrinkWrap.create(WebArchive.class, "spanTest.war")
                                        .addPackage(TestResource.class.getPackage());
        ShrinkHelper.exportAppToServer(server, spanTest, SERVER_ONLY);
        server.startServer();
    }

    @AfterClass
    public static void teardown() throws Exception {
        server.stopServer();
    }

    @Test
    public void testBasicTelemetry2() throws Exception {
        String metrics = "gauge";
        System.out.println(metrics);
        Thread.sleep(10000);
        client.dumpMetrics();
        assertThat(metrics, containsString("gauge"));

    }

}
