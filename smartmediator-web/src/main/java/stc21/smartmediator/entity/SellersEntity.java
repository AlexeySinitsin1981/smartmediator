package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "sellers", schema = "public", catalog = "postgres")
public class SellersEntity {
    private UUID id;
    private OrganizationsEntity org;

    public SellersEntity(OrganizationsEntity org) {
        this.org = org;
    }

    public SellersEntity() {

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

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn (name="org_id")
    public OrganizationsEntity getOrg() {
        return org;
    }

    public void setOrg(OrganizationsEntity org) {
        this.org = org;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellersEntity that = (SellersEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
