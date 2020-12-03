package de.htwberlin.webservicekba.Rest;
import de.htwberlin.webservicekba.Model.Todo;
import de.htwberlin.webservicekba.Repo.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KempaController {

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

        return new ResponseEntity<>(todos, HttpStatus.OK);

    }
}
