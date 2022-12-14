create database java_project1;
use java_project1;
create table Team(
	team_id int auto_increment primary key,
	country varchar(30),
	team_name varchar(30)
	);

create table competition(
	competition_id INT auto_increment Primary key,
	competition_name varchar(300)
	);
    
insert into competition(competition_name) values('AI competition');
insert into competition(competition_name) values('machine learning competition');
insert into competition(competition_name) values('sisco competition');

create table competition_participents(
	competition_id INT,
	team_id INT,
	ranking INT,
	constraint fk_competition_id FOREIGN KEY(competition_id) REFERENCES competition(competition_id),
	constraint fk_team_id FOREIGN KEY(team_id) REFERENCES Team(team_id)
	);