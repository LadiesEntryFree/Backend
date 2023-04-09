package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.ObjectStatus;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Integer> {

    Object save(Object object);

    long countByStatus(ObjectStatus status);

}
