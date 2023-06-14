create table Users
(
    id       serial primary key,
    name     varchar(70) not null,
    username varchar(70) not null,
    email    varchar(70) not null,
    password varchar(70) not null
);
create table Brand
(
    id          serial primary key,
    name        varchar(70) not null,
    website     varchar(70) not null,
    description text
);
create table Category
(
    id          serial primary key,
    name        varchar(70) not null,
    description text
);
create table Product
(
    id          serial primary key,
    name        varchar(70) not null,
    create_date date        not null,
    category_id int references Category (id),
    brand_id    int references Brand (id)
);
create table Shareholder
(
    id            serial primary key,
    name          varchar(70) not null,
    phone_number  varchar(70) not null,
    national_code varchar(70) not null
);
create table ShareholderBrand
(
    shareholder_id int references Shareholder (id),
    brand_id       int references Brand (id),
    primary key (shareholder_id, brand_id)
);