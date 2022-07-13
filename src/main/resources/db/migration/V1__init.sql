CREATE TABLE IF NOT EXISTS departamento (
  id SERIAL,
  area VARCHAR  NOT NULL,
  PRIMARY KEY (id)
  );

 CREATE TABLE IF NOT EXISTS proyecto (
 id SERIAL,
 tema VARCHAR (100) NOT NULL,
 objetivos VARCHAR (100) NOT NULL,
 PRIMARY KEY (id)

 );

CREATE TABLE IF NOT EXISTS docente (
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  cedula INT,
  edad INT,
  telefono INT,
  ciudad VARCHAR (100) NOT NULL,
  departamento_id INT,
  proyecto_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (departamento_id) REFERENCES departamento (id),
  FOREIGN KEY (proyecto_id) REFERENCES proyecto (id)
  );

 CREATE TABLE IF NOT EXISTS usuario (
   id SERIAL,
   username VARCHAR (10) NOT NULL,
   password VARCHAR (10) NOT NULL,
   PRIMARY KEY (id)
 );

CREATE TABLE IF NOT EXISTS pago (
    id SERIAL,
    placa VARCHAR (8) NOT NULL,
    anio int not null,
    valor int not null,
    PRIMARY KEY (id)
    );
