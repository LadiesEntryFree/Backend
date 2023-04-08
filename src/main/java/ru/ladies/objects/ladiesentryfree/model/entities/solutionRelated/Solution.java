package ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "start", nullable = false)
    private LocalDateTime start;

    @Column(name = "end", nullable = false)
    private LocalDateTime end;

    @Column(name = "solution_status")
    @Enumerated(EnumType.STRING)
    private SolutionStatus solutionStatus;

    @Column(name = "executor", nullable = false)
    private String executor;

    @OneToMany(mappedBy = "solution")
    private List<SolutionAttribute> attributes = new ArrayList<>();
}
