package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ladies.objects.ladiesentryfree.mappers.AttributeMapper;
import ru.ladies.objects.ladiesentryfree.model.dto.CustomFieldDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Attribute;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.AttributeValue;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.ObjectAttribute;
import ru.ladies.objects.ladiesentryfree.repository.AttributeRepository;
import ru.ladies.objects.ladiesentryfree.repository.AttributeValueRepository;
import ru.ladies.objects.ladiesentryfree.repository.ObjectAttributeRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomFieldsService {

    private final AttributeValueRepository attributeValueRepository;
    private final ObjectAttributeRepository objectAttributeRepository;
    private final AttributeRepository attributeRepository;

    private final AttributeMapper attributeMapper;

    public List<CustomFieldDTO> getByObject(Object object) {
        List<ObjectAttribute> objectAttributes = objectAttributeRepository.findByObject(object);
        return objectAttributes.stream().map(objectAttribute ->
        {
            List<String> values = attributeValueRepository.findByAttribute(objectAttribute.getAttribute()).stream()
                    .map(AttributeValue::getValue)
                    .toList();
            return attributeMapper.map(objectAttribute, values);
        }).toList();


    }

    @Transactional
    public void updateCustomFieldsValuesOfObject(Object object, List<CustomFieldDTO> customFieldDTOS) {
        customFieldDTOS.forEach(customFieldDTO -> {
            Attribute attribute = attributeRepository.findByName(customFieldDTO.getName())
                    .orElse(attributeRepository.save(new Attribute(customFieldDTO.getName(), customFieldDTO.getType())));
            Optional<ObjectAttribute> maybeObjectAttribute = objectAttributeRepository.findByObjectAndAttribute(object, attribute);

            if (maybeObjectAttribute.isPresent()) {
                ObjectAttribute objectAttribute = maybeObjectAttribute.get();
                AttributeValue value = objectAttribute.getValue();
                if (!Objects.equals(value.getValue(), customFieldDTO.getValue())) {
                    AttributeValue newValue = attributeValueRepository.save(new AttributeValue(attribute, customFieldDTO.getValue()));
                    objectAttribute.setValue(newValue);

                }
            } else {
                ObjectAttribute objectAttribute = new ObjectAttribute(object, attribute, new AttributeValue(attribute, customFieldDTO.getValue()));
                objectAttributeRepository.save(objectAttribute);
            }

        });


    }

}
