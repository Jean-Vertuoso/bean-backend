package br.com.vintor.business.enums;

public enum PaymentMethod {
    BANK_SLIP("Boleto Bancário"),
    CASH("Dinheiro"),
    CHECK("Cheque"),
    CREDIT_CARD("Cartão de Crédito"),
    DEBIT_CARD("Cartão de Débito"),
    INSTALLMENT_PLAN("Crediário"),
    PIX("Pix");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
