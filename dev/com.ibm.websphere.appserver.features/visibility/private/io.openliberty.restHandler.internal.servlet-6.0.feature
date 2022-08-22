-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=io.openliberty.restHandler.internal.servlet-6.0
singleton=true
WLP-DisableAllFeatures-OnConflict: false
visibility=private

-features=com.ibm.websphere.appserver.json-1.0, \
  com.ibm.wsspi.appserver.webBundleSecurity-1.0, \
  io.openliberty.webBundle.internal-1.0, \
  com.ibm.websphere.appserver.ssl-1.0, \
  io.openliberty.servlet.internal-6.0, \
  com.ibm.websphere.appserver.adminSecurity-2.0, \
  io.openliberty.securityAPI.jakartaee-1.0, \
  io.openliberty.restHandler1.0.internal.ee-9.0, \
  com.ibm.websphere.appserver.httptransport-1.0
-bundles=com.ibm.ws.org.joda.time.1.6.2, \
 com.ibm.websphere.jsonsupport, \
 com.ibm.websphere.rest.handler
-jars=com.ibm.websphere.appserver.spi.restHandler; location:=dev/spi/ibm/
-files=dev/spi/ibm/javadoc/com.ibm.websphere.appserver.spi.restHandler_2.0-javadoc.zip
kind=ga
edition=core
