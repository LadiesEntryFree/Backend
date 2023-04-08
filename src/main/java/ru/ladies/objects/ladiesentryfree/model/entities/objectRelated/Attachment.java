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

    @Column(name = "document_id")
    private Integer documentID;

    @Column(name = "file_name")
    private String fileName;
}
