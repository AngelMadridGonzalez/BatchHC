DROP TABLE CuentasClientesNew IF EXISTS;

CREATE TABLE CuentasClientesNew  (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    idCliente VARCHAR(20),
    idTicketCobro VARCHAR(20),
    tarjeta VARCHAR(30),
    importe VARCHAR(30),
    estado VARCHAR(30)
);