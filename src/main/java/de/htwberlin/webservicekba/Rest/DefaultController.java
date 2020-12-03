package de.htwberlin.webservicekba.Rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DefaultController {


    @GetMapping("/")
    public String redirectWithUsingRedirectView() {
        return "swagger-ui.html";
    }
}
