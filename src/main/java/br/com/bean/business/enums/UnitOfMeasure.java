package br.com.bean.business.enums;

public enum UnitOfMeasure {
    CENTIMETER("Centímetro"),
    GRAM("Grama"),
    KILOGRAM("Quilograma"),
    LITER("Litro"),
    METER("Metro"),
    MILLILITER("Mililitro"),
    UNIT("Unidade");

    private final String displayName;

    UnitOfMeasure(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
