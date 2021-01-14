package de.htwberlin.webservicekba;

import de.htwberlin.webservicekba.model.Adresse;
import de.htwberlin.webservicekba.model.User;
import de.htwberlin.webservicekba.model.Todo;
import de.htwberlin.webservicekba.repo.TodoRepository;
import de.htwberlin.webservicekba.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceKbaApplication implements CommandLineRunner {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebServiceKbaApplication.class, args);
	}

	@Override
	public void run(String... args) {

		if (todoRepository.findAll().size() < 1) {
			Todo todo = Todo.builder().titel("Einkaufen 3.12").beschreibung("Milch, Kaffe, Tee, Toast, Eier").build();
			todoRepository.save(todo);
		}
		if (userRepository.findAll().size() < 2) {
			Adresse adresse = Adresse.builder()
					.strassennummer("123A")
					.strassenname("Berliner Straße")
					.plz("12345")
					.build();
			User user = User.builder()
					.vorname("Neya")
					.nachname("Türknauf")
					.adresse(adresse)
					.build();
			Adresse adresse2 = Adresse.builder()
					.strassennummer("321B")
					.strassenname("Köpenicker Straße")
					.plz("54321")
					.build();
			User user2 = User.builder()
					.vorname("Justin")
					.nachname("Kurz")
					.adresse(adresse2)
			.build();
			userRepository.save(user);
			userRepository.save(user2);

		}

	}
}
