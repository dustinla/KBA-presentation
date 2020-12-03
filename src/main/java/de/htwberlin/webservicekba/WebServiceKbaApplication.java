package de.htwberlin.webservicekba;

import de.htwberlin.webservicekba.Model.Todos;
import de.htwberlin.webservicekba.Repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceKbaApplication implements CommandLineRunner {

	@Autowired
	TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebServiceKbaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Todos todos = Todos.builder().titel("Einkaufen 3.12").beschreibung("Milch, Kaffe, Tee, Toast, Eier").build();


		todoRepository.save(todos);
	}
}
