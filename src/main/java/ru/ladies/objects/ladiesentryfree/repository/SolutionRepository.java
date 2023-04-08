package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {
}
