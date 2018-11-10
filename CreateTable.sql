-- Suppession des tables
Drop Table IF EXISTS `POSSEDE`;
Drop Table IF EXISTS `LOCATION`;
Drop Table IF EXISTS `PERSONNE`;
Drop Table IF EXISTS `BIEN`;
Drop Table IF EXISTS `TYPE`;

-- Ajout des tables
CREATE TABLE IF NOT EXISTS `BIEN` (
   `id_bien` int(30) NOT NULL AUTO_INCREMENT,
   `address_b` VARCHAR(30) NOT NULL,
   `nature` int(30) NOT NULL,
	PRIMARY KEY (`id_bien`))ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `LOCATION` (
   `id_bien` INT(20) NOT NULL,
   `id_personne` INT(20) NOT NULL,
 KEY `id_bien` (`id_bien`),
 KEY `id_personne`(`id_personne`))ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

    
CREATE TABLE IF NOT EXISTS `TYPE` (
  `id_type` INT(20) NOT NULL AUTO_INCREMENT,
  `name_type` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_type`))ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
  
CREATE TABLE IF NOT EXISTS `PERSONNE` (
  `id_personne` INT(20) NOT NULL AUTO_INCREMENT ,
  `nom` VARCHAR(30) NOT NULL,
  `prenom` VARCHAR(30) NOT NULL,
  `adresse` VARCHAR(30) NOT NULL,
  `id_type` INT(20) NOT NULL,
  PRIMARY KEY (`id_personne`),
  KEY `id_type`(`id_type`) )ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `POSSEDE` (
  `id_bien` INT(20) NOT NULL,
   `id_personne` INT(20) NOT NULL,
 KEY `id_bien` (`id_bien`),
 KEY `id_personne`(`id_personne`))ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
 
 
ALTER TABLE LOCATION
ADD CONSTRAINT location_idfk_2 FOREIGN KEY (id_personne) REFERENCES PERSONNE (id_personne) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT location_idfk_1 FOREIGN KEY (id_bien) REFERENCES BIEN (id_bien) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE PERSONNE
ADD CONSTRAINT personne_idfk_1 FOREIGN KEY (id_type) REFERENCES TYPE (id_type) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE POSSEDE
ADD CONSTRAINT possede_idfk_2 FOREIGN KEY (id_personne) REFERENCES PERSONNE (id_personne) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT possede_idfk_1 FOREIGN KEY (id_bien) REFERENCES BIEN (id_bien) ON DELETE CASCADE ON UPDATE CASCADE;

/** Ajout de contrainte d'unicité*/
ALTER TABLE POSSEDE
ADD UNIQUE (id_personne, id_bien);

ALTER TABLE LOCATION
ADD UNIQUE (id_personne, id_bien);

ALTER TABLE BIEN
ADD UNIQUE (address_b);

/** insert Type */
INSERT INTO `TYPE`(`name_type`) VALUES ("Propriétaire");
INSERT INTO `TYPE`(`name_type`) VALUES ("Locataire");

/** insert Propriétaire */
INSERT INTO `PERSONNE`(`nom`, `prenom`, `adresse`, `id_type`) VALUES( "Proprio1", "LePro", "Addres Proprio1",1);
INSERT INTO `PERSONNE`(`nom`, `prenom`, `adresse`, `id_type`) VALUES( "Proprio2", "LePro2", "Addres Proprio2",1);

INSERT INTO `BIEN` (`address_b`, `nature`) VALUES ( "1 Proprio1 ", 1);
INSERT INTO `BIEN` (`address_b`, `nature`) VALUES ( "2 Proprio1 ", 1);
INSERT INTO `BIEN` (`address_b`, `nature`) VALUES ( "1 Proprio2 ", 1);
INSERT INTO `BIEN` (`address_b`, `nature`) VALUES ( "2 Proprio2 ", 1);

INSERT INTO `POSSEDE`(`id_bien`,`id_personne`) VALUES(1,1);
INSERT INTO `POSSEDE`(`id_bien`,`id_personne`) VALUES(2,1);
INSERT INTO `POSSEDE`(`id_bien`,`id_personne`) VALUES(3,2);
INSERT INTO `POSSEDE`(`id_bien`,`id_personne`) VALUES(4,2);

/** insert Locatiare */
INSERT INTO `PERSONNE`(`nom`, `prenom`, `adresse`, `id_type`) VALUES( "Locataire1", "loca1", "Addres loca1",2);
INSERT INTO `PERSONNE`(`nom`, `prenom`, `adresse`, `id_type`) VALUES( "Locataire2", "loca2", "Addres loac2",2);
INSERT INTO `PERSONNE`(`nom`, `prenom`, `adresse`, `id_type`) VALUES( "Locataire2", "loca3", "Addres loac3",2);

INSERT INTO `LOCATION`(`id_bien`,`id_personne`) VALUES (1,4);
INSERT INTO `LOCATION`(`id_bien`,`id_personne`) VALUES (3,3);
INSERT INTO `LOCATION`(`id_bien`,`id_personne`) VALUES (2,5);

/*** Bien Vide sans propriétaire */
INSERT INTO `BIEN` (`address_b`, `nature`) VALUES ( "Pas de proprietaire ", 1);

