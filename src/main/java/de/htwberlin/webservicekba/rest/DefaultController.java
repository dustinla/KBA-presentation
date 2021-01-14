package de.htwberlin.webservicekba.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Der Controller leitet automatisch auf das generierte Swagger Ui um, wenn man <Host>:<Port>/ aufruft.
 */
@Controller
public class DefaultController {


    @GetMapping("/")
    public String redirectWithUsingRedirectView() {
        return "swagger-ui.html";
    }
}
