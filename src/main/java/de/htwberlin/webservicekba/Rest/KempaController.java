package de.htwberlin.webservicekba.Rest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KempaController {


    @GetMapping("kempa")
    public ResponseEntity<String> kempa(){

        return new  ResponseEntity<>("HALLO KEMPA", HttpStatus.OK);
    }
}
