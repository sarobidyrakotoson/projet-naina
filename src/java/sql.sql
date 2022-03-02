/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 <% for (int i = 0; i < li.size(); i++) {
                TypeContenu c = (TypeContenu) li.get(i);
        %>
        <form method="post" action="listeC.do">
            <input type="hidden" value="<%=c.getId()%>" name="contenu.typecontenuid">
            <input type="submit" style="margin-left: 50px;color: white;background-color: black;border-color: black;border-radius: 2px;width: 200px" value="<% out.println(c.getNom()); %>">
        </form>
        <% }%>    
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
utilisateurid varchar(10),
foreign key (utilisateurid) references utilisateur(id),
foreign key (typecontenuid) references tycontenu(id)
);

alter table contenu add utilisateurid varchar(10);
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


contenuperso:
select  * from contenu where id in( select contenuid from contenu utilisateur where utilisateurid =  )