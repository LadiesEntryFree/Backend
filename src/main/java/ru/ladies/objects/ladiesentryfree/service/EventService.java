package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ladies.objects.ladiesentryfree.mappers.EventMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.EventDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.event.Event;
import ru.ladies.objects.ladiesentryfree.model.entities.event.EventStatus;
import ru.ladies.objects.ladiesentryfree.repository.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventMapper eventMapper;
    private final EventRepository eventRepository;

    @Transactional
    public Integer create(EventDTO dto) {
        Event event = eventMapper.map(dto);
        return eventRepository.save(event).getId();
    }

    public List<EventDTO> getByStatus(EventStatus status) {
        return eventRepository.findByStatus(status).stream().map(eventMapper::map).toList();
    }


}
