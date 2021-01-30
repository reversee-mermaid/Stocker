CREATE TABLE t_user (
	id int unsigned auto_increment,
	nm varchar(20) not null,
	email varchar(50) not null unique,
	pw varchar(100) not null,
	salt varchar(50) not null,
	primary key(id)
);