package ru.ladies.objects.ladiesentryfree.model.entities.attribute;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Attribute")
public class Attribute {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private Type type;

}
