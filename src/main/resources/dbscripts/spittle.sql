create table Spittle (
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	message varchar(140) not null,
	created_at timestamp not null,
	latitude double,
	longitude double
);