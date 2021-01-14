package de.htwberlin.webservicekba.rest;


import de.htwberlin.webservicekba.model.User;
import de.htwberlin.webservicekba.service.UserService;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@ResponseBody
//Man könnte natürlich hier auch @RestController nutzen, siehe in TodosController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Hier eine weitere Variante wie man das Mapping realisieren kann. @GetMapping sollte aber bevorzugt werden!
     */
    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public List<User> all() {
        return userService.findAllUser();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    public User createNewUser(@RequestBody User newUser) {
        return userService.createNewUser(newUser);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
    public User findOneUser(@PathVariable Long id) {

        return userService.findSingleUser(id);
    }

    /**
     * Beide Varianten mit funktionieren als Param, da Spring MVC automatisch es dann als Param versteht, auch wenn nicht explizit @RequestParam annotiert wurde.
     */
    @GetMapping("/userParam")
    public List<User> findUsersParam(String vorname) {

        return userService.findUsersEqualsVorname(vorname);
    }

//    @GetMapping("/userParam")
//    public List<Benutzer> findUsersParam( @RequestParam String vorname) {
//
//           return userService.findUsersEqualsVorname(vorname);
//    }

    @PutMapping("/user/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return userService.updateUser(id, newUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    //Demonstation von Restful
    @GetMapping("/restfuluser/{id}")
    public EntityModel<User> restfull(@PathVariable Long id) {

        User user = userService.findSingleUser(id);
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).restfull(id)).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("user"));
    }


}
