package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users_organizations", schema = "public", catalog = "postgres")
public class UsersOrganizationsEntity {
    private UUID id;
    private UsersEntity user;
    private OrganizationsEntity org;

    public UsersOrganizationsEntity(UsersEntity user, OrganizationsEntity org) {
        this.user = user;
        this.org = org;
    }

    public UsersOrganizationsEntity() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "org_id")
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
        UsersOrganizationsEntity that = (UsersOrganizationsEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
