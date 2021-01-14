package de.htwberlin.webservicekba.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {


    @GetMapping("/")
    public String redirectWithUsingRedirectView() {
        return "swagger-ui.html";
    }
}
