package br.com.bean.infrastructure.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_cash_session")
public class CashSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant openingTimestamp;
    private Instant closingTimestamp;
    private BigDecimal openingAmount;
    private BigDecimal closingAmount;
    private BigDecimal expectedAmount;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    private Boolean closed;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private User operator;

    @OneToMany(mappedBy = "cashSession")
    private Set<Sale> sales = new HashSet<>();

    public CashSession() {
    }

    public CashSession(Long id, Instant openingTimestamp, Instant closingTimestamp, BigDecimal openingAmount, BigDecimal closingAmount, BigDecimal expectedAmount, String notes, Boolean closed, User operator) {
        this.id = id;
        this.openingTimestamp = openingTimestamp;
        this.closingTimestamp = closingTimestamp;
        this.openingAmount = openingAmount;
        this.closingAmount = closingAmount;
        this.expectedAmount = expectedAmount;
        this.notes = notes;
        this.closed = closed;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getOpeningTimestamp() {
        return openingTimestamp;
    }

    public void setOpeningTimestamp(Instant openingTimestamp) {
        this.openingTimestamp = openingTimestamp;
    }

    public Instant getClosingTimestamp() {
        return closingTimestamp;
    }

    public void setClosingTimestamp(Instant closingTimestamp) {
        this.closingTimestamp = closingTimestamp;
    }

    public BigDecimal getOpeningAmount() {
        return openingAmount;
    }

    public void setOpeningAmount(BigDecimal openingAmount) {
        this.openingAmount = openingAmount;
    }

    public BigDecimal getClosingAmount() {
        return closingAmount;
    }

    public void setClosingAmount(BigDecimal closingAmount) {
        this.closingAmount = closingAmount;
    }

    public BigDecimal getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(BigDecimal expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }

    public Set<Sale> getOrders() {
        return sales;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CashSession that = (CashSession) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
