--CREATE DATABASE hospidieu;
USE hospidieu;

DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS beds;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS monitorings;

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
    date DATE
    );
    
INSERT INTO users
    (name, firstname, mail, password) 
VALUES
    ('Tournet', 'Julien', 'julien.tournet@hospidieu.fr', 'aze'),
    ('Caudron', 'Myl�ne', 'mylene.caudron@hospidieu.fr', 'qsd'),
    ('Lebrun', 'Sophie', 'sophie.lebrun@hospidieu.fr', 'wxc'),
    ('Valinhas', 'Manuel', 'manuel.valinhas@hospidieu.fr', '123');

INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role_name) VALUES ('ROLE_INFIRMIER');
INSERT INTO roles (role_name) VALUES ('ROLE_SECRETAIRE');

INSERT INTO users_roles
VALUES 
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (2, 3),
    (3, 2),
    (4, 3);

INSERT INTO patients (name, firstname, birth_date, address, postcode, city, phone, security_number) VALUES ('Dialo','Mamadou', '1991-09-10', '1 rue du foot', 59000, 'Lille' ,'0612345678', '1098765432198');
INSERT INTO patients (name, firstname, birth_date, address, postcode, city, phone, security_number) VALUES ('Dupont','Jacques', '1972-02-28', '123 rue Bidon', 99000, 'Fakeville' ,'0312345678', '1234567890123');

INSERT INTO beds
    (bed_number, room_number, department)
VALUES
    (1, 101, 'Comatologie'),
    (2, 101, 'Comatologie'),
    (1, 201, 'Alcoologie'),
    (2, 201, 'Alcoologie'),
    (1, 301, 'Raclettologie');
    
INSERT INTO beds (bed_number, room_number, department, ID_patient) VALUES (1, 102, 'Comatologie', 2);
INSERT INTO beds (bed_number, room_number, department, ID_patient) VALUES (2, 102, 'Comatologie', 1);

INSERT INTO monitorings
    (ID_patient, comment, symptom, date, ID_user)
VALUES
    (1, 'Entr�e du patient', 'Coma', '2022-12-22', 2),
    (1, 'Joyeux no�l', 'Coma', '2022-12-24', 3),
    (1, 'Nouvelle ann�e toujours dans le coma', 'Coma', '2023-01-01', 2);
