package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.ladies.objects.ladiesentryfree.mappers.ObjectMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.FilterDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.ObjectDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.repository.ObjectRepository;

@Service
@RequiredArgsConstructor
public class ObjectRegistryService {

    private final ObjectRepository objectRepository;

    private final ObjectMapper objectMapper;

    public Page<ObjectDTO> getObjectsRegistry(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return objectRepository.findAll(pageable).map(objectMapper::map);
    }

    public Page<ObjectDTO> getObjectsRegistryByFilter(int pageNumber, int pageSize, FilterDTO filterDTO) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Object> example = Example.of(objectMapper.map(filterDTO), matcher);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return objectRepository.findAll(example, pageable).map(objectMapper::map);
    }

}
