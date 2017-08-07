CREATE DATABASE nlp ENCODING 'UTF8';

CREATE TABLE IF NOT EXISTS comment (
    
);

CREATE TABLE IF NOT EXISTS phrases (
    id SERIAL NOT NULL ,
    x INTEGER NOT NULL ,
    y TIMESTAMP NOT NULL ,
    PRIMARY KEY (id)
);

INSERT INTO phrases (id, jsonPhrase)
    VALUES (DEFAULT , '{"jsonPhrase":{"I ":false,"do not ":false,"want ":false,"this ":true,"due to ":false,"future ":false,"fail.":true}}');


DELETE FROM phrases WHERE id = 1;