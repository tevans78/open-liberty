-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=io.openliberty.mpReactiveMessaging-3.0
WLP-DisableAllFeatures-OnConflict: false
visibility=public
singleton=true
IBM-App-ForceRestart: install, \
 uninstall
IBM-API-Package: \
  org.eclipse.microprofile.reactive.messaging;  type="stable", \
  org.eclipse.microprofile.reactive.messaging.spi; type="stable", \
  com.ibm.ws.kafka.security; type="internal"
IBM-ShortName: mpReactiveMessaging-3.0
Subsystem-Name: MicroProfile Reactive Messaging 3.0
-features=io.openliberty.mpConfig-3.0, \
  io.openliberty.mpReactiveStreams-3.0, \
  io.openliberty.mpCompatible-5.0; ibm.tolerates:="6.0", \
  io.openliberty.org.eclipse.microprofile.reactive.messaging-3.0, \
  io.openliberty.jakarta.cdi-3.0; ibm.tolerates:="4.0", \
  io.openliberty.concurrent-2.0; ibm.tolerates:="3.0"
-bundles=com.ibm.ws.io.smallrye.reactive.messaging-provider, \
 com.ibm.ws.io.reactivex.rxjava.2.2, \
 com.ibm.ws.org.apache.commons.lang3, \
 com.ibm.ws.microprofile.reactive.messaging.kafka, \
 com.ibm.ws.microprofile.reactive.messaging.kafka.adapter, \
 com.ibm.ws.microprofile.reactive.messaging.kafka.adapter.impl
kind=noship
edition=full
WLP-Activation-Type: parallel
