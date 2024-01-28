DROP TABLE CuentasClientes;

CREATE TABLE IF NOT EXISTS CuentasClientes (
    id          		INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL,
    idCliente        	INTEGER NOT NULL,
    idTicketCobro   	INTEGER NOT NULL,
    tarjeta  		TEXT NOT NULL,
    importe		INTEGER DEFAULT (0) NOT NULL,
    estado		INTEGER DEFAULT (0) NOT NULL
)
