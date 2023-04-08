package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Type;

import java.util.List;

@Data
public class CustomFieldDTO {
    private String name;
    private String value;
    private Type type;
    private List<String> possibleValues;
}
