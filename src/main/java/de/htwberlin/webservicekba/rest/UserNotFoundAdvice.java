package de.htwberlin.webservicekba.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Wenn die Fehlermeldung UserNotFoundException geworfen wird, schaltet sich diese Klasse ein.
 * Er setzt dann den Status auf Not Found und gibt dann in diesem Fall ein String zurück.
 * Hier könnte natürlich auch ein Objekt als JSON zurückgeschickt werden. (Siehe Herr Kempas Beispiel mit APIError)
 */
@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }
}
