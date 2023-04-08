package ru.ladies.objects.ladiesentryfree.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDto;
import ru.ladies.objects.ladiesentryfree.service.ObjectService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/objects")
@RequiredArgsConstructor
public class ObjectController {

    private final ObjectService objectService;


    @PostMapping("/new")
    public ResponseEntity<Integer> createObject(@RequestBody ObjectDto dto) {
        return new ResponseEntity<>(objectService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<HttpStatus> updateObject(@PathVariable Integer id, @RequestBody ObjectDto dto) {
        objectService.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> deleteObject(@PathVariable Integer id) {
        objectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<ObjectDto> getEmptyObject() {
        return new ResponseEntity<>(objectService.getNewObject(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectDto> getObject(@PathVariable Integer id) {
        return new ResponseEntity<>(objectService.getObject(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ObjectDto>> getObjects(@RequestParam Integer amount, @RequestParam Integer skip) {
        return new ResponseEntity<>(objectService.getObjects(amount, skip), HttpStatus.OK);
    }
}
