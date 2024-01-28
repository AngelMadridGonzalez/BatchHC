DROP TABLE CuentasClientes;

CREATE TABLE IF NOT EXISTS CuentasClientes (
    id          		INTEGER PRIMARY KEY UNIQUE NOT NULL,
    idCliente        	INTEGER NOT NULL,
    idTicketCobro   	INTEGER,
    tarjeta  		TEXT,
    importe		INTEGER DEFAULT (0),
    estado		INTEGER DEFAULT (0)
)
