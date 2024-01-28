create table hero
(
    superHeroName varchar(50) not null,
    realName varchar(50) not null,
    universe varchar(20) not null,
    power varchar(100) not null,
    primary key (superHeroName)
);

create table apiUser
(
    username varchar(50) not null,
    password varchar(20) not null,
    role varchar(20) not null,
    primary key (username)
);