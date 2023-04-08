package ru.ladies.objects.ladiesentryfree.mappers;

import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.ObjectAttribute;

import java.util.List;

@Component
public class AttributeMapper {

    public CustomFieldDTO map(ObjectAttribute objectAttribute, List<String> possibleValues) {

        CustomFieldDTO dto = new CustomFieldDTO();

        if (objectAttribute == null) {
            dto.setPossibleValues(possibleValues);
            return dto;
        }

        dto.setName(objectAttribute.getAttribute().getName());
        dto.setType(objectAttribute.getAttribute().getType());
        dto.setValue(objectAttribute.getValue().getValue());
        dto.setPossibleValues(possibleValues);
        return dto;
    }

}
