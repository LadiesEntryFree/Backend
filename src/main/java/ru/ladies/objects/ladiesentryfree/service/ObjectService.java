package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ladies.objects.ladiesentryfree.mappers.ObjectMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDto;
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

    public void save(ObjectDto dto) {
        objectRepository.save(objectMapper.map(dto));

    }

    public void edit(int id, ObjectDto dto) {
        Optional<Object> maybeOldObject = objectRepository.findById(id);
        Object updatedObject = objectMapper.map(dto);
    }

    public void delete(int id, ObjectDto dto) {

    }

    public ObjectDto getNewObject() {
        return new ObjectDto();
    }

    public ObjectDto getObject(int id) {
        return new ObjectDto();
    }

    public List<ObjectDto> getObjects() {
        return List.of();
    }

}
