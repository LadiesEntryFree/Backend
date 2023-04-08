package ru.ladies.objects.ladiesentryfree.mappers;


import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDto;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Type;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.*;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;


@Component
public class ObjectMapper {

    //TODO доделать

    public ObjectDto map(Object object) {
        if (object == null) {
            return new ObjectDto();
        }
        ObjectDto dto = new ObjectDto();
        dto.setType(object.getType().getType());
        dto.setActualUser(object.getActualUser().getName());
        dto.setAddress(object.getAddress().getAddress());
        dto.setAreaMeasure(object.getArea().getMeasure().getMeasure());
        dto.setCounty(object.getCounty().getCounty());
        dto.setAreaValue(object.getArea().getValue());
        dto.setDistrict(object.getDistrict().getDistrict());
        dto.setOwner(object.getOwner().getName());
        dto.setStatus(object.getStatus().getStatus());
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
        return object;
    }


}
