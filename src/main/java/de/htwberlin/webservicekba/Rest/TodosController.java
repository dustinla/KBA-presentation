package de.htwberlin.webservicekba.Rest;

import de.htwberlin.webservicekba.Model.Todo;
import de.htwberlin.webservicekba.Repo.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("todos")
public class TodosController {


    //TODO Repos eig in eigene Services
    private final TodoRepository todoRepository;

    public TodosController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @GetMapping("")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();

        return new ResponseEntity<>(todos, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        Todo todos = todoRepository.save(todo);
        return new ResponseEntity<>(todos, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> saveTodo(@PathVariable("id") Long id) {
        todoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        Optional<Todo> findTodo = todoRepository.findById(id);
        Todo todo1 = null;
        if (findTodo.isPresent()) {
            todo1 = findTodo.get();
            if (todo.getBeschreibung() != null) {
                todo1.setBeschreibung(todo.getBeschreibung());
            }
            if (todo.getTitel() != null) {
                todo1.setTitel(todo.getTitel());
            }

            todoRepository.save(todo1);
        }

        return new ResponseEntity<>(todo1, HttpStatus.OK);
    }
}
