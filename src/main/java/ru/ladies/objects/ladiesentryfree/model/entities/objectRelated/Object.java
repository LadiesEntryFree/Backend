package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;

import java.util.List;

@Data
@Entity
@Table(name = "Object")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    private String county;

    @NotNull
    private String district;

    @NotNull
    private String address;

    @NotNull
    private String type;

    @NotNull
    private String status;

    @NotNull
    private Double area;

    @NotNull
    private String owner;

    @NotNull
    private String actualUser;

    @OneToMany(mappedBy = "object")
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "object")
    private List<Solution> solutions;

}
