CREATE TABLE IF NOT EXISTS SEQUENCE (SEQ_NAME VARCHAR(255) NOT NULL, SEQ_COUNT BIGINT, PRIMARY KEY (SEQ_NAME));

INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN_SEQUENCE', 0) ON CONFLICT DO NOTHING;
INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0) ON CONFLICT DO NOTHING;
INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN_TABLE', 0) ON CONFLICT DO NOTHING;
INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) values ('TableType2Generator', 0) ON CONFLICT DO NOTHING;
INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) values ('XMLTableType2Generator', 0) ON CONFLICT DO NOTHING;

CREATE TABLE IF NOT EXISTS AnnEmbedMultiTableEnt (id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS AnnMSCMultiTableEnt (id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS AnnMultiTableEnt (id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS DatatypeSupPropTestEntity (ID INTEGER NOT NULL, BIGDECIMALATTRDEFAULT DECIMAL(38), BIGINTEGERATTRDEFAULT BIGINT, BOOLEANATTRDEFAULT BOOLEAN, BOOLEANWRAPPERATTRDEFAULT BOOLEAN, BYTEARRAYATTRDEFAULT BYTEA, BYTEATTRDEFAULT SMALLINT, BYTEWRAPPERARRAYATTRDEFAULT BYTEA, BYTEWRAPPERATTRDEFAULT SMALLINT, CHARARRAYATTRDEFAULT TEXT, CHARATTRDEFAULT CHAR(1), CHARWRAPPERARRAYATTRDEFAULT TEXT, CHARACTERWRAPPERATTRDEFAULT CHAR(1), DOUBLEATTRDEFAULT FLOAT, DOUBLEWRAPPERATTRDEFAULT FLOAT, ENUMERATION INTEGER, FLOATATTRDEFAULT FLOAT, FLOATWRAPPERATTRDEFAULT FLOAT, INTATTRDEFAULT INTEGER, INTEGERWRAPPERATTRDEFAULT INTEGER, LONGATTRDEFAULT BIGINT, LONGWRAPPERATTRDEFAULT BIGINT, SERIALIZABLECLASS BYTEA, SHORTATTRDEFAULT SMALLINT, SHORTWRAPPERATTRDEFAULT SMALLINT, SQLDATEATTRDEFAULT DATE, SQLTIMEATTRDEFAULT TIME, SQLTIMESTAMPATTRDEFAULT TIMESTAMP, STRINGATTRDEFAULT VARCHAR(255), UTILCALENDARATTRDEFAULT DATE, UTILDATEATTRDEFAULT DATE, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS DatatypeSupTestEntity (ID INTEGER NOT NULL, BIGDECIMALATTRDEFAULT DECIMAL(38), BIGINTEGERATTRDEFAULT BIGINT, BOOLEANATTRDEFAULT BOOLEAN, BOOLEANWRAPPERATTRDEFAULT BOOLEAN, BYTEARRAYATTRDEFAULT BYTEA, BYTEATTRDEFAULT SMALLINT, BYTEWRAPPERARRAYATTRDEFAULT BYTEA, BYTEWRAPPERATTRDEFAULT SMALLINT, CHARARRAYATTRDEFAULT TEXT, CHARATTRDEFAULT CHAR(1), CHARWRAPPERARRAYATTRDEFAULT TEXT, CHARACTERWRAPPERATTRDEFAULT CHAR(1), DOUBLEATTRDEFAULT FLOAT, DOUBLEWRAPPERATTRDEFAULT FLOAT, ENUMERATION INTEGER, FLOATATTRDEFAULT FLOAT, FLOATWRAPPERATTRDEFAULT FLOAT, INTATTRDEFAULT INTEGER, INTEGERWRAPPERATTRDEFAULT INTEGER, LONGATTRDEFAULT BIGINT, LONGWRAPPERATTRDEFAULT BIGINT, SERIALIZABLECLASS BYTEA, SHORTATTRDEFAULT SMALLINT, SHORTWRAPPERATTRDEFAULT SMALLINT, SQLDATEATTRDEFAULT DATE, SQLTIMEATTRDEFAULT TIME, SQLTIMESTAMPATTRDEFAULT TIMESTAMP, STRINGATTRDEFAULT VARCHAR(255), UTILCALENDARATTRDEFAULT DATE, UTILDATEATTRDEFAULT DATE, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS EmbeddableIdEntity (country VARCHAR(255) NOT NULL, id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (country, id));
CREATE TABLE IF NOT EXISTS EMBEDDEDOBJECTAOENTITY (ID INTEGER NOT NULL, LOCALINTVAL INTEGER, LOCALSTRVAL VARCHAR(255), BOOLEANVAL BOOLEAN, BYTEVAL SMALLINT, CHARVAL CHAR(1), DOUBLEVAL FLOAT, FLOATVAL FLOAT, intValCol INTEGER, longValCol BIGINT, SHORTVAL SMALLINT, STRINGVAL VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS EMBEDDEDOBJECTENTITY (ID INTEGER NOT NULL, LOCALINTVAL INTEGER, LOCALSTRVAL VARCHAR(255), BOOLEANVAL BOOLEAN, BYTEVAL SMALLINT, CHARVAL CHAR(1), DOUBLEVAL FLOAT, FLOATVAL FLOAT, INTVAL INTEGER, LONGVAL BIGINT, SHORTVAL SMALLINT, STRINGVAL VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS IdClassEntity (country VARCHAR(255) NOT NULL, id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (country, id));
CREATE TABLE IF NOT EXISTS PKENTITYBYTE (PKEY SMALLINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYBYTEWRAPPER (PKEY SMALLINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYCHAR (PKEY CHAR(1) NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYCHARACTERWRAPPER (PKEY CHAR(1) NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYINT (PKEY INTEGER NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYINTWRAPPER (PKEY INTEGER NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYJAVASQLDATE (PKEY DATE NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYJAVAUTILDATE (PKEY DATE NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYLONG (PKEY BIGINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYLONGWRAPPER (PKEY BIGINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYSHORT (PKEY SMALLINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYSHORTWRAPPER (PKEY SMALLINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKENTITYSTRING (PKEY VARCHAR(255) NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS PKGenAutoEntity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS PKGenIdentityEntity (id BIGSERIAL NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS PKGenTableType1Entity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS PKGenTableType2Entity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS PKGenTableType3Entity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS PKGenTableType4Entity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS ReadOnlyEntity (id INTEGER NOT NULL, intVal INTEGER, noInsertIntVal INTEGER, noUpdatableIntVal INTEGER, readOnlyIntVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS SEC_TABLE1 (id INTEGER, city VARCHAR(255), state VARCHAR(255), street VARCHAR(255), zip VARCHAR(255));
CREATE TABLE IF NOT EXISTS SEC_TABLE2AMSC (id INTEGER, city VARCHAR(255), state VARCHAR(255), street VARCHAR(255), zip VARCHAR(255));
CREATE TABLE IF NOT EXISTS SEC_TABLEEMB (id INTEGER, city VARCHAR(255), state VARCHAR(255), street VARCHAR(255), zip VARCHAR(255));
CREATE TABLE IF NOT EXISTS SerialDatatypeSupPropTE (ID INTEGER NOT NULL, BIGDECIMALATTRDEFAULT DECIMAL(38), BIGINTEGERATTRDEFAULT BIGINT, BOOLEANATTRDEFAULT BOOLEAN, BOOLEANWRAPPERATTRDEFAULT BOOLEAN, BYTEARRAYATTRDEFAULT BYTEA, BYTEATTRDEFAULT SMALLINT, BYTEWRAPPERARRAYATTRDEFAULT BYTEA, BYTEWRAPPERATTRDEFAULT SMALLINT, CHARARRAYATTRDEFAULT TEXT, CHARATTRDEFAULT CHAR(1), CHARWRAPPERARRAYATTRDEFAULT TEXT, CHARACTERWRAPPERATTRDEFAULT CHAR(1), DOUBLEATTRDEFAULT FLOAT, DOUBLEWRAPPERATTRDEFAULT FLOAT, ENUMERATION INTEGER, FLOATATTRDEFAULT FLOAT, FLOATWRAPPERATTRDEFAULT FLOAT, INTATTRDEFAULT INTEGER, INTEGERWRAPPERATTRDEFAULT INTEGER, LONGATTRDEFAULT BIGINT, LONGWRAPPERATTRDEFAULT BIGINT, SERIALIZABLECLASS BYTEA, SHORTATTRDEFAULT SMALLINT, SHORTWRAPPERATTRDEFAULT SMALLINT, SQLDATEATTRDEFAULT DATE, SQLTIMEATTRDEFAULT TIME, SQLTIMESTAMPATTRDEFAULT TIMESTAMP, STRINGATTRDEFAULT VARCHAR(255), UTILCALENDARATTRDEFAULT DATE, UTILDATEATTRDEFAULT DATE, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS SerialDatatypeSupTE (ID INTEGER NOT NULL, BIGDECIMALATTRDEFAULT DECIMAL(38), BIGINTEGERATTRDEFAULT BIGINT, BOOLEANATTRDEFAULT BOOLEAN, BOOLEANWRAPPERATTRDEFAULT BOOLEAN, BYTEARRAYATTRDEFAULT BYTEA, BYTEATTRDEFAULT SMALLINT, BYTEWRAPPERARRAYATTRDEFAULT BYTEA, BYTEWRAPPERATTRDEFAULT SMALLINT, CHARARRAYATTRDEFAULT TEXT, CHARATTRDEFAULT CHAR(1), CHARWRAPPERARRAYATTRDEFAULT TEXT, CHARACTERWRAPPERATTRDEFAULT CHAR(1), DOUBLEATTRDEFAULT FLOAT, DOUBLEWRAPPERATTRDEFAULT FLOAT, ENUMERATION INTEGER, FLOATATTRDEFAULT FLOAT, FLOATWRAPPERATTRDEFAULT FLOAT, INTATTRDEFAULT INTEGER, INTEGERWRAPPERATTRDEFAULT INTEGER, LONGATTRDEFAULT BIGINT, LONGWRAPPERATTRDEFAULT BIGINT, SERIALIZABLECLASS BYTEA, SHORTATTRDEFAULT SMALLINT, SHORTWRAPPERATTRDEFAULT SMALLINT, SQLDATEATTRDEFAULT DATE, SQLTIMEATTRDEFAULT TIME, SQLTIMESTAMPATTRDEFAULT TIMESTAMP, STRINGATTRDEFAULT VARCHAR(255), UTILCALENDARATTRDEFAULT DATE, UTILDATEATTRDEFAULT DATE, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS TableIDGenTable (GEN_NAME VARCHAR(50) NOT NULL, GEN_VAL DECIMAL(38), PRIMARY KEY (GEN_NAME));
CREATE TABLE IF NOT EXISTS TableIDGen4Table (GEN_NAME VARCHAR(50) NOT NULL, GEN_VAL DECIMAL(38), PRIMARY KEY (GEN_NAME));
CREATE TABLE IF NOT EXISTS VersionedIntEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS VersionedIntWrapperEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS VersionedLongEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version BIGINT, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS VersionedLongWrapperEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version BIGINT, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS VersionedShortEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version SMALLINT, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS VersionedShortWrapperEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version SMALLINT, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS VersionedSqlTimestampEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version TIMESTAMP, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS XMLDatatypeSupPropTestEntity (ID INTEGER NOT NULL, BIGDECIMALATTRDEFAULT DECIMAL(38), BIGINTEGERATTRDEFAULT BIGINT, BOOLEANATTRDEFAULT BOOLEAN, BOOLEANWRAPPERATTRDEFAULT BOOLEAN, BYTEARRAYATTRDEFAULT BYTEA, BYTEATTRDEFAULT SMALLINT, BYTEWRAPPERARRAYATTRDEFAULT BYTEA, BYTEWRAPPERATTRDEFAULT SMALLINT, CHARARRAYATTRDEFAULT TEXT, CHARATTRDEFAULT CHAR(1), CHARWRAPPERARRAYATTRDEFAULT TEXT, CHARACTERWRAPPERATTRDEFAULT CHAR(1), DOUBLEATTRDEFAULT FLOAT, DOUBLEWRAPPERATTRDEFAULT FLOAT, ENUMERATION INTEGER, FLOATATTRDEFAULT FLOAT, FLOATWRAPPERATTRDEFAULT FLOAT, INTATTRDEFAULT INTEGER, INTEGERWRAPPERATTRDEFAULT INTEGER, LONGATTRDEFAULT BIGINT, LONGWRAPPERATTRDEFAULT BIGINT, SERIALIZABLECLASS BYTEA, SHORTATTRDEFAULT SMALLINT, SHORTWRAPPERATTRDEFAULT SMALLINT, SQLDATEATTRDEFAULT DATE, SQLTIMEATTRDEFAULT TIME, SQLTIMESTAMPATTRDEFAULT TIMESTAMP, STRINGATTRDEFAULT VARCHAR(255), UTILCALENDARATTRDEFAULT DATE, UTILDATEATTRDEFAULT DATE, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS XMLDatatypeSupTestEntity (ID INTEGER NOT NULL, BIGDECIMALATTRDEFAULT DECIMAL(38), BIGINTEGERATTRDEFAULT BIGINT, BOOLEANATTRDEFAULT BOOLEAN, BOOLEANWRAPPERATTRDEFAULT BOOLEAN, BYTEARRAYATTRDEFAULT BYTEA, BYTEATTRDEFAULT SMALLINT, BYTEWRAPPERARRAYATTRDEFAULT BYTEA, BYTEWRAPPERATTRDEFAULT SMALLINT, CHARARRAYATTRDEFAULT TEXT, CHARATTRDEFAULT CHAR(1), CHARWRAPPERARRAYATTRDEFAULT TEXT, CHARACTERWRAPPERATTRDEFAULT CHAR(1), DOUBLEATTRDEFAULT FLOAT, DOUBLEWRAPPERATTRDEFAULT FLOAT, ENUMERATION INTEGER, FLOATATTRDEFAULT FLOAT, FLOATWRAPPERATTRDEFAULT FLOAT, INTATTRDEFAULT INTEGER, INTEGERWRAPPERATTRDEFAULT INTEGER, LONGATTRDEFAULT BIGINT, LONGWRAPPERATTRDEFAULT BIGINT, SERIALIZABLECLASS BYTEA, SHORTATTRDEFAULT SMALLINT, SHORTWRAPPERATTRDEFAULT SMALLINT, SQLDATEATTRDEFAULT DATE, SQLTIMEATTRDEFAULT TIME, SQLTIMESTAMPATTRDEFAULT TIMESTAMP, STRINGATTRDEFAULT VARCHAR(255), UTILCALENDARATTRDEFAULT DATE, UTILDATEATTRDEFAULT DATE, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS XMLEmbeddableIdEntity (country VARCHAR(255) NOT NULL, id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (country, id));
CREATE TABLE IF NOT EXISTS XMLEMBEDDEDOBJECTAOENTITY (ID INTEGER NOT NULL, LOCALINTVAL INTEGER, LOCALSTRVAL VARCHAR(255), BOOLEANVAL BOOLEAN, BYTEVAL SMALLINT, CHARVAL CHAR(1), DOUBLEVAL FLOAT, FLOATVAL FLOAT, intValCol INTEGER, longValCol BIGINT, SHORTVAL SMALLINT, STRINGVAL VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS XMLEMBEDDEDOBJECTENTITY (ID INTEGER NOT NULL, LOCALINTVAL INTEGER, LOCALSTRVAL VARCHAR(255), BOOLEANVAL BOOLEAN, BYTEVAL SMALLINT, CHARVAL CHAR(1), DOUBLEVAL FLOAT, FLOATVAL FLOAT, INTVAL INTEGER, LONGVAL BIGINT, SHORTVAL SMALLINT, STRINGVAL VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS XMLEmbedMultiTableEnt (id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLIdClassEntity (country VARCHAR(255) NOT NULL, id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (country, id));
CREATE TABLE IF NOT EXISTS XMLMSCMultiTableEnt (id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLMultiTableEnt (id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLPKENTITYBYTE (PKEY SMALLINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYBYTEWRAPPER (PKEY SMALLINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYCHAR (PKEY CHAR(1) NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYCHARACTERWRAPPER (PKEY CHAR(1) NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYINT (PKEY INTEGER NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYINTWRAPPER (PKEY INTEGER NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYJAVASQLDATE (PKEY DATE NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYJAVAUTILDATE (PKEY DATE NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYLONG (PKEY BIGINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYLONGWRAPPER (PKEY BIGINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYSHORT (PKEY SMALLINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYSHORTWRAPPER (PKEY SMALLINT NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKENTITYSTRING (PKEY VARCHAR(255) NOT NULL, INTVAL INTEGER, PRIMARY KEY (PKEY));
CREATE TABLE IF NOT EXISTS XMLPKGenAutoEntity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLPKGenIdentityEntity (id BIGSERIAL NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLPKGenTableType1Entity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLPKGenTableType2Entity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLPKGenTableType3Entity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLPKGenTableType4Entity (id INTEGER NOT NULL, intVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLReadOnlyEntity (id INTEGER NOT NULL, intVal INTEGER, noInsertIntVal INTEGER, noUpdatableIntVal INTEGER, readOnlyIntVal INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLSerialDatatypeSupPropTE (ID INTEGER NOT NULL, BIGDECIMALATTRDEFAULT DECIMAL(38), BIGINTEGERATTRDEFAULT BIGINT, BOOLEANATTRDEFAULT BOOLEAN, BOOLEANWRAPPERATTRDEFAULT BOOLEAN, BYTEARRAYATTRDEFAULT BYTEA, BYTEATTRDEFAULT SMALLINT, BYTEWRAPPERARRAYATTRDEFAULT BYTEA, BYTEWRAPPERATTRDEFAULT SMALLINT, CHARARRAYATTRDEFAULT TEXT, CHARATTRDEFAULT CHAR(1), CHARWRAPPERARRAYATTRDEFAULT TEXT, CHARACTERWRAPPERATTRDEFAULT CHAR(1), DOUBLEATTRDEFAULT FLOAT, DOUBLEWRAPPERATTRDEFAULT FLOAT, ENUMERATION INTEGER, FLOATATTRDEFAULT FLOAT, FLOATWRAPPERATTRDEFAULT FLOAT, INTATTRDEFAULT INTEGER, INTEGERWRAPPERATTRDEFAULT INTEGER, LONGATTRDEFAULT BIGINT, LONGWRAPPERATTRDEFAULT BIGINT, SERIALIZABLECLASS BYTEA, SHORTATTRDEFAULT SMALLINT, SHORTWRAPPERATTRDEFAULT SMALLINT, SQLDATEATTRDEFAULT DATE, SQLTIMEATTRDEFAULT TIME, SQLTIMESTAMPATTRDEFAULT TIMESTAMP, STRINGATTRDEFAULT VARCHAR(255), UTILCALENDARATTRDEFAULT DATE, UTILDATEATTRDEFAULT DATE, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS XMLSerialDatatypeSupTE (ID INTEGER NOT NULL, BIGDECIMALATTRDEFAULT DECIMAL(38), BIGINTEGERATTRDEFAULT BIGINT, BOOLEANATTRDEFAULT BOOLEAN, BOOLEANWRAPPERATTRDEFAULT BOOLEAN, BYTEARRAYATTRDEFAULT BYTEA, BYTEATTRDEFAULT SMALLINT, BYTEWRAPPERARRAYATTRDEFAULT BYTEA, BYTEWRAPPERATTRDEFAULT SMALLINT, CHARARRAYATTRDEFAULT TEXT, CHARATTRDEFAULT CHAR(1), CHARWRAPPERARRAYATTRDEFAULT TEXT, CHARACTERWRAPPERATTRDEFAULT CHAR(1), DOUBLEATTRDEFAULT FLOAT, DOUBLEWRAPPERATTRDEFAULT FLOAT, ENUMERATION INTEGER, FLOATATTRDEFAULT FLOAT, FLOATWRAPPERATTRDEFAULT FLOAT, INTATTRDEFAULT INTEGER, INTEGERWRAPPERATTRDEFAULT INTEGER, LONGATTRDEFAULT BIGINT, LONGWRAPPERATTRDEFAULT BIGINT, SERIALIZABLECLASS BYTEA, SHORTATTRDEFAULT SMALLINT, SHORTWRAPPERATTRDEFAULT SMALLINT, SQLDATEATTRDEFAULT DATE, SQLTIMEATTRDEFAULT TIME, SQLTIMESTAMPATTRDEFAULT TIMESTAMP, STRINGATTRDEFAULT VARCHAR(255), UTILCALENDARATTRDEFAULT DATE, UTILDATEATTRDEFAULT DATE, PRIMARY KEY (ID));
CREATE TABLE IF NOT EXISTS XMLTableIDGenTable (GEN_NAME VARCHAR(50) NOT NULL, GEN_VAL DECIMAL(38), PRIMARY KEY (GEN_NAME));
CREATE TABLE IF NOT EXISTS XMLTableIDGen4Table (GEN_NAME VARCHAR(50) NOT NULL, GEN_VAL DECIMAL(38), PRIMARY KEY (GEN_NAME));
CREATE TABLE IF NOT EXISTS XMLVersionedIntEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLVersionedIntWrapperEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version INTEGER, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLVersionedLongEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version BIGINT, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLVersionedLongWrapperEnt (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version BIGINT, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLVersionedShortEntity (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version SMALLINT, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLVersionedShortWrapperEnt (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version SMALLINT, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XMLVersionedSqlTimestampEnt (id INTEGER NOT NULL, intVal INTEGER, stringVal VARCHAR(255), version TIMESTAMP, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS XSEC_TABLE1 (id INTEGER, city VARCHAR(255), state VARCHAR(255), street VARCHAR(255), zip VARCHAR(255));
CREATE TABLE IF NOT EXISTS XSEC_TABLE2AMSC (id INTEGER, city VARCHAR(255), state VARCHAR(255), street VARCHAR(255), zip VARCHAR(255));
CREATE TABLE IF NOT EXISTS XSEC_TABLEEMB (id INTEGER, city VARCHAR(255), state VARCHAR(255), street VARCHAR(255), zip VARCHAR(255));

INSERT INTO TableIDGenTable(GEN_NAME, GEN_VAL) values ('TableType3Generator', 0) ON CONFLICT DO NOTHING;
INSERT INTO TableIDGen4Table(GEN_NAME, GEN_VAL) values ('TableType4Generator', 0) ON CONFLICT DO NOTHING;
INSERT INTO XMLTableIDGenTable(GEN_NAME, GEN_VAL) values ('XMLTableType3Generator', 0) ON CONFLICT DO NOTHING;
INSERT INTO XMLTableIDGen4Table(GEN_NAME, GEN_VAL) values ('XMLTableType4Generator', 0) ON CONFLICT DO NOTHING;

CREATE INDEX IF NOT EXISTS I_SC_TBL1_ID ON SEC_TABLE1 (id);
CREATE INDEX IF NOT EXISTS I_SC_TMSC_ID ON SEC_TABLE2AMSC (id);
CREATE INDEX IF NOT EXISTS I_SC_TLMB_ID ON SEC_TABLEEMB (id);
CREATE INDEX IF NOT EXISTS I_XSC_BL1_ID ON XSEC_TABLE1 (id);
CREATE INDEX IF NOT EXISTS I_XSC_MSC_ID ON XSEC_TABLE2AMSC (id);
CREATE INDEX IF NOT EXISTS I_XSC_LMB_ID ON XSEC_TABLEEMB (id);

create schema jpaschema;

CREATE TABLE IF NOT EXISTS jpaschema.ACfgFldEn (id INTEGER NOT NULL, floatValColumnPrecision NUMERIC, floatValColumnScale NUMERIC, intValColName INTEGER, notNullable BYTEA NOT NULL, stringValColumnLength VARCHAR(12), stringValEager VARCHAR(255), stringValLazy VARCHAR(255), stringValOptional VARCHAR(255), uniqueConstraintString VARCHAR(255) NOT NULL, uniqueString VARCHAR(255) NOT NULL, PRIMARY KEY (id), CONSTRAINT U_CFGFLDN_UNIQUESTRING UNIQUE (uniqueString), CONSTRAINT U_CFGFLDN_UNIQUECONSTRAINTSTRING UNIQUE (uniqueConstraintString));
CREATE TABLE IF NOT EXISTS jpaschema.AltColumnTable (ATTRCONFIGFIELDENTITY_ID INTEGER, id INTEGER, intValCol INTEGER);
CREATE TABLE IF NOT EXISTS jpaschema.XACfgFldE (id INTEGER NOT NULL, floatValColumnPrecision NUMERIC, floatValColumnScale NUMERIC, intValColName INTEGER, notNullable BYTEA NOT NULL, stringValColumnLength VARCHAR(12), stringValEager VARCHAR(255), stringValLazy VARCHAR(255), stringValOptional VARCHAR(255), uniqueConstraintString VARCHAR(255) NOT NULL, uniqueString VARCHAR(255) NOT NULL, PRIMARY KEY (id), CONSTRAINT U_XCFGFLD_UNIQUESTRING UNIQUE (uniqueString), CONSTRAINT U_XCFGFLD_UNIQUECONSTRAINTSTRING UNIQUE (uniqueConstraintString));
CREATE TABLE IF NOT EXISTS jpaschema.XAltColumnTable (XMLATTRCONFIGFIELDENTITY_ID INTEGER, id INTEGER, XMLIntValCol INTEGER);

CREATE INDEX IF NOT EXISTS I_LTCLTBL_ATTRCONFIGFIELDENTITY_ID ON jpaschema.AltColumnTable (ATTRCONFIGFIELDENTITY_ID);
CREATE INDEX IF NOT EXISTS I_XLTCTBL_XMLATTRCONFIGFIELDENTITY_ID ON jpaschema.XAltColumnTable (XMLATTRCONFIGFIELDENTITY_ID);
