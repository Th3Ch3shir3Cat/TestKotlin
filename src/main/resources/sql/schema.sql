CREATE EXTENSION IF NOT EXISTS "uuid-ossp" SCHEMA public;
CREATE TABLE IF NOT EXISTS testentity (
    id                     uuid  DEFAULT uuid_generate_v4 () PRIMARY KEY,
    documentId             uuid,
    dictionaryValueId      uuid,
    sortOrder              VARCHAR,
    testid                 uuid,
    testname               VARCHAR
    );

CREATE TABLE IF NOT EXISTS document (
    id                     uuid  DEFAULT uuid_generate_v4 () PRIMARY KEY,
    documentDate           DATE
    );

CREATE TABLE IF NOT EXISTS dictionaryValue (
    id                     uuid  DEFAULT uuid_generate_v4 () PRIMARY KEY,
    dictionaryValueName    uuid
    );
