package ru.ladies.objects.ladiesentryfree.controllers.publicApi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.SolutionDTO;
import ru.ladies.objects.ladiesentryfree.service.ObjectService;
import ru.ladies.objects.ladiesentryfree.service.SolutionService;

@RestController
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class PublicController {
    private final ObjectService objectService;
    private final SolutionService solutionService;


    @PostMapping("object/new")
    public ResponseEntity<Integer> createObject(@RequestBody ObjectDTO dto) {
        return new ResponseEntity<>(objectService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("object/{id}/edit")
    public ResponseEntity<HttpStatus> updateObject(@PathVariable Integer id, @RequestBody ObjectDTO dto) {
        objectService.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("object/{id}/delete")
    public ResponseEntity<HttpStatus> deleteObject(@PathVariable Integer id) {
        objectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("object/{id}")
    public ResponseEntity<ObjectDTO> getObject(@PathVariable Integer id) {
        return new ResponseEntity<>(objectService.getObject(id), HttpStatus.OK);
    }

    @PostMapping("solutions/new")
    public ResponseEntity<Integer> createSolution(SolutionDTO solutionDTO) {
        Integer createdSolutionId = solutionService.createSolution(solutionDTO);
        return new ResponseEntity<>(createdSolutionId, HttpStatus.OK);
    }

    @PutMapping("solutions/{id}/edit")
    public ResponseEntity<HttpStatus> updateSolution(@PathVariable Integer id, SolutionDTO solutionDTO) {
        solutionService.updateSolution(id, solutionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("solutions/{id}")
    public ResponseEntity<SolutionDTO> getSolution(@PathVariable Integer id) {
        return new ResponseEntity<>(solutionService.getSolution(id), HttpStatus.OK);
    }
}
