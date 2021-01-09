CREATE TABLE t_article (
	id int unsigned auto_increment,
	title varchar(50) not null,
	caption varchar(300),
	file_nm varchar(100) not null unique,
	regdate datetime default now(),
	author_id int unsigned,
	primary key(id),
	foreign key(author_id) references t_user(id)
);