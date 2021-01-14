package de.htwberlin.webservicekba.service;

import de.htwberlin.webservicekba.model.Todo;

import java.util.List;
import java.util.Optional;

/**
 * Simple CRUD Operation ohne logik
 */
public interface ITodosService {
    List<Todo> findAllTodos();

    Optional<Todo> findSingleTodo(Long id);

    Optional<Todo> findTodoByTitel(String titel);

    Todo saveTodo(Todo todo);

    void deleteTodo(Long id);
}
