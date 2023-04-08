package ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name = "term", nullable = false)
    private java.time.Period term;

    @Column(name = "executor", nullable = false)
    private String executor;

    @OneToMany(mappedBy = "solution")
    private List<SolutionAttribute> attributes = new ArrayList<>();
}
