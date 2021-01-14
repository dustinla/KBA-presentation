package de.htwberlin.webservicekba.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KempaController {


    @GetMapping("kempa")
    @ResponseBody
    public ResponseEntity<String> kempa() {

        return new ResponseEntity<>("Hallo Prof. Dr. Kempa, da waren Sie aber neugierig. :)", HttpStatus.OK);
    }

    @GetMapping("kempa/webseite")
    public ModelAndView redirectWithUsingRedirectView() {
        return new ModelAndView("redirect:" + "https://www.htw-berlin.de/hochschule/personen/person/?eid=3888");

    }


}
