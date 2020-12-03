package de.htwberlin.webservicekba.Rest;
import de.htwberlin.webservicekba.Model.Todos;
import de.htwberlin.webservicekba.Repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KempaController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("kempa")
    public ResponseEntity<String> kempa(){

        return new  ResponseEntity<>("HALLO KEMPA", HttpStatus.OK);
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Todos>> getAllTodos() {
        List<Todos> todos = todoRepository.findAll();

        return new ResponseEntity<>(todos, HttpStatus.OK);

    }
}
