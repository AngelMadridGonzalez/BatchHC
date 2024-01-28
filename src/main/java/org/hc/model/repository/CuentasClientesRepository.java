package org.hc.model.repository;

import org.hc.model.entity.CuentasClientes;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CuentasClientesRepository extends JpaRepository<CuentasClientes, Integer> {

}