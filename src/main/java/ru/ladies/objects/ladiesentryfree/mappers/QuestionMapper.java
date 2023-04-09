package ru.ladies.objects.ladiesentryfree.mappers;

import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.QuestionDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Question;

@Component
public class QuestionMapper {

    public QuestionDTO map(Question question) {
        QuestionDTO dto = new QuestionDTO();
        dto.setQuestion(question.getQuestion());
        dto.setId(question.getId());
        return dto;
    }

    public Question map(QuestionDTO dto) {
        Question question = new Question();
        question.setQuestion(dto.getQuestion());
        question.setId(dto.getId());
        return question;
    }
}
