package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.event.EventStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDTO {
    private Integer id;
    private LocalDateTime start;
    private LocalDateTime end;
    private EventStatus status;
    private List<ObjectDTO> objects;
}
