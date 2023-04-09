package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ladies.objects.ladiesentryfree.mappers.ObjectMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.ObjectStatus;
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
        objectCustomFieldsService.updateCustomFieldsValues(objectRepository.save(updatedObject), dto.getCustomFields());
    }

    public void delete(Integer id) {
        Object object = objectRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));
        objectRepository.delete(object);
    }

    public ObjectDTO getNewObject() {
        List<CustomFieldDTO> customFieldDTOS = objectCustomFieldsService.getAllFCustomFields();
        return new ObjectDTO(customFieldDTOS);
    }

    public ObjectDTO getObject(Integer id) {
        Object object = objectRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));

        return objectMapper.map(object, objectCustomFieldsService.getByObject(object));
    }

    public List<ObjectDTO> getObjects(Integer amount, Integer skip) {
        return objectRepository.findAll().stream().skip(skip).limit(amount).map(objectMapper::map).collect(Collectors.toList());
    }

    public long getTotalCount() {
        return objectRepository.count();
    }

    public long getCountByStatus(ObjectStatus status) {
        return objectRepository.countByStatus(status);
    }

}
