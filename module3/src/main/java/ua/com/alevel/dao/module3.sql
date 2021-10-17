drop database if exists module3;
create database module3 character set utf8;
use module3;

create table users
(
	id INT(32) not null unique primary key auto_increment,
    email VARCHAR(15) not null unique,
    first_name VARCHAR(15) not null,
    last_name VARCHAR(15) not null,
    password VARCHAR(15) not null
);
insert into users (id,email,first_name,last_name,password) values(1, 'lesya@i.ua','Lesya', 'Gutsul', 'bt54aQ');
insert into users (id,email,first_name,last_name,password) values(2, 'roma@i.ua','Roma', 'Gutsul', 'Szt22Upto');


create table counts
(
    id INT(32) not null unique primary key auto_increment,
    balance BIGINT(32) not null,
	user_id INT(32) not null,
    foreign key (user_id) references users(id)
    on update cascade
    on delete cascade
);
insert into counts(id, balance, user_id) values(1, 100000,1);
insert into counts(id, balance, user_id) values(2, 10000,1);
insert into counts(id, balance, user_id) values(3, 200,2);


create table categories
(
	id INT(32) not null unique primary key auto_increment,
	category_type VARCHAR(8) not null,
	purpose VARCHAR(30)
);
insert into categories(id, category_type, purpose) values(1,'income','work payment');
insert into categories(id, category_type, purpose) values(2,'expense','bills');

create table operations
(
    id INT(32) not null unique primary key auto_increment,
	date_time TIMESTAMP not null,
	money BIGINT(32) not null,
	category_id INT(32) not null,
	count_id INT(32) not null,
    foreign key (category_id) references categories(id),
    foreign key (count_id) references counts(id)
    on update cascade
    on delete cascade
);
insert into operations(id,date_time,money,category_id,count_id)
values(1,'2021-10-07 21:00:00', 2000, 1, 1);