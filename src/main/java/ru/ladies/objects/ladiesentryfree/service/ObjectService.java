package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ladies.objects.ladiesentryfree.mappers.ObjectMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.repository.ObjectRepository;
import ru.ladies.objects.ladiesentryfree.utils.exception.NoEntityFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectService {

    private final ObjectRepository objectRepository;
    private final ObjectMapper objectMapper;
    private final ObjectCustomFieldsService objectCustomFieldsService;

    //TODO дописать

    public Integer create(ObjectDTO dto) {
        return objectRepository.save(objectMapper.map(dto)).getId();

    }

    @Transactional
    public void update(Integer id, ObjectDTO dto) {
        Object oldObject = objectRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));

        Object updatedObject = objectMapper.map(dto);
        updatedObject.setId(oldObject.getId());

        objectRepository.save(updatedObject);
    }

    public void delete(Integer id) {
        Object object = objectRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));
        objectRepository.delete(object);
    }

    public ObjectDTO getNewObject() {
        return new ObjectDTO();
    }

    public ObjectDTO getObject(Integer id) {
        Object object = objectRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));

        return objectMapper.map(object, objectCustomFieldsService.getByObject(object));
    }

    public List<ObjectDTO> getObjects(Integer amount, Integer skip) {
        return objectRepository.findAll().stream().skip(skip).limit(amount).map(objectMapper::map).collect(Collectors.toList());
    }

}
