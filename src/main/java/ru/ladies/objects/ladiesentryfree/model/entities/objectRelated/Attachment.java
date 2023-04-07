package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "photo")
    private Integer photo;

    @Column(name = "video")
    private Integer video;
}
