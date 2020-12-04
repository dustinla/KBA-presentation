package de.htwberlin.webservicekba.Repo;

import de.htwberlin.webservicekba.Model.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Benutzer, Long> {
}
