package ru.ladies.objects.ladiesentryfree.model.dto.dashboardRelated;

import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.ObjectStatus;

import java.util.EnumMap;

@Data
public class ObjectStatusCountDTO {

    private EnumMap<ObjectStatus, Long> objectStatusAndCount;
}
