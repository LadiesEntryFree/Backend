package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ladies.objects.ladiesentryfree.mappers.ObjectMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.repository.ObjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObjectService {

    private final ObjectRepository objectRepository;
    private final ObjectMapper objectMapper;

    //TODO дописать

    public void save(ObjectDTO dto) {
        objectRepository.save(objectMapper.map(dto));

    }

    public void edit(int id, ObjectDTO dto) {
        Optional<Object> maybeOldObject = objectRepository.findById(id);
        Object updatedObject = objectMapper.map(dto);
    }

    public void delete(int id, ObjectDTO dto) {

    }

    public ObjectDTO getNewObject() {
        return new ObjectDTO();
    }

    public ObjectDTO getObject(int id) {
        return new ObjectDTO();
    }

    public List<ObjectDTO> getObjects() {
        return List.of();
    }

}
