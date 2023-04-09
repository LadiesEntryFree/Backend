package ru.ladies.objects.ladiesentryfree.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.SolutionDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Attribute;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.AttributeValue;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionAttribute;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionStatus;

import java.time.Period;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SolutionMapper {
    public Solution map(SolutionDTO solutionDTO) {
        Solution solution = new Solution();

        solution.setStatement(solutionDTO.getStatement());
        solution.setExecutor(solutionDTO.getExecutor());
        solution.setStart(solutionDTO.getStart());
        solution.setEnd(solutionDTO.getEnd());
        solution.setSolutionStatus(solutionDTO.getSolutionStatus());

        return solution;
    }

    public Solution map(Solution oldSolution, SolutionDTO solutionDTO) {
        oldSolution.setStatement(solutionDTO.getStatement());
        oldSolution.setExecutor(solutionDTO.getExecutor());
        oldSolution.setStart(solutionDTO.getStart());
        oldSolution.setEnd(solutionDTO.getEnd());
        oldSolution.setSolutionStatus(solutionDTO.getSolutionStatus());

        return oldSolution;
    }

    public SolutionDTO map (Solution solution) {
        SolutionDTO solutionDTO = new SolutionDTO();

        solutionDTO.setStatement(solution.getStatement());
        solutionDTO.setExecutor(solution.getExecutor());
        solutionDTO.setStart(solution.getStart());
        solutionDTO.setEnd(solution.getEnd());
        solutionDTO.setSolutionStatus(solution.getSolutionStatus());

        return solutionDTO;
    }
}
