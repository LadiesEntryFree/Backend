package ru.ladies.objects.ladiesentryfree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ladies.objects.ladiesentryfree.mappers.SolutionMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.SolutionDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;
import ru.ladies.objects.ladiesentryfree.repository.SolutionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolutionService {
    private final SolutionRepository solutionRepository;

    private final SolutionMapper solutionMapper;

    @Autowired
    public SolutionService(SolutionRepository solutionRepository, SolutionMapper solutionMapper) {
        this.solutionRepository = solutionRepository;
        this.solutionMapper = solutionMapper;
    }

    public void createSolution(SolutionDTO solutionDTO) {
        Solution solution = solutionMapper.map(solutionDTO);

        solutionRepository.save(solution);
    }

    public boolean isExists(Integer id) {
        Optional<Solution> solution = solutionRepository.findById(id);

        return solution.isPresent();
    }

    public void updateSolution(Integer id, SolutionDTO solutionDTO) {
        Solution solution = solutionMapper.map(solutionDTO);
        solution.setId(id);

        solutionRepository.save(solution);
    }

    public SolutionDTO getSolution(Integer id) {
        Optional<Solution> solution = solutionRepository.findById(id);

        return solutionMapper.map(solution.get());
    }

//    public SolutionDTO getSolutionFields() {
//        List<CustomFieldDTO> solutionCustomFields =
//    }
    //TODO сделать нормальный маппинг кастомных полей. Смотреть в маппере

    public List<SolutionDTO> getSolutions() {
        //TODO доставать порционно решения из бд и отправлять на фронт
    }
}
