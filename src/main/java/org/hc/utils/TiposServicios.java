package org.hc.utils;

public enum TiposServicios {

    ADIESTRAMIENTO_ESPECIAL(1,"ADIEST. ESP", 1),
    ADIESTRAMIENTO_Obediencia_basica(2,"ADIEST. GEN", 2),
    ARTICULO_TIENDA(3,"ART.TIENDA", null), //FIXME NO HAY TARIFA PARA ESTE TIPO DE SERVICIO
    BAÑO_ANTIPARASITARIO (4,"B Antipar", 3),
    BAÑO_PERRO_GRANDE(5,"BG", 4),
    BAÑO_PERRO_MEDIANO(6,"BM", 5),
    BONO_15_NOCHES(7,"BONO 15", null),  //FIXME DEPENDEMOS DEL IDTIPOCELDA PARA SABER QUE TIPO DE SERVICIO A CADA TARIFA
    BONO_30_NOCHES(8,"BONO 30", null),  //FIXME DEPENDEMOS DEL IDTIPOCELDA PARA SABER QUE TIPO DE SERVICIO A CADA TARIFA
    BAÑO_PERRO_PEQUEÑO(9,"BP", 18),
    ENTREGA_A_DOMICILIO(10,"ENT", 19),
    LARGAS_ESTANCIAS(11,"L. ESTANC.",20),
    ADMINISTRACIÓN_MEDICACIÓN(12,"MED",21),
    PASEOS_ADICIONALES(13,"P.A.",22),
    PELUQUERIA(14,"PEL",23),
    RESIDENCIA_PAJAROS(15,"R PAJ",24),
    RECOGIDA_A_DOMICILIO(16,"REC",25),
    REGULARIZAR_CAJA(17,"REG",null), //FIXME NO HAY TARIFA PARA ESTE TIPO DE SERVICIO
    RESIDENCIA_CONEJO_HAMSTER_ETC(18,"RES CONEJO",26),
    RESIDENCIA(19,"RESID", null),//FIXME DEPENDEMOS DEL IDTIPOCELDA PARA SABER QUE TIPO DE SERVICIO A CADA TARIFA
    RESIDENCIA_GATO(20,"RESIG", null),//FIXME DEPENDEMOS DEL IDTIPOCELDA PARA SABER QUE TIPO DE SERVICIO A CADA TARIFA
    TRANSPORTE_CON_TARIFA_ESPECIAL(21,"TPTE.ESP",null); //FIXME NO HAY TARIFA PARA ESTE TIPO DE SERVICIO

    int id;
    String description;
    Integer idTarifa;

    TiposServicios(int id, String description, Integer idTarifa) {
        this.id = id;
        this.description = description;
        this.idTarifa = idTarifa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    // Método para obtener id tarifa a traves del id
    public static Integer obtainTarifa(String id) {
        for (TiposServicios tiposServicios : TiposServicios.values()) {
            if (tiposServicios.getDescription().equals(id)) {
                return tiposServicios.getIdTarifa();
            }
        }
        return null;
    }
}
