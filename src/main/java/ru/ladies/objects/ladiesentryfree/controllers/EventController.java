package ru.ladies.objects.ladiesentryfree.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ladies.objects.ladiesentryfree.model.dto.EventDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.event.EventStatus;
import ru.ladies.objects.ladiesentryfree.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/new")
    public ResponseEntity<Integer> create(@RequestBody EventDTO dto) {
        return new ResponseEntity<>(eventService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/new")
    public ResponseEntity<EventDTO> getFields() {
        return new ResponseEntity<>(new EventDTO(),HttpStatus.OK);
    }

    @GetMapping("/by/status")
    public ResponseEntity<List<EventDTO>> getByStatus(@RequestParam EventStatus status) {
        return new ResponseEntity<>(eventService.getByStatus(status),HttpStatus.OK);
    }
}
