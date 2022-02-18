/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Aroniaina Saotra
 * Created: 17 févr. 2022
 */
create table typecontenu(
id varchar(40) primary key,
nom varchar(20)
);

insert into typecontenu values(1,'annonce'),(2,'note interne'),(3,'Rapport de mission'),(4,'reunion');
insert into utilisateur values(1,'jean','rakoto@gmail.com','mdp',1);


create table utilisateur(
id varchar(40) primary key,
nom varchar(40),
email varchar(30),
mdp varchar(40),
isResponsable int
);

create table contenu (
id varchar(40) primary key,
typecontenuid varchar(40),
titre varchar(20),
description text,
fichier varchar(40),
datecontenu date,
foreign key (typecontenuid) references tycontenu(id)
);

*****idutilisateur
insert into contenu values (nextval('contenu_seq'),1,'contenu','description','fichier','2022-2-12');
insert into contenu values (nextval('contenu_seq'),4,'reunion','description description','fichier','2022-2-14');

create table contenuUtilisateur(
contenuid varchar(10),
utilisateurid varchar(10)
);

create sequence contenu_seq start 1 increment 1;
create sequence utilisateur_seq start 1 increment 1;
create sequence typecontenu_seq start 1 increment 1;

create sequence var_seq start 1 increment 1;


