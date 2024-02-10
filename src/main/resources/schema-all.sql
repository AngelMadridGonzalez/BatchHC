DROP TABLE CuentasClientes;

CREATE TABLE IF NOT EXISTS CuentasClientes (
    id          	INTEGER PRIMARY KEY UNIQUE NOT NULL,
    idCliente       INTEGER NOT NULL,
    idTicketCobro   INTEGER,
    tarjeta  		TEXT,
    importe		    INTEGER DEFAULT (0),
    estado		    INTEGER DEFAULT (0)
)

DROP TABLE TicketCobros;

CREATE TABLE TicketCobros(
    idReserva       INTEGER NOT NULL,
    idTipoCobro     INTEGER NOT NULL,
    numeroTicket 	INTEGER NOT NULL,
    importe 		REAL NOT NULL,
    cobrado 		TEXT NULL,
    fechaPago 		TEXT NULL,
    observacion	    TEXT NULL
)

DROP TABLE Animales;

CREATE TABLE  Animales (
    id          	INTEGER PRIMARY KEY UNIQUE NOT NULL,
    idCliente      	INTEGER NOT NULL,
    idTipoAnimal   	INTEGER NOT NULL,
    nMicrochip     	TEXT UNIQUE NOT NULL,
    nombre         	TEXT NULL,
    sexo           	INTEGER NULL,
    raza           	TEXT NULL,
    fNacimiento    	TEXT NOT NULL,
    fFallecimiento 	TEXT NULL,
    observacion    	TEXT NULL,
)

DROP TABLE Clientes;

CREATE TABLE Clientes (
    id          	INTEGER PRIMARY KEY UNIQUE NOT NULL,
    nombre      	TEXT NULL,
    apellido1   	TEXT NULL,
    apellido2   	TEXT NULL,
    sexo        	INTEGER NULL,
    dni        		TEXT NOT NULL,
    direccion   	TEXT NOT NULL,
    telefono    	INTEGER NULL,
    email       	TEXT NULL,
    estado		    INTEGER DEFAULT (1) NOT NULL,
    fechaAlta   	TEXT NOT NULL,
    fechaBaja  	 	TEXT NULL,
    observacion 	TEXT NULL
)

