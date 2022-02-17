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
id varchar(40),
nom varchar(20)
);

create table utilisateur(
id varchar(40),
nom varchar(40),
email varchar(30),
mdp varchar(40),
isResponsable int
);

create table contenu (
id varchar(40),
typecontenuid varchar(40),
titre varchar(20),
description text,
fichier varchar(40),
datecontenu date,
foreign key (typecontenuid) references tycontenu(id)
);

create table contenuUtilisateur(
contenuid varchar(10),
utilisateurid varchar(10)
);
)


