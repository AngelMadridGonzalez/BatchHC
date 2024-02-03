DROP TABLE CuentasClientes;

CREATE TABLE IF NOT EXISTS CuentasClientes (
    id          		INTEGER PRIMARY KEY UNIQUE NOT NULL,
    idCliente        	INTEGER NOT NULL,
    idTicketCobro   	INTEGER,
    tarjeta  		TEXT,
    importe		INTEGER DEFAULT (0),
    estado		INTEGER DEFAULT (0)
)

DROP TABLE TicketCobros;

CREATE TABLE TicketCobros(
    idReserva          	INTEGER NOT NULL,
    idTipoCobro     	INTEGER NOT NULL,
    numeroTicket 	INTEGER NOT NULL,
    importe 		REAL NOT NULL,
    cobrado 		TEXT NULL,
    fechaPago 		TEXT NULL,
    observacion	    	TEXT NULL
)