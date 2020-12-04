package de.htwberlin.webservicekba.Rest;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Konnte User nicht finden mit Id : " + id);
    }
}
