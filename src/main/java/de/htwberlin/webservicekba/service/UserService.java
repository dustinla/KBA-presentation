package de.htwberlin.webservicekba.service;

import de.htwberlin.webservicekba.model.User;

import java.util.List;

/**
 * Simple CRUD Operation ohne logik
 */
public interface UserService {
    List<User> findAllUser();

    User createNewUser(User user);

    User findSingleUser(Long id);

    List<User> findUsersEqualsVorname(String vorname);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
