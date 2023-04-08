package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Object_Status")
public class ObjectStatus {
    @Id
    @Column(name = "status", nullable = false)
    private String status;

}
