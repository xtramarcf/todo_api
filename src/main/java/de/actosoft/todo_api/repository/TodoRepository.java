package de.actosoft.todo_api.repository;

import de.actosoft.todo_api.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
