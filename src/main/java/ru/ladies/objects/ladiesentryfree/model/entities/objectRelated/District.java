package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "District")
public class District {
    @Id
    @Column(name = "district", nullable = false)
    private String district;

}
