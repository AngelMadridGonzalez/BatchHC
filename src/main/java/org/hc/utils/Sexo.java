package org.hc.utils;

public enum Sexo {

    MASCULINO("M",1),
    FEMENINO("F",0);
    String old_code;
    Integer new_code;

    Sexo(String old_code, Integer new_code) {
        this.old_code = old_code;
        this.new_code = new_code;
    }

    public String getOld_code() {
        return old_code;
    }

    public void setOld_code(String old_code) {
        this.old_code = old_code;
    }

    public Integer getNew_code() {
        return new_code;
    }

    public void setNew_code(Integer new_code) {
        this.new_code = new_code;
    }

    public static Integer obtainNewSex(String id) {
        for (Sexo sexo : Sexo.values()) {
            if (sexo.getOld_code().equals(id)) {
                return sexo.getNew_code();
            }
        }
        return null;
    }
}
