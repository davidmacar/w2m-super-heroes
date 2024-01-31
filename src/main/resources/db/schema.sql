create table hero
(
    superHeroName varchar(50) not null,
    realName varchar(50) not null,
    universe varchar(20) not null,
    power varchar(100) not null,
    primary key (superHeroName)
);

CREATE TYPE ROLE AS ENUM ('ADMIN', 'USER');

create table userApi
(
    username varchar(50) not null,
    password varchar(150) not null,
    role ROLE not null,
    primary key (username)
);