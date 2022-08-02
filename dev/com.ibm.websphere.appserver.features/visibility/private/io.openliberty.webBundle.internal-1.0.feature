-include= ~${workspace}/cnf/resources/bnd/feature.props

symbolicName = io.openliberty.webBundle.internal-1.0
WLP-DisableAllFeatures-OnConflict: false
visibility = private

-bundles= \
 com.ibm.ws.eba.wab.integrator, \
 com.ibm.ws.app.manager.wab.jakarta; start-phase:=APPLICATION_EARLY

-features=io.openliberty.servlet.internal-5.0; ibm.tolerates:="6.0"

-jars= \
 com.ibm.websphere.appserver.spi.wab.configure; location:=dev/spi/ibm/

edition=full
kind=noship
WLP-Activation-Type: parallel
