--CREATE DATABASE hospidieu;
USE hospidieu;

DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS monitorings;
DROP TABLE IF EXISTS beds;
DROP TABLE IF EXISTS patients;

CREATE TABLE users (
    ID_user INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    firstname VARCHAR(50),
    mail VARCHAR(50),
    password VARCHAR(100)
    );

CREATE TABLE roles (
    ID_role INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50)
    );

CREATE TABLE users_roles (
    ID_user INT,
    ID_role INT,
    FOREIGN KEY (ID_user) REFERENCES users(ID_user),
    FOREIGN KEY (ID_role) REFERENCES roles(ID_role)
    );

CREATE TABLE patients (
    ID_patient INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    firstname VARCHAR(50),
    birth_date DATE,
    address VARCHAR(100),
    postcode VARCHAR(10),
    city VARCHAR(50),
    phone VARCHAR(10),
    security_number VARCHAR(20)
    );

CREATE TABLE beds (
    ID_bed INT PRIMARY KEY AUTO_INCREMENT,
    bed_number INT,
    room_number INT,
    department VARCHAR(50),
    ID_patient INT,
    FOREIGN KEY(ID_patient) REFERENCES patients(ID_patient)
    );

CREATE TABLE monitorings (
    ID_monitoring INT PRIMARY KEY AUTO_INCREMENT,
    ID_patient INT,
    ID_user INT,
    comment VARCHAR(200),
    symptom VARCHAR(50),
    date DATETIME
    );

INSERT INTO users
    (name, firstname, mail, password) 
VALUES
    ('Tournet', 'Julien', 'julien.tournet@hospidieu.fr', 'aze'),
    ('Caudron', 'Mylène', 'mylene.caudron@hospidieu.fr', 'qsd'),
    ('Lebrun', 'Sophie', 'sophie.lebrun@hospidieu.fr', 'wxc'),
    ('Valinhas', 'Manuel', 'manuel.valinhas@hospidieu.fr', '123'),
    ('Test', 'Admin', 'admintest@mail.com', '$2a$12$BK0FF9PlD3xhcHdcG7tP8.HHluZ.D52mPJohThLP1K09s6lmA.Xu2');

INSERT INTO roles (role_name) VALUES ('ROLE_INFIRMIER');
INSERT INTO roles (role_name) VALUES ('ROLE_SECRETAIRE');
INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles
VALUES 
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (2, 3),
    (3, 2),
    (4, 1),
    (5, 1),
    (5, 2),
    (5, 3);

INSERT INTO patients
    (name, firstname, birth_date, address, postcode, city, phone, security_number)
VALUES
    ('Doe','Jane', '1980-01-01', 'Inconnue', 99000, 'Fakeville' ,'0600000000', '2000000000000'),
    ('Dupont','Jacques', '1972-02-28', '123 rue Bidon', 99000, 'Fakeville' ,'0312345678', '1234567890123'),
    ('Dupont','Micheline', '1974-08-02', '123 rue Bidon', 99000, 'Fakeville' ,'0312345678', '2234567890123'),
    ('Leclercq','Michel', '1966-10-30', '27 rue Bidon', 99000, 'Fakeville' ,'0309876543', '1098765433321'),
    ('Dialo','Mamadou', '1991-09-10', '1 rue du foot', 59000, 'Lille' ,'0612345678', '1098765432198'),
    ('Majorczyk','Nicolas', '1993-02-17', '1 rue du rock', 59000, 'Lille' ,'0612335678', '1098765473198'),
    ('Masset','Marina', '1990-04-22', '1 rue du Japon', 59000, 'Lille' ,'0612998678', '2098765992198'),
    ('Duck','Riri', '2018-04-04', '4 rue Disney', 99000, 'Fakeville' ,'0399999999', '1999999999999'),
    ('Duck','Fifi', '2018-04-04', '4 rue Disney', 99000, 'Fakeville' ,'0399999999', '1999999999998'),
    ('Duck','Loulou', '2018-04-04', '4 rue Disney', 99000, 'Fakeville' ,'0399999999', '2999999999997');

INSERT INTO beds
    (bed_number, room_number, department)
VALUES
    (1, 1, 'Urgences'),
    (2, 1, 'Urgences'),
    (3, 1, 'Urgences'),
    (4, 1, 'Urgences'),
    (1, 2, 'Urgences'),
    (2, 2, 'Urgences'),
    (3, 2, 'Urgences'),
    (1, 3, 'Urgences'),
    (2, 3, 'Urgences'),
    (3, 3, 'Urgences'),
    (1, 11, 'Traumatologie'),
    (2, 11, 'Traumatologie'),
    (1, 12, 'Traumatologie'),
    (2, 12, 'Traumatologie'),
    (1, 21, 'Pédiatrie'),
    (1, 22, 'Pédiatrie'),
    (1, 23, 'Pédiatrie'),
    (1, 24, 'Pédiatrie'),
    (1, 31, 'Maternité'),
    (1, 32, 'Maternité'),
    (1, 33, 'Maternité'),
    (1, 34, 'Maternité'),
    (1, 101, 'Cardiologie'),
    (2, 101, 'Cardiologie'),
    (1, 102, 'Cardiologie'),
    (2, 102, 'Cardiologie'),
    (1, 201, 'Neurologie'),
    (1, 111, 'Neurologie'),
    (2, 111, 'Neurologie'),
    (1, 112, 'Neurologie'),
    (2, 112, 'Médecine générale'),
    (1, 201, 'Chirurgie'),
    (2, 201, 'Chirurgie'),
    (1, 202, 'Chirurgie'),
    (2, 102, 'Chirurgie'),
    (1, 301, 'Raclettologie');
    
INSERT INTO beds
    (ID_bed, ID_patient)
VALUES
    (16, 9),
    (15, 10),
    (25, 3),
    (1, 1)
ON DUPLICATE KEY UPDATE ID_patient=VALUES(ID_patient);

INSERT INTO monitorings
    (ID_patient, comment, symptom, date, ID_user)
VALUES
    (2, 'Entrée du patient', null, '2022-12-22', 3),
    (2, 'Joyeux noël', 'Coma', '2022-12-24', 4),
    (2, 'Nouvelle année toujours dans le coma', 'Coma', '2023-01-01', 4),
    (2, 'Patient réveillé !', null, '2023-01-15', 4),
    (2, 'Sortie du patient', null, '2023-01-19', 3),
    (1, 'Entrée du patient aux urgences', null, '2023-03-06', 3),
    (9, 'Entrée du patient en pédiatrie', null, '2023-03-04', 3),
    (10, 'Entrée du patient en pédiatrie', null, '2023-03-04', 3),
    (9, 'Diagnostic', 'Varicelle', '2023-03-04', 4),
    (10, 'Diagnostic', 'Varicelle', '2023-03-04', 4),
    (3, 'Entrée du patient en cardiologie', null, '2023-02-28', 3),
    (3, 'Diagnostic non concluant, patient gardé en observation', null, '2023-02-28', 4);
