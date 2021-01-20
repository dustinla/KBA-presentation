package de.htwberlin.webservicekba.rest;

import de.htwberlin.webservicekba.model.Todo;
import de.htwberlin.webservicekba.service.TodosService;
import de.htwberlin.webservicekba.service.TodosServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Die Klasse ist mit @Restcontroller annotiert. Alle Methoden in der Klasse werden automatisch in Json deserialisiert und serialisiert.
 * Wie man gezielt Methoden (de)serialiserten siehe Präsentation.
 * In diesem Beispiel wird ResponseEntity verwendet.
 * In dieser Klasse muss man sich selbst um die HTTP Status Codes sowie was denn nun im Body geschickt werden soll kümmern.
 */
@RestController
@RequestMapping("todos")
public class TodosController {


    public final TodosService todosService;

    public TodosController(TodosServiceImpl todosService) {
        this.todosService = todosService;
    }


    @GetMapping("")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todosService.findAllTodos();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todosService.findSingleTodo(id);
        return todo.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("titel/{titel}")
    public ResponseEntity<Todo> getTodoByTitel(@PathVariable String titel) {
        Optional<Todo> todo = todosService.findTodoByTitel(titel);
        return todo.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        Todo todos = todosService.saveTodo(todo);
        return new ResponseEntity<>(todos, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todosService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        Optional<Todo> findTodo = todosService.findSingleTodo(id);
        Todo todo1 = null;
        if (findTodo.isPresent()) {
            todo1 = findTodo.get();
            if (todo.getBeschreibung() != null) {
                todo1.setBeschreibung(todo.getBeschreibung());
            }
            if (todo.getTitel() != null) {
                todo1.setTitel(todo.getTitel());
            }

            saveTodo(todo1);
        }

        return new ResponseEntity<>(todo1, HttpStatus.OK);
    }
}
