package br.com.bean.business.enums;

public enum PackagingType {
    BAG("Saco"),
    BOTTLE("Frasco"),
    BOX("Caixa"),
    CAN("Lata"),
    DOZEN("Dúzia"),
    PACKAGE("Pacote"),
    PAIR("Par");

    private final String displayName;

    PackagingType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
