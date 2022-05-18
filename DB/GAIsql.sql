DROP DATABASE IF EXISTS GAI;
CREATE DATABASE IF NOT EXISTS GAI;
use GAI;


CREATE TABLE Almacen(

idAlmacen INT auto_increment NOT NULL,
nom VARCHAR(50) NOT NULL,
localitzacio VARCHAR(100) NOT NULL,
PRIMARY KEY(idAlmacen)
);

CREATE TABLE Treballadors(

idTreballador INT auto_increment NOT NULL,
idSupervisor INT NOT NULL,
idAlmacen INT NOT NULL,
Nom VARCHAR(20) NOT NULL,
Cognoms VARCHAR(50) NOT NULL,
Rango VARCHAR(20) NOT NULL,
PRIMARY KEY(idTreballador),
FOREIGN KEY(idAlmacen)REFERENCES Almacen(idAlmacen) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(idSupervisor)REFERENCES Treballadors(idTreballador) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Clients(

idClient INT auto_increment NOT NULL,
idTreballador INT NOT NULL,
Nom VARCHAR(20) NOT NULL,
Cognoms VARCHAR(50) NOT NULL,
DNI VARCHAR(30) NOT NULL,
email VARCHAR(40) NOT NULL,
PRIMARY KEY(idClient),
FOREIGN KEY(idTreballador)REFERENCES Treballadors(idTreballador)
);

CREATE TABLE Pasillos(

idPasillo INT auto_increment NOT NULL,
idAlmacen INT NOT NULL,
numero INT NOT NULL,
quantitatEstanterias INT NOT NULL,
PRIMARY KEY(idPasillo),
FOREIGN KEY(idAlmacen)REFERENCES Almacen(idAlmacen) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Estanterias(

idEstanteria INT auto_increment NOT NULL,
idPasillo INT NOT NULL,
alturaY INT NOT NULL,
anchuraX INT NOT NULL,
PRIMARY KEY(idEstanteria),
FOREIGN KEY(idPasillo)REFERENCES Pasillos(idPasillo) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Productos(

idProducto INT auto_increment NOT NULL,
idEstanteria INT NOT NULL,
nom VARCHAR(50) NOT NULL,
quantitat INT NOT NULL,
descripcio VARCHAR(150) NOT NULL,
coordenadaX INT NOT NULL,
coordenadaY INT NOT NULL,
PRIMARY KEY(idProducto),
FOREIGN KEY(idEstanteria)REFERENCES Estanterias(idEstanteria) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Transaccions(

idTransaccio INT auto_increment NOT NULL,
idAlmacen INT NOT NULL,

PRIMARY KEY(idTransaccio),
FOREIGN KEY(idAlmacen)REFERENCES Almacen(idAlmacen) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TransaccionsDetails(

idProducto INT NOT NULL,
idTransaccio INT NOT NULL,
quantitatEntrante INT NOT NULL,
quantitatSaliente INT NOT NULL,
PRIMARY KEY(idProducto, idTransaccio),
FOREIGN KEY(idProducto)REFERENCES Productos(idProducto) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(idTransaccio)REFERENCES Transaccions(idTransaccio) ON UPDATE CASCADE ON DELETE CASCADE
);



