package org.hc.utils;

public enum TipoAnimal {

    PECES(2,"AC"),
    GATO(3,"G"),
    ROEDOR(4,"HAM"),
    OTROS(5,"O"),
    PERRO(6,"P"),
    PAJARO(7,"PA"),
    TERRARIO(8,"TE"),
    TEJONES(13,"TE");

    Integer id;
    String code;

    TipoAnimal(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static Integer obtainTipoAnimal(String code) {
        for (TipoAnimal animalType : TipoAnimal.values()) {
            if (animalType.getCode().equals(code)) {
                return animalType.getId();
            }
        }
        return null;
    }
}
