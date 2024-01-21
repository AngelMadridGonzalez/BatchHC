DROP TABLE CuentasClientesNew IF EXISTS;

CREATE TABLE CuentasClientesNew  (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    idCliente VARCHAR(20),
    idTicketCobro VARCHAR(20),
    tarjeta VARCHAR(30),
    importe VARCHAR(30),
    estado VARCHAR(30)
);

DROP TABLE TicketCobrosNew IF EXISTS;

CREATE TABLE TicketCobrosNew  (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    idCliente VARCHAR(20),
    numeroTicket VARCHAR(20),
    idOcupacion VARCHAR(30),
    importe VARCHAR(30),
    cobrado VARCHAR(30),
    fechaPago VARCHAR(30),
    observacion VARCHAR(30)
);