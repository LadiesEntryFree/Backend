package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Object;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findAllByObject(Object object);
}
