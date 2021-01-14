package de.htwberlin.webservicekba.service;

import de.htwberlin.webservicekba.model.Todo;
import de.htwberlin.webservicekba.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodosServiceImpl implements TodosService {

    private final TodoRepository todoRepository;

    public TodosServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findSingleTodo(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Optional<Todo> findTodoByTitel(String titel) {
        return todoRepository.findByTitel(titel);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
