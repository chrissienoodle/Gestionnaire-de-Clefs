-- Reconstruction de la base de données
DROP DATABASE IF EXISTS gesttrousseau;
CREATE DATABASE gesttrousseau;
USE gesttrousseau;

-- tables
CREATE TABLE fonctions
(
  code    int(4) PRIMARY KEY AUTO_INCREMENT,
  libelle varchar(255) NOT NULL
) ENGINE = INNODB;

INSERT INTO fonctions (libelle) VALUE ('Developpeur');
INSERT INTO fonctions (libelle) VALUE ('Agent d''entretien');
INSERT INTO fonctions (libelle) VALUE ('Chef de projet');
INSERT INTO fonctions (libelle) VALUE ('Plombier');
INSERT INTO fonctions (libelle) VALUE ('Formateur');


CREATE TABLE entreprises (
  code      int(4)        PRIMARY KEY AUTO_INCREMENT,
  nom       varchar(80)   NOT NULL,
  adresse   varchar(255)  NOT NULL
) ENGINE = INNODB;

INSERT INTO entreprises (nom, adresse) VALUES ('Afpa', '366 Avenue Georges Durand, 72100 Le Mans');
INSERT INTO entreprises (nom, adresse) VALUES ('ENI ecole informatique', '2B Rue Benjamin Franklin, ZAC Moulin Neuf, Rue Benjamin Franklin, 44800 Saint-Herblain');
INSERT INTO entreprises (nom, adresse) VALUES ('Netflix', '100 Winchester Circle, Los Gatos, CA 95032');
INSERT INTO entreprises (nom, adresse) VALUES ('Amazon', '410 Terry Ave. North Seattle, WA 98109-5210');
INSERT INTO entreprises (nom, adresse) VALUES ('Oracle', '500 Oracle Parkway, Redwood Shores, CA 94065');
INSERT INTO entreprises (nom, adresse) VALUES ('Google', '8 Rue de Londres-15-15 Bis Rue de Clichy 75009 Paris France');


CREATE TABLE personnes (
  id                    int(5)        PRIMARY KEY AUTO_INCREMENT,
  prenom                varchar(80)   NOT NULL,
  nom                   varchar(80)   NOT NULL,
  email                 varchar(200)  NOT NULL,
  code_entreprise       int(4)        NOT NULL,
  code_fonction         int(4)        NOT NULL
) ENGINE = INNODB;

INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Alexandre', 'Besnier', 'alex.besnier@lol.fr', 1, 2);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Vincent', 'Dobremel', 'vdobremel@salut.fr', 4, 1);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Laurence', 'Bodzen', 'lolo@lol.fr', 6, 2);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Cindy', 'Derrien', 'cindyderrien@merci.pt', 2, 5);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Florent', 'Houdayer', 'houd.the.dude@gmail.com', 3, 3);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Christophe', 'Boulay', 'chrisllym@qstein.yay', 4, 4);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Christine', 'Gunsenheimer', 'noodle@ninja.com', 2, 5);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('David', 'Conte', 'david@conte.fr', 3, 5);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Ludovic', 'Poussin', 'ludo@poussin.couic', 4, 5);
INSERT INTO personnes (prenom, nom, email, code_entreprise, code_fonction) VALUES ('Dan Alexandre', 'Versabeau', 'versabeauda@hotmail.fr', 4, 5);


CREATE TABLE users (
  id          int(5)        PRIMARY KEY,
  login       varchar(255)  NOT NULL,
  password    varchar(255)  NOT NULL,
  date_crea   timestamp     DEFAULT CURRENT_TIMESTAMP,
  conn_nb     int(5)        DEFAULT 0,
  is_suppr    boolean       DEFAULT false
) ENGINE = INNODB;

INSERT INTO users (id, login, password) VALUES (1,'alex', 'besnier');
INSERT INTO users (id, login, password) VALUES (2,'vincent', 'dobremel');
INSERT INTO users (id, login, password) VALUES (3,'laurence', 'bodzen');
INSERT INTO users (id, login, password) VALUES (6,'christophe', 'boulay');
INSERT INTO users (id, login, password) VALUES (7,'noodle', 'root');
INSERT INTO users (id, login, password) VALUES (8,'david', 'conte');


CREATE TABLE clefs (
  id            int(5)        PRIMARY KEY AUTO_INCREMENT,
  porte         varchar(255)  NOT NULL,
  reference     varchar(255)  NOT NULL,
  id_personne   int(5)        DEFAULT null,
  is_dispo      boolean       DEFAULT true
) ENGINE = INNODB;

INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('3B', '15 rue des chapelles', 1, false);
INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('multipla', 'multipla rehaussee', 8, false);
INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('or', 'assure longue vie, bonheur et prosperite', null, true);
INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('55', 'rfa4645r', 3, false);
INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('78', 'dfgdf89g9', null, true);
INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('89', 'dgffg84', 4, false);
INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('9', 'dfgdf95', 6, false);
INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('2Bis', 'd98ze7r', 5, false);
INSERT INTO clefs (porte, reference, id_personne, is_dispo) VALUES ('63', 'id1fg15', 7, false);


-- foreign key
ALTER TABLE clefs
  ADD CONSTRAINT fk_clef_personne FOREIGN KEY (id_personne) REFERENCES personnes(id);

ALTER TABLE personnes
  ADD CONSTRAINT fk_personne_entreprise FOREIGN KEY (code_entreprise) REFERENCES entreprises(code);

ALTER TABLE personnes
  ADD CONSTRAINT fk_personne_fonction FOREIGN KEY (code_fonction) REFERENCES fonctions(code);

ALTER TABLE users
  ADD CONSTRAINT fk_user_personne FOREIGN KEY (id) REFERENCES personnes(id);


