package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "buyers", schema = "public", catalog = "postgres")
public class BuyersEntity {
    private UUID id;
    private OrganizationsEntity org;
    private UUID pricePatternId;

    public BuyersEntity(OrganizationsEntity org, UUID pricePatternId) {
        this.org = org;
        this.pricePatternId = pricePatternId;
    }

    public BuyersEntity() {

    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn (name="org_id")
    public OrganizationsEntity getOrg() {
        return org;
    }

    public void setOrg(OrganizationsEntity org) {
        this.org = org;
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

//    @Column(name = "org_id")
//    public UUID getOrgId() {
//        return orgId;
//    }
//
//    public void setOrgId(UUID id) {
//        this.orgId = id;
//    }

    @Column(name = "price_pattern_id")
    public UUID getPricePatternId() {
        return pricePatternId;
    }

    public void setPricePatternId(UUID id) {
        this.pricePatternId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyersEntity that = (BuyersEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
