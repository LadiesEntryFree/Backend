package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ladies.objects.ladiesentryfree.mappers.SolutionMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.SolutionDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.ExecutionGroup;
import ru.ladies.objects.ladiesentryfree.repository.GroupRepository;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionStatus;
import ru.ladies.objects.ladiesentryfree.repository.SolutionRepository;
import ru.ladies.objects.ladiesentryfree.utils.exception.NoEntityFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionRepository solutionRepository;
    private final SolutionMapper solutionMapper;
    private final CustomSolutionFieldsService customSolutionFieldsService;
    private final GroupRepository groupRepository;


    public Integer createSolution(SolutionDTO solutionDTO) {
        Solution solution = solutionMapper.map(solutionDTO);

        Solution created = solutionRepository.save(solution);

        ExecutionGroup executionGroup = groupRepository.findByGroupName(solutionDTO.getExecutor().getName()).get();
        solution.setExecutor(executionGroup);

        return created.getId();
    }

    @Transactional
    public void updateSolution(Integer id, SolutionDTO solutionDTO) {
        Solution oldSolution = solutionRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Нет решения с id " + id));

        ExecutionGroup executor = groupRepository.findByGroupName(solutionDTO.getExecutor().getName()).get();

        Solution solution = solutionMapper.map(oldSolution, solutionDTO);
        solution.setExecutor(executor);
        solutionRepository.save(solution);

        customSolutionFieldsService.updateCustomFieldsValuesOfSolution(solution, solutionDTO.getCustomFields());
    }

    public SolutionDTO getSolution(Integer id) {
        Optional<Solution> solution = solutionRepository.findById(id);

        return solutionMapper.map(solution.get());
    }

    public SolutionDTO getEmptySolution() {
        List<CustomFieldDTO> solutionCustomFields = customSolutionFieldsService.getAllSolutionFields();
        return new SolutionDTO(solutionCustomFields);
    }

    public List<SolutionDTO> getSolutions(Integer amount, Integer skip) {
        return solutionRepository.findAll().stream().skip(skip).limit(amount).map(solutionMapper::map).collect(Collectors.toList());
    }

    public void overdueSolutions() {
        List<Solution> solutions = solutionRepository.findAllByEndBeforeAndSolutionStatusIsNot(LocalDateTime.now(), SolutionStatus.COMPLETED);
        for (Solution solution : solutions) {
            solution.setSolutionStatus(SolutionStatus.EXPIRED);
            solutionRepository.save(solution);
        }
    }
}
