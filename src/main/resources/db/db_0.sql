create table if not exists users (
                       username varchar(128) PRIMARY KEY,
                       password varchar(128) NOT NULL,
                       enabled boolean NOT NULL
);