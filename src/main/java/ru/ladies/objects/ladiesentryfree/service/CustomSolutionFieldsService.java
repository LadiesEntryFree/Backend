package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ladies.objects.ladiesentryfree.mappers.AttributeMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Attribute;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.AttributeValue;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.Solution;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionAttribute;
import ru.ladies.objects.ladiesentryfree.repository.AttributeRepository;
import ru.ladies.objects.ladiesentryfree.repository.AttributeValueRepository;
import ru.ladies.objects.ladiesentryfree.repository.SolutionAttributeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomSolutionFieldsService {
    private final AttributeValueRepository attributeValueRepository;
    private final SolutionAttributeRepository solutionAttributeRepository;
    private final AttributeRepository attributeRepository;

    private final AttributeMapper attributeMapper;

    public List<CustomFieldDTO> getAllSolutionFields() {
        List<SolutionAttribute> solutionAttributes = solutionAttributeRepository.findAll();

        return solutionAttributes.stream()
                .map(solutionAttribute -> attributeMapper.map(solutionAttribute, new ArrayList<>())).toList();
    }

    public List<CustomFieldDTO> getBySolution(Solution solution) {
        List<SolutionAttribute> solutionAttributes = solutionAttributeRepository.findBySolution(solution);
        return solutionAttributes.stream().map(solutionAttribute ->
        {
            List<String> values = attributeValueRepository.findByAttribute(solutionAttribute.getAttribute()).stream()
                    .map(AttributeValue::getValue)
                    .toList();
            return attributeMapper.map(solutionAttribute, values);
        }).toList();
    }

    @Transactional
    public void updateCustomFieldsValuesOfSolution(Solution solution, List<CustomFieldDTO> customFieldDTOS) {
        customFieldDTOS.forEach(customFieldDTO -> {
            Attribute attribute = attributeRepository.findByName(customFieldDTO.getName())
                    .orElse(attributeRepository.save(new Attribute(customFieldDTO.getName(), customFieldDTO.getType())));
            Optional<SolutionAttribute> maybeObjectAttribute = solutionAttributeRepository.findBySolutionAndAttribute(solution, attribute);

            if (maybeObjectAttribute.isPresent()) {
                SolutionAttribute objectAttribute = maybeObjectAttribute.get();
                AttributeValue value = objectAttribute.getValue();
                if (!Objects.equals(value.getValue(), customFieldDTO.getValue())) {
                    AttributeValue newValue = attributeValueRepository.save(new AttributeValue(attribute, customFieldDTO.getValue()));
                    objectAttribute.setValue(newValue);

                }
            } else {
                SolutionAttribute objectAttribute =
                        new SolutionAttribute(solution, attribute, attributeValueRepository.save(new AttributeValue(attribute, customFieldDTO.getValue())));
                solutionAttributeRepository.save(objectAttribute);
            }

        });


    }
}
