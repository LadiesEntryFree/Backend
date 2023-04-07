package ru.ladies.objects.ladiesentryfree.model.entities.attribute;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Type")
public class Type {
    @Id
    @Column(name = "type", nullable = false)
    private String type;

}
