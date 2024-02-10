package org.hc.model;

public class Animal {
    int id;
    int idCliente;
    int idTipoAnimal;
    String nMicrochip;
    String nombre;
    int sexo;
    String raza;
    String fNacimiento;
    String fFallecimiento;
    String observacion;

    public Animal() {
        super();
    }

    public Animal(int id, int idCliente, int idTipoAnimal, String nMicrochip, String nombre, int sexo, String raza, String fNacimiento, String fFallecimiento, String observacion) {
        this.id = id;
        this.idCliente = idCliente;
        this.idTipoAnimal = idTipoAnimal;
        this.nMicrochip = nMicrochip;
        this.nombre = nombre;
        this.sexo = sexo;
        this.raza = raza;
        this.fNacimiento = fNacimiento;
        this.fFallecimiento = fFallecimiento;
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoAnimal() {
        return idTipoAnimal;
    }

    public void setIdTipoAnimal(int idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public String getnMicrochip() {
        return nMicrochip;
    }

    public void setnMicrochip(String nMicrochip) {
        this.nMicrochip = nMicrochip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getfFallecimiento() {
        return fFallecimiento;
    }

    public void setfFallecimiento(String fFallecimiento) {
        this.fFallecimiento = fFallecimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
