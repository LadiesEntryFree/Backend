package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;

public interface ObjectRepository extends JpaRepository<Object, Integer> {

}
