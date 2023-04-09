package ru.ladies.objects.ladiesentryfree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.ExecutionGroup;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<ExecutionGroup, Integer> {
    Optional<ExecutionGroup> findByGroupName(String name);
    //List<ExecutionGroup> findByUsers(List<User> users);
}
