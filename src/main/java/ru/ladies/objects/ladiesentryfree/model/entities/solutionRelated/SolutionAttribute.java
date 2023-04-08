package ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Attribute;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.AttributeValue;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Solution_Attribute")
@IdClass(SolutionAttribute.SolutionAttributeId.class)
@AllArgsConstructor
@NoArgsConstructor
public class SolutionAttribute {
    @Id
    @ManyToOne
    @JoinColumn(name = "solution_id", nullable = false)
    private Solution solution;

    @Id
    @ManyToOne
    @JoinColumn(name = "attribute", nullable = false)
    private Attribute attribute;

    @Id
    @ManyToOne
    @JoinColumn(name = "value_id", nullable = false)
    private AttributeValue value;


    @Data
    public static class SolutionAttributeId implements Serializable {
        private Integer solution;
        private String attribute;
        private Integer value;
    }

}
