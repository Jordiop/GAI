DROP DATABASE IF EXISTS GAI;
CREATE DATABASE IF NOT EXISTS GAI;
use GAI;

CREATE TABLE Almacen(
idAlmacen INT NOT NULL,
nom VARCHAR(50) NOT NULL,
localitzacio VARCHAR(100) NOT NULL,
PRIMARY KEY(idAlmacen)
);

CREATE TABLE Treballadors(
idTreballador INT NOT NULL,
idAlmacen INT NOT NULL,
username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
Nom VARCHAR(20) NOT NULL,
Cognoms VARCHAR(50) NOT NULL,
Rango VARCHAR(20) NOT NULL,
PRIMARY KEY(idTreballador),
FOREIGN KEY(idAlmacen)REFERENCES Almacen(idAlmacen) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Pasillos(
idPasillo INT NOT NULL,
idAlmacen INT NOT NULL,
numero INT NOT NULL,
PRIMARY KEY(idPasillo),
FOREIGN KEY(idAlmacen)REFERENCES Almacen(idAlmacen) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Estanterias(
idEstanteria INT NOT NULL,
idAlmacen INT NOT NULL,
idPasillo INT NOT NULL,
alturaY INT NOT NULL,
anchuraX INT NOT NULL,
PRIMARY KEY(idEstanteria),
FOREIGN KEY(idPasillo)REFERENCES Pasillos(idPasillo) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Productos(
idProducto INT NOT NULL,
idEstanteria INT NOT NULL,
idPasillo INT NOT NULL,
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
fecha DATE NOT NULL,
hora TIME NOT NULL,
PRIMARY KEY(idProducto, idTransaccio),
FOREIGN KEY(idProducto)REFERENCES Productos(idProducto) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(idTransaccio)REFERENCES Transaccions(idTransaccio) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Missatges (
	idMissatge INT NOT NULL,
    missatge varchar(1000),
    email varchar(40) not null,
    PRIMARY KEY (idMissatge)
);

CREATE TABLE NumeroEstanterias (
idPasillo int,
numEstanterias int,
PRIMARY KEY(idPasillo),
FOREIGN KEY(idPasillo)REFERENCES Pasillos (idPasillo)
);


-- Trigger que prevé valors negatius als productes. Forma part de sa doble verificació del programa.
drop trigger if exists Comprobante ;
delimiter $$
create trigger Comprobante
	before insert on Productos for each row
    begin
		if (new.quantitat < 0) 
			then set new.quantitat = 1;
        end if;
        if (new.coordenadaX < 0) 
			then set new.coordenadaX = 3;
        end if;
		if (new.coordenadaY < 0) 
			then set new.coordenadaY = 1;
        end if;
end $$
delimiter ;

drop trigger if exists Comprobante2;
delimiter $$
create trigger Comprobante2
	before update on Productos for each row
    begin
		if (new.quantitat < 1) 
			then signal sqlstate "45000" set message_text = "No val";
        end if;
		if (new.quantitat = old.quantitat) 
			then signal sqlstate "45000" set message_text = "No has modificat res";
        end if;
        if (new.idProducto < 0) 
			then signal sqlstate "45000" set message_text = "No pots possar ids negatives";
        end if;
        if (new.idEstanteria < 0) 
			then signal sqlstate "45000" set message_text = "No pots possar ids negatives";
        end if;
end $$
delimiter ;

drop trigger if exists Comprobante3;
delimiter $$
create trigger Comprobante3
	before delete on productos for each row
	begin
		if (quantitat != 0)
			then signal sqlstate "45000" set message_text = "Encara queden existencies d'aquest producte";
        end if;
	end $$
delimiter ;

delimiter $$
create procedure ContarEstanterias(in idPasillo2 int)
begin
declare totalEstanterias int;

set totalEstanterias = (select count(*) from Estanterias e
	where idPasillo = idPasillo2);
    
insert into NumeroEstanterias values(idPasillo2,totalEstanterias);
    
end $$
delimiter ;

delimiter $$
create procedure ContarAuto()
begin

DECLARE idPasillo3 INTEGER;
DECLARE controlLoop INTEGER;
DECLARE pasillosCursor CURSOR FOR SELECT idPasillo FROM Pasillos;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET controlLoop = 1;
delete from NumeroEstanterias;
        
		OPEN pasillosCursor;
			pasillosCursor: LOOP
				SET controlLoop = 0;
				FETCH pasillosCursor INTO idPasillo3;

                IF controlLoop = 1 THEN
					LEAVE pasillosCursor;
				ELSE
				  	CALL ContarEstanterias(idPasillo3);
				END IF;
			END LOOP;
		CLOSE pasillosCursor;
 END$$ 

delimiter ;

delimiter $$
create event updateall on schedule every 5 minute do
begin
	call ContarAuto();
end $$
delimiter ;

INSERT INTO Almacen VALUES (1,"Primero","Caracas 06");
INSERT INTO Treballadors VALUES (1,1,"GOD","0000","God","OST","DIOS");
INSERT INTO Pasillos VALUES (1,1,1);
INSERT INTO Estanterias VALUES (1,1,1,10,10);
INSERT INTO Productos VALUES (1,1,1,"Gambas",500,"mar", 5,5);
