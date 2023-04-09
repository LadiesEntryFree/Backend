package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionStatus;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.ExecutionGroup;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {

    List<Solution> findAllByEndBeforeAndSolutionStatusIsNot(LocalDateTime end, SolutionStatus solutionStatus);

    Solution findByExecutor(ExecutionGroup userGroup);
}
