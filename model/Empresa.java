package model;

import enumaration.TipoRamoEnum;

public class Empresa {
    
    private int cdEmpresa;

    private String nmEmpresa;

    private TipoRamoEnum tipoRamo;

    public int getCdEmpresa() {
        return cdEmpresa;
    }

    public String getNmEmpresa() {
        return nmEmpresa;
    }

    public void setCdEmpresa(int cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    public TipoRamoEnum getTipoRamo() {
        return tipoRamo;
    }

    public void setTipoRamo(TipoRamoEnum tipoRamo) {
        this.tipoRamo = tipoRamo;
    }

    @Override
    public String toString() {
        return "O nome da empresa é: "+nmEmpresa;
    }

}
