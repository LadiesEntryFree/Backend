package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Actual_User")
public class ActualUser {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

}
