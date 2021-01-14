package de.htwberlin.webservicekba.repo;

import de.htwberlin.webservicekba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data Magic
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findByVorname(String vorname);
}
