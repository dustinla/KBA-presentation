package de.htwberlin.webservicekba.rest;


import de.htwberlin.webservicekba.model.User;
import de.htwberlin.webservicekba.service.UserService;
import de.htwberlin.webservicekba.service.UserServiceImpl;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Statt @Restcontroller zu schreiben, kann auch mit zwei Annotationen dasselbe Ziel erreicht werden.
 * Fehlerbehandlung finden im UserNotFoundAdvice statt.
 */
@Controller
@ResponseBody
public class UserController {


    private final UserService userService;

    public UserController(UserServiceImpl userService) {
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
     * Diese und die hier drunter auskommentierte Methode versteht Spring MVC automatisch als Parameter, auch wenn nicht explizit @RequestParam annotiert wurde.
     * Da gibt es in der Spring Community keine Bevorzugung. Jedes Team kann selbst entscheiden wie sie es handhaben wollen.
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


    /**
     * Diese Methode zeigt beispielhaft wie HATEOAS (Hypermedia As The Engine Of Application State) implementiert wird.
     */
    @GetMapping("/restfuluser/{id}")
    public EntityModel<User> restfull(@PathVariable Long id) {

        User user = userService.findSingleUser(id);
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).restfull(id)).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("user"),
                linkTo(methodOn(TodosController.class).getAllTodos()).withRel("todos"));
    }


}
