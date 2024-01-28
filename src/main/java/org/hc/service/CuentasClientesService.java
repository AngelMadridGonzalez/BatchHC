package org.hc.service;

import org.hc.model.entity.CuentasClientes;
import org.hc.model.repository.CuentasClientesRepository;
import org.springframework.stereotype.Service;

@Service
public class CuentasClientesService {
    private final CuentasClientesRepository repository;

    public CuentasClientesService(CuentasClientesRepository repository) {
        this.repository = repository;
    }

    public void insertarRegistro(CuentasClientes cuentasClientes) {
        repository.save(cuentasClientes);
    }
}
