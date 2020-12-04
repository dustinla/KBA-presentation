package de.htwberlin.webservicekba.Repo;

import de.htwberlin.webservicekba.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {


    Optional<Todo> findByTitel(String titel);
}
