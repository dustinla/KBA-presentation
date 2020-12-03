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





    @GetMapping("kempa")
    public ResponseEntity<String> kempa(){

        return new  ResponseEntity<>("Hallo Prof. Dr. Kempa, da waren Sie aber neugierig. :)", HttpStatus.OK);
    }



}
