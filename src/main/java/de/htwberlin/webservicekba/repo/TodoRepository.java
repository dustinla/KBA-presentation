package de.htwberlin.webservicekba.repo;

import de.htwberlin.webservicekba.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data Magic
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {


    Optional<Todo> findByTitel(String titel);
}
