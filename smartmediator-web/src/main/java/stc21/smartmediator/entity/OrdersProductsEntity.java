package stc21.smartmediator.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "orders_products", schema = "public", catalog = "postgres")
public class OrdersProductsEntity {
    private UUID id;
    private BigDecimal amount;
    private String note;
    private UUID productId;

    private OrdersEntity order;


    public OrdersProductsEntity(BigDecimal amount, String note, OrdersEntity order, UUID productId) {
        this.amount = amount;
        this.note = note;
        this.order = order;
        this.productId = productId;
    }

    public OrdersProductsEntity() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    public OrdersEntity getOrder() {
        return order;
    }

    public void setOrder(OrdersEntity order) {
        this.order = order;
    }

    @Column(name = "product_id")
    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID value) {
        this.productId = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersProductsEntity that = (OrdersProductsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, note);
    }
}
