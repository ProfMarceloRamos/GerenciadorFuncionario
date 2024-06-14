package enumaration;

public enum TipoRamoEnum {
    
    ALIMENTICIO(1),
    ELETRODOMESTICO(2),
    COSMETICO(3);

    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    TipoRamoEnum(int cd) {
        this.codigo = cd;
    }

}
