package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Area_Measure")
public class AreaMeasure {
    @Id
    @Column(name = "measure", nullable = false)
    private String measure;

    // Getter and Setter
}
