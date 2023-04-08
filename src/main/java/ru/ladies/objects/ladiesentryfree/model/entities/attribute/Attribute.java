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

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

}
