-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=io.openliberty.webBundleSecurity.internal-1.0
WLP-DisableAllFeatures-OnConflict: false
visibility=private
-features=com.ibm.websphere.appserver.containerServices-1.0, \
  io.openliberty.servlet.internal-5.0; ibm.tolerates:="6.0", \
  com.ibm.websphere.appserver.distributedMap-1.0, \
  com.ibm.websphere.appserver.security-1.0, \
  io.openliberty.securityAPI.javaee-1.0, \
  io.openliberty.securityAPI.jakarta-1.0, \
  com.ibm.websphere.appserver.authFilter-1.0
-bundles=com.ibm.websphere.security, \
  com.ibm.ws.webcontainer.security.feature, \
  com.ibm.ws.security.authorization.builtin, \
  io.openliberty.webcontainer.security.internal; start-phase:=SERVICE_EARLY, \
  io.openliberty.security.authentication.internal.filter, \
  io.openliberty.security.authentication.internal.tai, \
  io.openliberty.security.sso.internal, \
  com.ibm.ws.app.manager.wab.jakarta; start-phase:=APPLICATION_EARLY
kind=noship
edition=full
