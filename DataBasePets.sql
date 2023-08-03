CREATE DATABASE IF NOT EXISTS mans_friends;
USE mans_friends;

DROP TABLE IF EXISTS type_pets;
CREATE TABLE type_pets (
	id INT PRIMARY KEY NOT NULL,
	name CHARACTER VARYING(20)
);

INSERT INTO type_pets (id, name) VALUES 
(1, 'home_pets'),
(2, 'sumpter_pets');

DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
	id INT PRIMARY KEY NOT NULL,
	name CHARACTER VARYING(20),
	type_pet INT,
	FOREIGN KEY (type_pet) REFERENCES type_pets(id) ON UPDATE CASCADE
);

INSERT INTO pets (id, name, type_pet) VALUES 
(1, 'cat', 1),
(2, 'dog', 1),
(3, 'hamster', 1),
(4, 'horse', 2),
(5, 'donkey', 2),
(6, 'camel', 2);

SELECT 
	p.name,
	tp.name
FROM pets p JOIN type_pets tp 
WHERE p.type_pet = tp.id;

DROP TABLE IF EXISTS zoo_residents;
CREATE TABLE zoo_residents (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name CHARACTER VARYING(20),
	pet INT,
	birthday DATETIME,
	command CHARACTER VARYING(20),
	FOREIGN KEY (pet) REFERENCES pets(id) ON UPDATE CASCADE
);

INSERT INTO zoo_residents (name, pet, birthday, command) VALUES 
('murka', 1, '2020-03-14', 'go home'),
('sharik', 2, '2019-10-19', 'aport'),
('pushok',3, '2022-05-16', 'run'),
('malish', 4, '2022-01-14', 'alga'),
('krasavchik', 5, '2020-11-13', 'go'),
('gorbatii', 6, '2021-04-14', 'rest');

DELETE FROM zoo_residents WHERE pet = 6;

DROP TABLE IF EXISTS young_pets;
CREATE TABLE young_pets
SELECT * FROM
(SELECT
	z.id,
	z.name,
	ptp.name as kind,
	ptp.nametp as class,
	z.birthday, 
	z.command,
	DATEDIFF(NOW(), z.birthday) AS days
FROM zoo_residents z JOIN 
(SELECT p.id, p.name, tp.name as nametp 
FROM pets p JOIN type_pets tp 
WHERE p.type_pet = tp.id) AS ptp 
WHERE z.pet = ptp.id) AS pets 
WHERE pets.days BETWEEN 365 AND 1095;

SELECT * FROM young_pets;




