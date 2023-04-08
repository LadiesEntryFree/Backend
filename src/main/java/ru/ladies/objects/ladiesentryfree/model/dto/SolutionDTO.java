package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class SolutionDTO {
    private String statement;
    private String term;
    private String executor;
    private List<CustomFieldDTO> customFields;
}
