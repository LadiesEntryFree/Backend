package ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;

@Data
@Entity
@Table(name = "Solution")
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "statement", nullable = false)
    private String statement;

    @Column(name = "start_execution", nullable = false)
    private LocalDateTime start;

    @Column(name = "end_execution", nullable = false)
    private LocalDateTime end;

    @Column(name = "solution_status")
    @Enumerated(EnumType.STRING)
    private SolutionStatus solutionStatus;

    @Column(name = "executor", nullable = false)
    private String executor;

    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "id", nullable = false)
    private Object object;

    @OneToMany(mappedBy = "solution")
    private List<SolutionAttribute> attributes = new ArrayList<>();
}
