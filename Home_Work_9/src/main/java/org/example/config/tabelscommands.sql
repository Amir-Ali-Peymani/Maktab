create table Users
(
    id       serial primary key,
    name     varchar(50) not null,
    username varchar(50) not null,
    password varchar(50) not null
);
create table Category
(
    id   serial primary key,
    name varchar(50) not null
);
create table Product
(
    id         serial primary key,
    name       varchar(50) not null,
    price      int         not null,
    categoryId int references Category (id),
    count      int         not null
);
create table Cart
(
    id     serial primary key,
    userId int references Users (id),
    date   date
);
create table BuyingItem
(
    id        serial primary key,
    productId int references Product (id),
    cartId    int references Cart (id)
);