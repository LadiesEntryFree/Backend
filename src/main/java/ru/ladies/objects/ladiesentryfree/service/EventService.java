package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ladies.objects.ladiesentryfree.mappers.EventMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.EventDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.event.Event;
import ru.ladies.objects.ladiesentryfree.model.entities.event.EventStatus;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.ExecutionGroup;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.User;
import ru.ladies.objects.ladiesentryfree.repository.EventRepository;
import ru.ladies.objects.ladiesentryfree.repository.GroupRepository;
import ru.ladies.objects.ladiesentryfree.repository.SolutionRepository;
import ru.ladies.objects.ladiesentryfree.repository.UserRepository;
import ru.ladies.objects.ladiesentryfree.utils.exception.NoEntityFoundException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventMapper eventMapper;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final SolutionRepository solutionRepository;

    @Transactional
    public Integer create(EventDTO dto) {
        Event event = eventMapper.map(dto);
        return eventRepository.save(event).getId();
    }

    public List<EventDTO> getByStatus(EventStatus status) {
        return eventRepository.findByStatus(status).stream().map(eventMapper::map).toList();
    }

    public void overdueEvents() {
        List<Event> events = eventRepository.findAllByEndBeforeAndAndStatusIsNot(LocalDateTime.now(), EventStatus.PAST);
        for (Event event : events) {
            event.setStatus(EventStatus.PAST);
            eventRepository.save(event);
        }
    }

    public List<EventDTO> getEventsByUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));

        List<ExecutionGroup> userGroups = user.getExecutionGroups();

        List<Solution> groupSolutions = new ArrayList<>();
        for (ExecutionGroup group : userGroups) {
            groupSolutions.addAll(group.getSolutions());
        }

        List<Object> objects = new ArrayList<>();
        for (Solution solution : groupSolutions) {
            objects.add(solution.getObject());
        }

        List<Event> allEvents = new ArrayList<>();
        for (Object object : objects) {
            allEvents.addAll(object.getEvents());
        }

        List<Event> distinctEvents = allEvents.stream().distinct().toList();

        List<EventDTO> eventDTOs = new ArrayList<>();
        for (Event event : distinctEvents) {
            eventDTOs.add(eventMapper.map(event));
        }

        return eventDTOs;
    }
}
