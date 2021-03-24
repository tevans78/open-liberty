-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=com.ibm.websphere.appserver.mpConfig-3.0
visibility=public
singleton=true
IBM-App-ForceRestart: install, \
 uninstall
IBM-API-Package: \
  org.eclipse.microprofile.config;  type="stable", \
  org.eclipse.microprofile.config.spi;  type="stable", \
  org.eclipse.microprofile.config.inject;  type="stable", \
  io.smallrye.config; type="internal"
IBM-ShortName: mpConfig-3.0
Subsystem-Name: MicroProfile Config JEE9 3.0
-features=com.ibm.websphere.appserver.org.eclipse.microprofile.config-3.0, \
 io.openliberty.jakarta.cdi-3.0, \
 io.openliberty.jakarta.annotation-2.0, \
 com.ibm.websphere.appserver.containerServices-1.0, \
 com.ibm.websphere.appserver.appmanager-1.0, \
 com.ibm.websphere.appserver.internal.slf4j-1.7.7, \
 io.openliberty.mpCompatible-5.0
-bundles=io.openliberty.io.smallrye.config.jee9, \
 io.openliberty.io.smallrye.common, \
 io.openliberty.microprofile.config.internal.common, \
 io.openliberty.microprofile.config.internal.serverxml, \
 com.ibm.ws.org.apache.commons.lang3, \
 com.ibm.ws.cdi.interfaces.jakarta, \
 com.ibm.ws.org.jboss.logging
kind=noship
edition=full
WLP-Activation-Type: parallel
