CREATE TABLE IF NOT EXISTS news
(
    id    SERIAL PRIMARY KEY ,
    title  VARCHAR(200) NOT NULL ,
    description VARCHAR(10000) NULL ,
    author bigserial  NOT NULL,
    date timestamp NOT NULL
);

--DROP TABLE if EXISTS  news;

CREATE TABLE IF NOT EXISTS authors
(
    id    SERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    org_name VARCHAR(200) NOT NULL
);

--drop table if exists authors;