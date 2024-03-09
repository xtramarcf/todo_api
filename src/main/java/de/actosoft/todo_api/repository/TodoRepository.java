package de.actosoft.todo_api.repository;

import de.actosoft.todo_api.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Modifying
    @Query("update Todo t set t.title = ?1, t.text = ?2, t.done = ?3 where t.id = ?4")
    void updateTodoById(String title, String text, boolean done, int id);

}
