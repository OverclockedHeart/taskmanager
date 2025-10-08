CREATE DATABASE emailsaver;

CREATE TABLE emails (

    id BIGSERIAL PRIMARY KEY,

    email text,
    email_censored text,
    email_hash text 

);