package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Integer> {

}
