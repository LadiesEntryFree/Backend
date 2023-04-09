package ru.ladies.objects.ladiesentryfree.mappers;

import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.AttributeValue;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionAttribute;
import ru.ladies.objects.ladiesentryfree.service.CustomSolutionFieldsService;

import java.util.List;

@Component
public class AttributeMapper {

    public CustomFieldDTO map(SolutionAttribute solutionAttribute, List<String> possibleValues) {

        CustomFieldDTO dto = new CustomFieldDTO();

        if (solutionAttribute == null) {
            dto.setPossibleValues(possibleValues);
            return dto;
        }

        dto.setName(solutionAttribute.getAttribute().getName());
        dto.setType(solutionAttribute.getAttribute().getType());
        dto.setValue(solutionAttribute.getValue().getValue());
        dto.setPossibleValues(possibleValues);
        return dto;
    }
}
