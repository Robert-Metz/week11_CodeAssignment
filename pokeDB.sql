create database if not exists poke;

use poke;

drop table if exists pokemon;


create table pokemon (

	id int(5) NOT NULL auto_increment,
	name varchar(50) NOT NULL,
	type varchar(50) NOT NULL,
	pokeSet int(10) NOT NULL,
	primary key (id)
);
