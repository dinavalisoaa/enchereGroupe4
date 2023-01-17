
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
CREATE TABLE  (
  Produitid int4 NOT NULL, 
  UsersId   int4 NOT NULL, 
  id        SERIAL NOT NULL, 
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
ALTER TABLE  ADD CONSTRAINT FK569509 FOREIGN KEY (UsersId) REFERENCES Users (id);
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