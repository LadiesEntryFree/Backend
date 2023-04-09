package ru.ladies.objects.ladiesentryfree.model.dto.dashboardRelated;

import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.event.EventStatus;

import java.util.EnumMap;

@Data
public class EventStatusCountDTO {

    private EnumMap<EventStatus, Long> eventStatusAndCount;
}
