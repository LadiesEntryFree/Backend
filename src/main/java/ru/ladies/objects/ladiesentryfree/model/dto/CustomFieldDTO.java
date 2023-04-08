package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomFieldDTO {
    private String name;
    private String value;
    private String type;
    private List<String> possibleValues;
}
