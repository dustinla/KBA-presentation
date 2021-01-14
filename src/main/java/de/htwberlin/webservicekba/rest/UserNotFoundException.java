package de.htwberlin.webservicekba.rest;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Konnte User nicht finden mit Id: " + id);
    }
}
