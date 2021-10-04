drop database if exists unit10db;
create database unit10db character set utf8;
use unit10db;
create table locations
(
    id INT(32) not null primary key auto_increment unique,
    name VARCHAR(15) not null unique
);

insert into locations (id, name) values(default,'gdansk');
insert into locations (id, name) values(default,'bydgoszcz');
insert into locations (id, name) values(default,'torun');
insert into locations (id, name) values(default,'warszawa');

create table routes
(
    id INT(32) not null primary key auto_increment unique,
	from_id INT(32) not null,
	to_id INT(32) not null,
	cost INT(32) not null,
    foreign key (from_id) references locations(id),
    foreign key (to_id) references locations(id)
    on update cascade
    on delete cascade
);

insert into routes(id, from_id, to_id, cost) values(default,1,2,1);
insert into routes(id, from_id, to_id, cost) values(default,1,3,3);

insert into routes(id, from_id, to_id, cost) values(default,2,1,1);
insert into routes(id, from_id, to_id, cost) values(default,2,3,1);
insert into routes(id, from_id, to_id, cost) values(default,2,4,4);

insert into routes(id, from_id, to_id, cost) values(default,3,1,3);
insert into routes(id, from_id, to_id, cost) values(default,3,2,1);
insert into routes(id, from_id, to_id, cost) values(default,3,4,1);

insert into routes(id, from_id, to_id, cost) values(default,4,2,4);
insert into routes(id, from_id, to_id, cost) values(default,4,3,1);

create table problems
(
    id INT(32) not null unique primary key auto_increment,
	from_id INT(32) not null,
	to_id INT(32) not null,
    foreign key (from_id) references locations(id),
    foreign key (to_id) references locations(id)
    on update cascade
    on delete cascade
);

insert into problems(id, from_id, to_id) values(default,1,4);
insert into problems(id, from_id, to_id) values(default,2,4);
insert into problems(id, from_id, to_id) values(default,1,2);
insert into problems(id, from_id, to_id) values(default,4,2);
insert into problems(id, from_id, to_id) values(default,3,3);

create table solutions
(
	problem_id INT(32) not null primary key,
	cost INT(32),
    foreign key (problem_id) references problems(id)
    on delete cascade
    on update cascade
);