package stc21.smartmediator.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
public class UsersEntity implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "username")
    private String username;

    @Column(name = "status")
    private UUID status;

    @Basic
    @Column(name = "active")
    private Boolean active;

    @ElementCollection(targetClass = RolesEnumEntity.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RolesEnumEntity> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UsersOrganizationsEntity> orgs;

    public UsersEntity() {

    }

    public UsersEntity(String email, String password_hash,
                       String full_name,
                       UUID status_id, Boolean active) {
        this.email = email;
        this.password = password_hash;
        this.username = full_name;
        this.status = status_id;
        this.active = active;
    }

    public List<UsersOrganizationsEntity> getOrgs() {
        return orgs;
    }

    public void setOrgs(List<UsersOrganizationsEntity> orgs) {
        this.orgs = orgs;
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }

    public UUID getStatus() {
        return status;
    }

    public void setStatus(UUID value) {
        status = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String fullName) {
        this.username = fullName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<RolesEnumEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesEnumEntity> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return roles.contains(RolesEnumEntity.ADMIN);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, username);
    }
}
