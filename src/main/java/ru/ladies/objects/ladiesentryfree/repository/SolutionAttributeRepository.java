package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Attribute;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionAttribute;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolutionAttributeRepository extends JpaRepository<SolutionAttribute, SolutionAttribute.SolutionAttributeId> {
    List<SolutionAttribute> findBySolution(Solution solution);

    Optional<SolutionAttribute> findBySolutionAndAttribute(Solution solution, Attribute attribute);
}
