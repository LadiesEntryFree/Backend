package ru.ladies.objects.ladiesentryfree.mappers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDto;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.*;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ObjectMapper {

    private final AttachmentMapper attachmentMapper;

    public ObjectDto map(Object object, List<CustomFieldDTO> customFields) {
        if (object == null) {
            return new ObjectDto();
        }
        ObjectDto dto = new ObjectDto();
        dto.setId(object.getId());
        dto.setType(object.getType().getType());
        dto.setActualUser(object.getActualUser().getName());
        dto.setAddress(object.getAddress().getAddress());
        dto.setAreaMeasure(object.getArea().getMeasure().getMeasure());
        dto.setCounty(object.getCounty().getCounty());
        dto.setAreaValue(object.getArea().getValue());
        dto.setDistrict(object.getDistrict().getDistrict());
        dto.setOwner(object.getOwner().getName());
        dto.setStatus(object.getStatus().getStatus());
        dto.setAttachments(object.getAttachments().stream().map(attachmentMapper::map).toList());
        dto.setCustomFields(customFields);
        return dto;
    }

    public Object map(ObjectDto dto) {
        Object object = new Object();
        object.setCounty(new County(dto.getCounty()));
        object.setActualUser(new ActualUser(dto.getActualUser()));
        object.setAddress(new Address(dto.getAddress()));
        object.setDistrict(new District(dto.getDistrict()));
        object.setOwner(new Owner(dto.getOwner()));
        object.setType(new ObjectType(dto.getType()));
        object.setStatus(new ObjectStatus(dto.getStatus()));
        object.setArea(new Area(dto.getAreaValue(), new AreaMeasure(dto.getAreaMeasure())));
        object.setAttachments(dto.getAttachments().stream().map(attachmentMapper::map).toList());
        return object;
    }


}
