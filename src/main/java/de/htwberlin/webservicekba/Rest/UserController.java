package de.htwberlin.webservicekba.Rest;


import de.htwberlin.webservicekba.Model.Benutzer;
import de.htwberlin.webservicekba.Repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
//Man könnte natürlich hier auch @RestController nutzen, siehe in TodosController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    List<Benutzer> all() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    Benutzer newUser(@RequestBody Benutzer newBenutzer) {
        return userRepository.save(newBenutzer);
    }

    @GetMapping("/user/{id}")
    Benutzer one(@PathVariable Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    Benutzer replaceUser(@RequestBody Benutzer newBenutzer, @PathVariable Long id) {

        return userRepository.findById(id)
                .map(benutzer -> {
                    benutzer.setVorname(newBenutzer.getVorname());
                    benutzer.setNachname(newBenutzer.getNachname());
                    benutzer.setAdresse(newBenutzer.getAdresse());
                    return userRepository.save(benutzer);
                })
                .orElseGet(() -> {
                    newBenutzer.setId(id);
                    return userRepository.save(newBenutzer);
                });
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    
}
