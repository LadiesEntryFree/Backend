package ru.ladies.objects.ladiesentryfree.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ladies.objects.ladiesentryfree.model.dto.EventDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDTO;
import ru.ladies.objects.ladiesentryfree.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class UserTasksController {
    private final EventService eventService;

    @GetMapping("/{id}/events")
    public ResponseEntity<List<EventDTO>> getUserEvents(@PathVariable Integer id) {
        return new ResponseEntity<>(eventService.getEventsByUser(id), HttpStatus.OK);
    }
}
