package ru.ladies.objects.ladiesentryfree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ladies.objects.ladiesentryfree.model.dto.SolutionDTO;
import ru.ladies.objects.ladiesentryfree.service.SolutionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/solutions")
public class SolutionController {
    private final SolutionService solutionService;

    @Autowired
    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @PostMapping("/new")
    public ResponseEntity<Integer> createSolution(@RequestBody SolutionDTO solutionDTO) {
        Integer createdSolutionId = solutionService.createSolution(solutionDTO);
        return new ResponseEntity<>(createdSolutionId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<HttpStatus> updateSolution(@PathVariable Integer id, SolutionDTO solutionDTO) {
        solutionService.updateSolution(id, solutionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolutionDTO> getSolution(@PathVariable Integer id) {
        return new ResponseEntity<>(solutionService.getSolution(id), HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<SolutionDTO> getSolutionFields() {
        return new ResponseEntity<>(solutionService.getEmptySolution(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SolutionDTO>> getSolutions(@RequestParam Integer amount, @RequestParam Integer skip) {
        return new ResponseEntity<>(solutionService.getSolutions(amount, skip), HttpStatus.OK);
    }
}
