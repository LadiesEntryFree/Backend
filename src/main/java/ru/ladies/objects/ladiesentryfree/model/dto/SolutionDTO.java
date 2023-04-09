package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SolutionDTO {
    private String statement;
    private LocalDateTime start;
    private LocalDateTime end;
    private SolutionStatus solutionStatus;
    private String executor;
    private List<CustomFieldDTO> customFields;

    public SolutionDTO(){}

    public SolutionDTO(List<CustomFieldDTO> customFields) {
        this.customFields = customFields;
    }
}
