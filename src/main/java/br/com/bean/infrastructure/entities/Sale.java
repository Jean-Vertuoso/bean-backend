package br.com.bean.infrastructure.entities;

import br.com.bean.business.enums.PaymentMethod;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_sale")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant saleTimestamp;
    private BigDecimal totalDiscount;
    private BigDecimal totalValue;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "cash_session_id")
    private CashSession cashSession;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "id.sale", cascade = CascadeType.ALL)
    private List<SaleItem> items = new ArrayList<>();

    public Sale() {
    }

    public Sale(Long id, Instant saleTimestamp, BigDecimal totalDiscount, BigDecimal totalValue, PaymentMethod paymentMethod, Client client, CashSession cashSession, User user) {
        this.id = id;
        this.saleTimestamp = saleTimestamp;
        this.totalDiscount = totalDiscount;
        this.totalValue = totalValue;
        this.paymentMethod = paymentMethod;
        this.client = client;
        this.cashSession = cashSession;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getSaleTimestamp() {
        return saleTimestamp;
    }

    public void setSaleTimestamp(Instant saleTimestamp) {
        this.saleTimestamp = saleTimestamp;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public BigDecimal calcTotalValue() {
        return items.stream()
                .map(SaleItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @PrePersist
    @PreUpdate
    public void updateTotalValue() {
        this.totalValue = calcTotalValue()
                .subtract(totalDiscount)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CashSession getCashSession() {
        return cashSession;
    }

    public void setCashSession(CashSession cashSession) {
        this.cashSession = cashSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
