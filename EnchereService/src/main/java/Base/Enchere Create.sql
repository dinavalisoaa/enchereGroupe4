DROP TABLE if exists AppelEnchere cascade;
DROP TABLE if exists AppelEnchereClose cascade;
DROP TABLE if exists Compte cascade;
DROP TABLE if exists Enchere cascade;
DROP TABLE if exists EnchereAdj cascade;
DROP TABLE if exists EncherePhoto cascade;
DROP TABLE if exists Produit cascade;
DROP TABLE if exists ProduitUsers cascade;
DROP TABLE if exists StateVente cascade;
DROP TABLE if exists Users cascade;
DROP TABLE if exists Admin cascade;
DROP TABLE if exists Categorie cascade;


CREATE TABLE AppelEnchere (
  id             SERIAL NOT NULL,
  ProduitUsersid int4 NOT NULL, 
  prixmin        float8 NOT NULL, 
  datedebut      timestamp NOT NULL, 
  dateExp        timestamp NOT NULL, 
  PRIMARY KEY (id));
insert into AppelEnchere(ProduitUsersid,prixmin,datedebut)values(1,2000000,'','',);

CREATE TABLE AppelEnchereClose (
  dateClos       timestamp, 
  AppelEnchereid int4 NOT NULL);
CREATE TABLE Compte (
  id         SERIAL NOT NULL, 
  montant    float8, 
  Usersid    int4 NOT NULL, 
  dateReload date, 
  PRIMARY KEY (id));
CREATE TABLE Enchere (
  id             SERIAL NOT NULL, 
  dateMise       date, 
  prixMise       float8, 
  Usersid        int4 NOT NULL, 
  AppelEnchereid int4 NOT NULL, 
  StateVenteid   int4 NOT NULL, 
  state          int4, 
  PRIMARY KEY (id));
CREATE TABLE EnchereAdj (
  id        SERIAL NOT NULL, 
  Enchereid int4 NOT NULL, 
  dateAdj   date, 
  Usersid   int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE EncherePhoto (
  photo          varchar(255), 
  AppelEnchereid int4 NOT NULL);
CREATE TABLE Produit (
  id    SERIAL NOT NULL, 
  nom   varchar(255), 
  photo varchar(255),
  Categorieid int,
  PRIMARY KEY (id));
insert into Produit(nom,photo,Categorieid)values('Ferrarie F40','null.jpg',1);

CREATE TABLE ProduitUsers (
  Produitid int4 NOT NULL, 
  UsersId   int4 NOT NULL, 
  id        SERIAL NOT NULL, 
  PRIMARY KEY (id));
insert into ProduitUsers(Produitid,UsersId)values(1,1);

CREATE TABLE StateVente (
  id    SERIAL NOT NULL, 
  label varchar(255), 
  PRIMARY KEY (id));
insert into StateVente(label)values('ADJ');
insert into StateVente(label)values('NADJ');
insert into StateVente(label)values('CLOSE');

CREATE TABLE Users (
  nom    varchar(255), 
  login  varchar(255), 
  id     SERIAL NOT NULL, 
  mdp    varchar(255), 
  dtn    date, 
  prenom varchar(255), 
  PRIMARY KEY (id));
insert into Users(nom,prenom,login,mdp,dtn)values('anjara','valisoa','mofogasy70@gmail.com','123','2001-04-19');
insert into Users(nom,prenom,login,mdp,dtn)values('Rakoto','kapoka','123@gmail.com','123','1999-01-01');

CREATE TABLE Admin(
id SERIAL NOT NULL PRIMARY KEY,
login varchar(255),
mdp varchar(255));
insert into Admin(login,mdp)values('root','root');

CREATE TABLE Categorie(
id SERIAL NOT NULL PRIMARY KEY,
nom varchar(255));
insert into Categorie(nom)values('automobile');
insert into Categorie(nom)values('imobilier');

ALTER TABLE ProduitUsers ADD CONSTRAINT FKProduitUse200923 FOREIGN KEY (Produitid) REFERENCES Produit (id);
ALTER TABLE ProduitUsers ADD CONSTRAINT FKProduitUse731658 FOREIGN KEY (UsersId) REFERENCES Users (id);
ALTER TABLE Produit ADD CONSTRAINT FKProduit731658 FOREIGN KEY (Categorieid) REFERENCES Categorie (id);
ALTER TABLE AppelEnchere ADD CONSTRAINT FKAppelEnche636140 FOREIGN KEY (ProduitUsersid) REFERENCES ProduitUsers (id);
ALTER TABLE Enchere ADD CONSTRAINT FKEnchere649256 FOREIGN KEY (Usersid) REFERENCES Users (id);
ALTER TABLE AppelEnchereClose ADD CONSTRAINT FKAppelEnche934177 FOREIGN KEY (AppelEnchereid) REFERENCES AppelEnchere (id);
ALTER TABLE Enchere ADD CONSTRAINT FKEnchere115491 FOREIGN KEY (AppelEnchereid) REFERENCES AppelEnchere (id);
ALTER TABLE EnchereAdj ADD CONSTRAINT FKEnchereAdj353389 FOREIGN KEY (Enchereid) REFERENCES Enchere (id);
ALTER TABLE Enchere ADD CONSTRAINT FKEnchere230757 FOREIGN KEY (StateVenteid) REFERENCES StateVente (id);
ALTER TABLE EncherePhoto ADD CONSTRAINT FKEncherePho222294 FOREIGN KEY (AppelEnchereid) REFERENCES AppelEnchere (id);
ALTER TABLE EnchereAdj ADD CONSTRAINT FKEnchereAdj78699 FOREIGN KEY (Usersid) REFERENCES Users (id);
ALTER TABLE Compte ADD CONSTRAINT FKCompte376569 FOREIGN KEY (Usersid) REFERENCES Users (id);


