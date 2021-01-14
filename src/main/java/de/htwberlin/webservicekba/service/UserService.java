package de.htwberlin.webservicekba.service;

import de.htwberlin.webservicekba.model.User;
import de.htwberlin.webservicekba.repo.UserRepository;
import de.htwberlin.webservicekba.rest.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findSingleUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<User> findUsersEqualsVorname(String vorname) {
        return userRepository.findByVorname(vorname);
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(user1 -> {
                    user1.setVorname(user.getVorname());
                    user1.setNachname(user.getNachname());
                    user1.setAdresse(user.getAdresse());
                    return userRepository.save(user1);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return userRepository.save(user);
                });
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
