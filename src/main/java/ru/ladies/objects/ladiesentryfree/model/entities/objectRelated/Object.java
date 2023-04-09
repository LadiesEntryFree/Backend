package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.*;
import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;

import java.util.List;

@Data
@Entity
@Table(name = "Object")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "county", nullable = false)
    private County county;

    @ManyToOne
    @JoinColumn(name = "district", nullable = false)
    private District district;

    @ManyToOne
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private ObjectType type;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private ObjectStatus status;

    @ManyToOne
    @JoinColumn(name = "area", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "actual_user", nullable = false)
    private ActualUser actualUser;

    @OneToMany(mappedBy = "object")
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "object")
    private List<Solution> solutions;

}
