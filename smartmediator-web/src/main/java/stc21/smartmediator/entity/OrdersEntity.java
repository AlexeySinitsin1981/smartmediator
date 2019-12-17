package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "orders", schema = "public", catalog = "postgres")
public class OrdersEntity {
    private UUID id;
    private String note;
    private UUID deliveryTypeId;
    private UUID pricePatternId;
    private UUID getFrom;
    private UUID setTo;

    private OrderStatusesEntity status;
    private BuyersEntity buyer;
    private SellersEntity seller;

     public OrdersEntity(
            String note,
            OrderStatusesEntity status,
            BuyersEntity buyer,
            SellersEntity seller,
            UUID deliveryTypeId,
            UUID pricePatternId,
            UUID getFrom,
            UUID setTo) {
        this.note = note;
         this.status = status;
        this.buyer = buyer;
        this.seller = seller;
        this.deliveryTypeId = deliveryTypeId;
        this.pricePatternId = pricePatternId;
        this.getFrom = getFrom;
        this.setTo = setTo;
    }

    public OrdersEntity() {

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
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn (name="status")
    public OrderStatusesEntity getStatus() {
        return status;
    }

    public void setStatus(OrderStatusesEntity status) {
        this.status = status;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn (name="buyer_id")
    public BuyersEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyersEntity buyer) {
        this.buyer = buyer;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn (name="seller_id")
    public SellersEntity getSeller() {
        return seller;
    }

    public void setSeller(SellersEntity seller) {
        this.seller = seller;
    }

    @Column(name = "delivery")
    public UUID getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(UUID value) {
        this.deliveryTypeId = value;
    }

    @Column(name = "price_pattern_id")
    public UUID getPricePatternId() {
        return pricePatternId;
    }

    public void setPricePatternId(UUID value) {
        this.pricePatternId = value;
    }

    @Column(name = "get_from")
    public UUID getGetFrom() {
        return getFrom;
    }

    public void setGetFrom(UUID value) {
        this.getFrom = value;
    }

    @Column(name = "set_to")
    public UUID getSetTo() {
        return setTo;
    }

    public void setSetTo(UUID value) {
        this.setTo = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note);
    }
}
