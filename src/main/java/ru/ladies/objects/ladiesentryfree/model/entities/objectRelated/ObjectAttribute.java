package ru.ladies.objects.ladiesentryfree.model.entities.objectRelated;

import jakarta.persistence.*;
import lombok.Data;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.Attribute;
import ru.ladies.objects.ladiesentryfree.model.entities.attribute.AttributeValue;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Object_Attribute")
@IdClass(ObjectAttribute.ObjectId.class)
public class ObjectAttribute {
    @Id
    @ManyToOne
    @JoinColumn(name = "object_id", nullable = false)
    private Object object;

    @Id
    @ManyToOne
    @JoinColumn(name = "attribute", nullable = false)
    private Attribute attribute;

    @Id
    @ManyToOne
    @JoinColumn(name = "value_id", nullable = false)
    private AttributeValue value;


    @Data
    public static class ObjectId implements Serializable {
        private Integer object;
        private String attribute;
        private Integer value;
    }

}
