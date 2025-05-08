package br.com.vintor.business.enums;

public enum UnitOfMeasure {
    UNIT("Unidade"),
    METER("Metro"),
    CENTIMETER("Centímetro"),
    KILOGRAM("Quilograma"),
    GRAM("Grama"),
    LITER("Litro"),
    MILLILITER("Mililitro");

    private final String displayName;

    UnitOfMeasure(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
