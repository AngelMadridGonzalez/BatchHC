DROP TABLE Animales;

CREATE TABLE "Animales" (
                            "id"	INTEGER NOT NULL UNIQUE,
                            "idCliente"	INTEGER NOT NULL,
                            "idTipoAnimal"	INTEGER NOT NULL,
                            "nMicrochip"	TEXT NOT NULL UNIQUE,
                            "nombre"	TEXT,
                            "sexo"	INTEGER,
                            "raza"	TEXT,
                            "fNacimiento"	TEXT NOT NULL,
                            "fFallecimiento"	TEXT,
                            "observacion"	TEXT,
                            PRIMARY KEY("id")
);

DROP TABLE Clientes;

CREATE TABLE "Clientes" (
                            "id"	INTEGER NOT NULL UNIQUE,
                            "nombre"	TEXT,
                            "apellido1"	TEXT,
                            "apellido2"	TEXT,
                            "sexo"	INTEGER,
                            "dni"	TEXT NOT NULL,
                            "direccion"	TEXT NOT NULL,
                            "telefono"	INTEGER,
                            "email"	TEXT,
                            "estado"	INTEGER NOT NULL DEFAULT (1),
                            "fechaAlta"	TEXT NOT NULL,
                            "fechaBaja"	TEXT,
                            "observacion"	TEXT,
                            PRIMARY KEY("id")
);

DROP TABLE Cuentas_Clientes;

CREATE TABLE "Cuentas_Clientes" (
                                    "id"	INTEGER NOT NULL UNIQUE,
                                    "idCliente"	INTEGER NOT NULL,
                                    "idTicketCobro"	INTEGER,
                                    "tarjeta"	TEXT,
                                    "importe"	INTEGER DEFAULT (0),
                                    "estado"	INTEGER DEFAULT (0),
                                    PRIMARY KEY("id")
);

DROP TABLE Ticket_Cobros;

CREATE TABLE "Ticket_Cobros" (
                                 "id"	INTEGER UNIQUE,
                                 "idOcupacion"	INTEGER,
                                 "idTipoCobro"	INTEGER NOT NULL,
                                 "numeroTicket"	INTEGER,
                                 "importe"	REAL NOT NULL,
                                 "cobrado"	TEXT NOT NULL,
                                 "fechaPago"	TEXT,
                                 "observacion"	TEXT,
                                 PRIMARY KEY("id"),
                                 FOREIGN KEY("idOcupacion") REFERENCES "Reservas"("id"),
                                 FOREIGN KEY("idTipoCobro") REFERENCES "Tipos_Cobros"("id")
);

DROP TABLE Reserva_Servicios;

CREATE TABLE "Reserva_Servicios" (
                                     "id"	INTEGER NOT NULL UNIQUE,
                                     "idTarifa"	INTEGER NOT NULL,
                                     "tipo"	TEXT NOT NULL,
                                     "idReserva"	INTEGER NOT NULL,
                                     "dias"	INTEGER NOT NULL,
                                     "cantidad"	INTEGER NOT NULL,
                                     "importe"	REAL NOT NULL,
                                     "fecha"	TEXT NOT NULL,
                                     "fecha_servicio"	TEXT,
                                     "observacion"	TEXT,
                                     PRIMARY KEY("id")
);