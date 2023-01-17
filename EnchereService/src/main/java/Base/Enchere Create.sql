
CREATE TABLE EnchereMove (
  id        SERIAL NOT NULL, 
  dateMise  date, 
  prixMise  float8, 
  Usersid   int4 NOT NULL, 
  State     int4 DEFAULT 0, 
  Enchereid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE EnchereClose (
  dateClos  timestamp, 
  Enchereid int4 NOT NULL);
CREATE TABLE Categorie (
  id  int4 NOT NULL, 
  nom varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE EncherePhoto (
  photo     varchar(255), 
  Enchereid int4 NOT NULL, 
  path      varchar(255));
CREATE TABLE Enchere (
  id            SERIAL NOT NULL, 
  prixmin       float8 NOT NULL, 
  datedebut     timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, 
  dateExp       timestamp NOT NULL, 
  Usersid       int4 NOT NULL, 
  Categorieid   int4 NOT NULL, 
  State         int4 DEFAULT 0 NOT NULL, 
  descriProduit text, 
  durer         float4 DEFAULT 0, 
  PRIMARY KEY (id));

CREATE TABLE Users (
  nom    varchar(255), 
  login  varchar(255), 
  id     SERIAL NOT NULL, 
  mdp    varchar(255), 
  dtn    date, 
  prenom varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE Admin (
  id    SERIAL NOT NULL, 
  login varchar(255), 
  mdp   varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE Compte (
  montant    float8 DEFAULT 0, 
  id         SERIAL NOT NULL, 
  Usersid    int4 NOT NULL, 
  dateReload date, 
  PRIMARY KEY (id));
CREATE TABLE EnchereAdj (
  id            SERIAL NOT NULL, 
  dateAdj       date, 
  Usersid       int4 NOT NULL, 
  EnchereMoveid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Parametrage (
  id    SERIAL NOT NULL, 
  value varchar(255), 
  nom   varchar(255), 
  PRIMARY KEY (id));

ALTER TABLE EnchereMove ADD CONSTRAINT FKEnchereMov363657 FOREIGN KEY (Usersid) REFERENCES Users (id);
ALTER TABLE Enchere ADD CONSTRAINT FKEnchere649256 FOREIGN KEY (Usersid) REFERENCES Users (id);
ALTER TABLE Enchere ADD CONSTRAINT FKEnchere864079 FOREIGN KEY (Categorieid) REFERENCES Categorie (id);
ALTER TABLE EncherePhoto ADD CONSTRAINT FKEncherePho889634 FOREIGN KEY (Enchereid) REFERENCES Enchere (id);
ALTER TABLE EnchereClose ADD CONSTRAINT FKEnchereClo776296 FOREIGN KEY (Enchereid) REFERENCES Enchere (id);
ALTER TABLE EnchereMove ADD CONSTRAINT FKEnchereMov175845 FOREIGN KEY (Enchereid) REFERENCES Enchere (id);
ALTER TABLE EnchereAdj ADD CONSTRAINT FKEnchereAdj78699 FOREIGN KEY (Usersid) REFERENCES Users (id);
ALTER TABLE EnchereAdj ADD CONSTRAINT FKEnchereAdj549353 FOREIGN KEY (EnchereMoveid) REFERENCES EnchereMove (id);
ALTER TABLE Compte ADD CONSTRAINT FKCompte376569 FOREIGN KEY (Usersid) REFERENCES Users (id);
INSERT INTO Categorie(id, nom) VALUES (1, 'Electronique');
INSERT INTO Categorie(id, nom) VALUES (2, 'Menagere');
INSERT INTO Categorie(id, nom) VALUES (3, 'MecaniqueAuto');
INSERT INTO Categorie(id, nom) VALUES (4, 'Vestimentaire');
INSERT INTO Categorie(id, nom) VALUES (5, 'Equipement');
INSERT INTO Categorie(id, nom) VALUES (6, 'Mobilere');
INSERT INTO Categorie(id, nom) VALUES (7, 'Cuisine');
INSERT INTO Categorie(id, nom) VALUES (8, 'Alimentaire');
INSERT INTO Users(nom, login, id, mdp, dtn, prenom) VALUES ('Rakoto', 'rakoto@u.com', 1, 'rakoto', '2000-02-02', 'Kenny');
INSERT INTO Users(nom, login, id, mdp, dtn, prenom) VALUES ('Rabe', 'rabe@u.com', 2, 'rabe', '1999-09-12', 'Antoine');
INSERT INTO Users(nom, login, id, mdp, dtn, prenom) VALUES ('Randria', 'rabdria@u.com', 3, 'randria', '2001-11-11', 'Fidy');
INSERT INTO Admin(id, login, mdp) VALUES (1, 'root', 'root');
INSERT INTO Parametrage(id, value, nom) VALUES (1, '0.10', 'Commiission');
INSERT INTO Parametrage(id, value, nom) VALUES (2, '24', 'HeureMax');
INSERT INTO Parametrage(id, value, nom) VALUES (3, '18', 'AgeMin');
INSERT INTO Parametrage(id, value, nom) VALUES (4, '1', 'DurerMin');
CREATE TABLE DemandeRechargement (
  id             SERIAL NOT NULL, 
  dateDemande    date DEFAULT current_date, 
  State          int4, 
  Usersid        int4 NOT NULL, 
  montant        float8, 
  dateValidation date, 
  PRIMARY KEY (id));
ALTER TABLE DemandeRechargement ADD CONSTRAINT FKDemandeRec298056 FOREIGN KEY (Usersid) REFERENCES Users (id);
alter table compte alter column datereload set default current_date;
create sequence categorie_id_seq;
alter table categorie alter column id set default nextval('categorie_id_seq');
alter table encheremove alter column datemise set default current_date;
select *from encheremove;

alter table compte add column state int default 1;
alter table Enchere alter column dateExp set default CURRENT_TIMESTAMP;

insert into Enchere(prixmin,Usersid,Categorieid,descriProduit,durer)values(100000,1,1,'Asus rog 01',7);
insert into Enchere(prixmin,Usersid,Categorieid,descriProduit,durer)values(70000,2,1,'S20 ultra',3);
insert into Enchere(prixmin,Usersid,Categorieid,descriProduit,durer)values(200000,3,2,'fatana gaz ',7);
insert into Enchere(prixmin,Usersid,Categorieid,descriProduit,durer)values(100000,2,2,'machine a laver SONY',5);
insert into Enchere(prixmin,Usersid,Categorieid,descriProduit,durer)values(60000,1,3,'Moteur RB26DET',7);
insert into Enchere(prixmin,Usersid,Categorieid,descriProduit,durer)values(20000,3,3,'Boite de vitesse sprintera',7);

insert into EnchereMove(Usersid,Enchereid,prixMise)values(2,2,105000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,2,107000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(2,2,110000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,2,111000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(2,2,115000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,2,120000);


insert into EnchereMove(Usersid,Enchereid,prixMise)values(1,3,75000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,3,76000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(1,3,78000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,3,78500);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(1,3,79000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,3,80000);

insert into EnchereMove(Usersid,Enchereid,prixMise)values(1,5,105000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,5,111000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(1,5,120000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,5,125000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(1,5,126000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(3,5,130000);
insert into EnchereMove(Usersid,Enchereid,prixMise)values(2,5,130000);

insert into EnchereAdj (dateAdj,Usersid,EnchereMoveid)values('2023-01-17',3,7);
Update encheremove set state=1 where id=7;
insert into EnchereAdj (dateAdj,Usersid,EnchereMoveid)values('2023-01-17',3,13);
Update encheremove set state=1 where id=13;


/*maka izay user gagnant-----vitaa */
select * from encheremove
where encheremove.enchereid=5
and encheremove.prixmise in(
select max(prixmise) as maximum from encheremove  
where encheremove.enchereid=5
group by enchereid
)

/*maka ny isany ny olona nparticiper --- vita */
select * from(select  count(distinct(usersid)),enchereid from encheremove
group by enchereid)as tab_1 join enchere ON enchere.id = tab_1.enchereid

/* utilisateur le plus actif ---  vita*/
select sum(isa),usersid from (
select count(usersid) as isa,enchereid,usersid from encheremove  
group by enchereid,usersid
)as b
group by usersid

/* enchere be panao ndrindra--- vita */
select  count(distinct(usersid)) as isa,enchereid from encheremove
group by enchereid
order by isa desc 
limit 1

/* encher gagner par utilisateur --vita*/
select count(*),usersid from encheremove where state=1
group by usersid

/* olona nirecaharge ny compteny be nrindra --viitaa */
select count(*) as isa,usersid from compte
group by usersid 
order by isa desc
limit 1

/* categori be mpanao ndrindra */
select count(*) as isa,categorieid from enchere
group by categorieid
order by isa desc
limit 1