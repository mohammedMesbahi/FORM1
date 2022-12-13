create database java_project1;
use java_project1;
create table Team(
	team_id int auto_increment primary key,
	country varchar(30),
	team_name varchar(30)
	);

create table Comptetation(
	competation_id INT auto_increment Primary key,
	competation_name varchar(300)
	);

create table Competaion_participents(
	competation_id INT,
	team_id INT,
	ranking INT,
	constraint fk_competation_id FOREIGN KEY(competation_id) REFERENCES comptetation(competation_id),
	constraint fk_team_id FOREIGN KEY(team_id) REFERENCES Team(team_id)
	);