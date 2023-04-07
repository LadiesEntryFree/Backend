package ru.ladies.objects.ladiesentryfree.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@Entity
@Table(name = "Role")
public class RoleEntity implements GrantedAuthority {
    @Id
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
