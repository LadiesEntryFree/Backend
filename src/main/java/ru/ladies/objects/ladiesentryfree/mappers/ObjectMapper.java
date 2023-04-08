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

    public ObjectDTO map(Object object, List<CustomFieldDTO> customFields) {
        if (object == null) {
            return new ObjectDTO();
        }
        ObjectDTO dto = new ObjectDTO();
        dto.setId(object.getId());
        dto.setType(object.getType());
        dto.setActualUser(object.getActualUser());
        dto.setAddress(object.getAddress());

        dto.setCounty(object.getCounty());
        dto.setArea(object.getArea());
        dto.setDistrict(object.getDistrict());
        dto.setOwner(object.getOwner());
        dto.setStatus(object.getStatus());
        dto.setAttachments(object.getAttachments().stream().map(attachmentMapper::map).toList());
        return dto;
    }

    public ObjectDto map(Object object, List<CustomFieldDTO> customFields) {
        ObjectDto dto = map(object);
        dto.setCustomFields(customFields);
        return dto;
    }


    public Object map(ObjectDTO dto) {
        Object object = new Object();
        object.setId(dto.getId());
        object.setCounty(dto.getCounty());
        object.setActualUser(dto.getActualUser());
        object.setAddress(dto.getAddress());
        object.setDistrict(dto.getDistrict());
        object.setOwner(dto.getOwner());
        object.setType(dto.getType());
        object.setStatus(dto.getStatus());
        object.setArea(dto.getArea());
        object.setAttachments(dto.getAttachments().stream().map(attachmentMapper::map).toList());
        return object;
    }

    public Object map(FilterDTO dto) {
        Object object = new Object();
        object.setCounty(dto.getCounty());
        object.setActualUser(new ActualUser(dto.getActualUser()));
        object.setAddress(new Address(dto.getAddress()));
        object.setDistrict(new District(dto.getDistrict()));
        object.setOwner(new Owner(dto.getOwner()));
        object.setType(new ObjectType(dto.getType()));
        object.setStatus(new ObjectStatus(dto.getStatus()));
        return object;
    }


}
