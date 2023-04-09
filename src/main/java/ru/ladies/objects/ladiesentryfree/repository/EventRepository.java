package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.event.Event;
import ru.ladies.objects.ladiesentryfree.model.entities.event.EventStatus;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    Event save(Event event);

    List<Event> findByStatus(EventStatus status);
}
