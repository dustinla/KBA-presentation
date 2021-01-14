package de.htwberlin.webservicekba.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KempaController {


    @GetMapping("kempa")
    public ResponseEntity<String> kempa() {

        return new ResponseEntity<>("Hallo Prof. Dr. Kempa, da waren Sie aber neugierig. :)", HttpStatus.OK);
    }


}
