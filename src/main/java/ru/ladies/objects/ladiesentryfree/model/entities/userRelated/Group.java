package ru.ladies.objects.ladiesentryfree.model.entities.userRelated;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Group")
public class Group {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "type_of_work", nullable = false)
    private TypeOfWork typeOfWork;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;

}
