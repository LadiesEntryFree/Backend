package ru.ladies.objects.ladiesentryfree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ladies.objects.ladiesentryfree.exceptions.SolutionNotFoundException;
import ru.ladies.objects.ladiesentryfree.model.dto.SolutionDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;
import ru.ladies.objects.ladiesentryfree.service.SolutionService;

import java.util.List;

@RestController
@RequestMapping("/api/solutions")
public class SolutionController {
    private final SolutionService solutionService;

    @Autowired
    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createSolution(SolutionDTO solutionDTO) {
        solutionService.createSolution(solutionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<?> updateSolution(@PathVariable Integer id, SolutionDTO solutionDTO) {
        if (!solutionService.isExists(id)) {
            throw new SolutionNotFoundException("Solution with id " + id + " was not found");
        }

        solutionService.updateSolution(id, solutionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolutionDTO> getSolution(@PathVariable Integer id) {
        if (!solutionService.isExists(id)) {
            throw new SolutionNotFoundException("Solution with id " + id + " was not found");
        }

        return new ResponseEntity<>(solutionService.getSolution(id), HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<SolutionDTO> getSolutionFields() {
        return new ResponseEntity<>(solutionService.getSolutionFields(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SolutionDTO>> getSolutions() {
        return new ResponseEntity<>(solutionService.getSolutions(), HttpStatus.OK);
    }
}
