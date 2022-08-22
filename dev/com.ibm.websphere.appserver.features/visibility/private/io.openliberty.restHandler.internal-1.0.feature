-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=io.openliberty.restHandler.internal-1.0
WLP-DisableAllFeatures-OnConflict: false
visibility=private

-features=io.openliberty.servlet.api-3.0; ibm.tolerates:="3.1,4.0,5.0,6.0", \
  io.openliberty.restHandler.internal.servlet-3.0; ibm.tolerates:="3.1,4.0,5.0,6.0"

kind=ga
edition=core
WLP-Activation-Type: parallel