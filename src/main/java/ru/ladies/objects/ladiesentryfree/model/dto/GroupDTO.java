package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.TypeOfWork;

@Data
public class GroupDTO {
    private String name;
    private TypeOfWork typeOfWork;
}
