package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "value", nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "measure", nullable = false)
    private AreaMeasure measure;

}
