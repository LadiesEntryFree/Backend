package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Attribute;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.ObjectAttribute;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjectAttributeRepository extends JpaRepository<ObjectAttribute, ObjectAttribute.ObjectId> {

    List<ObjectAttribute> findByObject(Object object);

    Optional<ObjectAttribute> findByObjectAndAttribute(Object object, Attribute attribute);

}
