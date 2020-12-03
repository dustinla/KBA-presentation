package de.htwberlin.webservicekba.Rest;
import de.htwberlin.webservicekba.Model.Todo;
import de.htwberlin.webservicekba.Repo.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KempaController {


    //TODO Repos eig in eigene Services
    private final TodoRepository todoRepository;

    public KempaController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("kempa")
    public ResponseEntity<String> kempa(){

        return new  ResponseEntity<>("HALLO KEMPA", HttpStatus.OK);
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();

        return new ResponseEntity<>(todos, HttpStatus.OK);

    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        Todo todos = todoRepository.save(todo);
        return new ResponseEntity<>(todos, HttpStatus.CREATED);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> saveTodo(@PathVariable("id") Long id) {
        todoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        Optional<Todo> findTodo = todoRepository.findById(id);
        Todo todo1 = null;
        if (findTodo.isPresent()) {
            todo1 = findTodo.get();
            if (!todo.getBeschreibung().isEmpty()) {
                todo1.setBeschreibung(todo.getBeschreibung());
            }
            if (!todo.getTitel().isEmpty()) {
                todo1.setTitel(todo.getTitel());
            }

            todoRepository.save(todo1);
        }
        
        return new ResponseEntity<>(todo1, HttpStatus.OK);
    }
}
