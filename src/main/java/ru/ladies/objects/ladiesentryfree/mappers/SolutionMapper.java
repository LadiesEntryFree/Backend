package ru.ladies.objects.ladiesentryfree.mappers;

import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.SolutionDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;

import java.time.Period;

@Component
public class SolutionMapper {
    public Solution map(SolutionDTO solutionDTO) {
        Solution solution = new Solution();

        solution.setStatement(solutionDTO.getStatement());
        solution.setTerm(Period.parse(solutionDTO.getTerm()));
        solution.setExecutor(solutionDTO.getExecutor());
        solution.setAttributes(solutionDTO.getCustomFields());

        //TODO сделать маппинг кастом филдс - аттрибуты

        return solution;
    }

    public SolutionDTO map (Solution solution) {
        SolutionDTO solutionDTO = new SolutionDTO();

        solutionDTO.setStatement(solution.getStatement());
        solutionDTO.setTerm(solution.getTerm().toString());
        solutionDTO.setExecutor(solution.getExecutor());

        //TODO обратные аттрибуты

        return solutionDTO;
    }
}
