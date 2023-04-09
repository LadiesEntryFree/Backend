package ru.ladies.objects.ladiesentryfree.mappers;

import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.GroupDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.ExecutionGroup;

@Component
public class GroupMapper {
    public GroupDTO map(ExecutionGroup executionGroup) {
        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setName(executionGroup.getGroupName());
        groupDTO.setTypeOfWork(executionGroup.getTypeOfWork());

        return groupDTO;
    }
}
