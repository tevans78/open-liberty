-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=io.openliberty.jwt.internal-1.0
WLP-DisableAllFeatures-OnConflict: false
visibility=private
-features=io.openliberty.webBundleSecurity.internal-1.0, \
  io.openliberty.webBundle.internal-1.0, \
  io.openliberty.servlet.internal-5.0; ibm.tolerates:="6.0", \
  io.openliberty.jwt1.0.internal.ee-9.0, \
  com.ibm.websphere.appserver.internal.slf4j-1.7
-bundles=\
  com.ibm.ws.org.apache.httpcomponents, \
  io.openliberty.org.apache.commons.logging, \
  com.ibm.ws.security.common.jsonwebkey, \
  io.openliberty.org.apache.commons.codec, \
  com.ibm.ws.org.jose4j, \
  io.openliberty.com.google.gson, \
  com.ibm.json4j
-jars=\
  com.ibm.websphere.appserver.api.jwt; location:=dev/api/ibm/, \
  io.openliberty.jwt; location:=dev/api/ibm/

kind=noship
edition=full
