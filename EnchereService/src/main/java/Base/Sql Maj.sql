/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Mofogasy
 * Created: Jan 27, 2023
 */
create table genre(
id serial primary key,
nom varchar(255)
);
insert into genre values (1,'Homme');
insert into genre values (2,'Femme');


Alter table Users Add column genreid int4;
Alter table Users Add Foreign key (genreid) references genre(id);

update users set genreid=1;

