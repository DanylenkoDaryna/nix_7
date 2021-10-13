drop database if exists unit13hibernate;
create database unit13hibernate character set utf8;
use unit13hibernate;

create table courses
(
	id BIGINT(32) not null unique primary key auto_increment,
    course_name VARCHAR(15) not null unique
);
insert into courses (id, course_name) values(1, 'Java 2021');


create table groups
(
    id BIGINT(32) not null unique primary key auto_increment,
    group_name VARCHAR(15) not null unique,
	course_id VARCHAR(15) not null,
    foreign key (course_id) references courses(course_name)
    on update cascade
    on delete cascade
);
insert into groups(id, group_name, course_id) values(1, 'nix-7-1','Java 2021');
insert into groups(id, group_name, course_id) values(2, 'nix-7-2','Java 2021');


create table students
(
    id BIGINT(32) not null unique primary key auto_increment,
	first_name VARCHAR(15) not null,
	middle_name VARCHAR(15),
	last_name VARCHAR(15) not null,
	email VARCHAR(25) not null,
	group_id VARCHAR(15) not null,
    foreign key (group_id) references groups(group_name)
    on update cascade
    on delete cascade
);
insert into students(id, first_name, middle_name, last_name, email, group_id) values(1,'Alyna', 'Anatolyyvna', 'Bezkorovaina', 'bezkorovaina@gmail.com', 'nix-7-1');
insert into students(id, first_name, middle_name, last_name, email, group_id) values(2,'Dariya', 'Avdiyvna', 'Clark', 'clark@gmail.com', 'nix-7-1');
insert into students(id, first_name, middle_name, last_name, email, group_id) values(3,'Serhiy', 'Oleksyovych', 'Voitenko', 'voitenko@gmail.com', 'nix-7-1');
insert into students(id, first_name, middle_name, last_name, email, group_id) values(4,'Maryna', 'Serhiyvna', 'Zvyntar', 'zvyntar@gmail.com', 'nix-7-1');
insert into students(id, first_name, middle_name, last_name, email, group_id) values(5,'Maryna', 'Anatolyyvna', 'Zvyntar', 'marzvyntar@gmail.com', 'nix-7-1');

insert into students(id, first_name, middle_name, last_name, email, group_id) values(6,'Ivan', 'Mychailovych', 'Cherbych', 'cherbych@gmail.com', 'nix-7-2');
insert into students(id, first_name, middle_name, last_name, email, group_id) values(7,'Stanyslav', '', 'Goruna', 'goruna@gmail.com', 'nix-7-2');
insert into students(id, first_name, middle_name, last_name, email, group_id) values(8,'Hanna', '', 'Trincher', 'trincher@gmail.com', 'nix-7-2');
insert into students(id, first_name, middle_name, last_name, email, group_id) values(9,'Anthon', 'Vitalyovych', 'Gordon', 'negondon@gmail.com', 'nix-7-2');
insert into students(id, first_name, middle_name, last_name, email, group_id) values(10,'Kateryna', '', 'Vereschuk', 'vereschuk@gmail.com', 'nix-7-2');

create table topics
(
	id BIGINT(32) not null unique primary key auto_increment,
	topic_name VARCHAR(40) not null
);
insert into topics(id, topic_name) values(1,'Introdusing Java');
insert into topics(id, topic_name) values(2,'JVM, JRE, JDK');
insert into topics(id, topic_name) values(3,'Git, Github');
insert into topics(id, topic_name) values(4,'Maven, Ant, Gradle');
insert into topics(id, topic_name) values(5,'Administration in cmd');
insert into topics(id, topic_name) values(6,'Main Java operations');
insert into topics(id, topic_name) values(7,'Collection Framework');
insert into topics(id, topic_name) values(8,'Exceptions, logs and tests');
insert into topics(id, topic_name) values(9,'JDBC & SQL');
insert into topics(id, topic_name) values(10,'JPA & Hibernate');
insert into topics(id, topic_name) values(11,'Spring Framework');

create table lecturers
(
	id BIGINT(32) not null unique primary key auto_increment,
	first_name VARCHAR(15) not null,
	middle_name VARCHAR(15),
	last_name VARCHAR(15) not null
);
insert into lecturers(id, first_name, middle_name, last_name) values(1,'Bruce', '', 'Eckel');
insert into lecturers(id, first_name, middle_name, last_name) values(2,'Arnold', '', 'Gosling');

create table lessons
(
	id BIGINT(32) not null unique primary key auto_increment,
	topic_id BIGINT(32) not null,
	group_id_name VARCHAR(15) not null,
	lecturer_id BIGINT(32) not null,
	start_date_time TIMESTAMP not null,
	end_date_time TIMESTAMP not null,
	foreign key (topic_id) references topics(id),
	foreign key (group_id_name) references groups(group_name),
	foreign key (lecturer_id) references lecturers(id)
    on update cascade
    on delete cascade
);
insert into lessons(id, topic_id, group_id_name, lecturer_id, start_date_time, end_date_time) values(1,9,'nix-7-1',2,'2021-10-09 11:00:00','2021-10-09 14:00:00');
insert into lessons(id, topic_id, group_id_name, lecturer_id, start_date_time, end_date_time) values(2,9,'nix-7-2',2,'2021-10-07 19:00:00','2021-10-07 21:00:00');
insert into lessons(id, topic_id, group_id_name, lecturer_id, start_date_time, end_date_time) values(3,10,'nix-7-1',1,'2021-10-13 19:00:00','2021-10-13 22:00:00');
insert into lessons(id, topic_id, group_id_name, lecturer_id, start_date_time, end_date_time) values(4,10,'nix-7-2',2,'2021-10-12 19:00:00','2021-10-12 22:00:00');
insert into lessons(id, topic_id, group_id_name, lecturer_id, start_date_time, end_date_time) values(5,11,'nix-7-1',2,'2021-10-16 11:00:00','2021-10-16 15:00:00');
insert into lessons(id, topic_id, group_id_name, lecturer_id, start_date_time, end_date_time) values(6,11,'nix-7-2',1,'2021-10-14 19:00:00','2021-10-14 22:00:00');

create table grades
(
	id BIGINT(32) not null unique primary key auto_increment,
	grade_value INT(32) not null,
	lesson_id BIGINT(32) not null,
	student_id BIGINT(32) not null,
	foreign key (lesson_id) references lessons(id),
	foreign key (student_id) references students(id)
    on update cascade
    on delete cascade
);

insert into grades(id, grade_value, lesson_id, student_id) values(1,10,1,1);
insert into grades(id, grade_value, lesson_id, student_id) values(2,8,3,2);

insert into grades(id, grade_value, lesson_id, student_id) values(3,3,5,3);
insert into grades(id, grade_value, lesson_id, student_id) values(4,7,3,4);

insert into grades(id, grade_value, lesson_id, student_id) values(5,10,5,5);
insert into grades(id, grade_value, lesson_id, student_id) values(6,10,2,6);

insert into grades(id, grade_value, lesson_id, student_id) values(7,7,4,7);
insert into grades(id, grade_value, lesson_id, student_id) values(8,3,6,8);

insert into grades(id, grade_value, lesson_id, student_id) values(9,9,2,9);
insert into grades(id, grade_value, lesson_id, student_id) values(10,5,4,10);