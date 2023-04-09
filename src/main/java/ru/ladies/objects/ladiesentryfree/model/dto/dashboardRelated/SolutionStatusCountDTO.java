package ru.ladies.objects.ladiesentryfree.model.dto.dashboardRelated;

import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated.SolutionStatus;

import java.util.EnumMap;

@Data
public class SolutionStatusCountDTO {

    private EnumMap<SolutionStatus, Long> solutionStatusAndCount;
}
