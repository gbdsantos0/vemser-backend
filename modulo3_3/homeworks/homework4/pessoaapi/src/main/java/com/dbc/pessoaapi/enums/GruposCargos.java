package com.dbc.pessoaapi.enums;

public enum GruposCargos {
    ADMIN(1,"Administradores"), CADASTRO(2,"Cadastro"), MARKETING(3,"Marketing");

    private final Integer idCargo;
    private final String nomeCargo;

    GruposCargos(Integer idCargo, String nomeCargo){
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }
}
