package de.htwberlin.webservicekba;

import de.htwberlin.webservicekba.model.Adresse;
import de.htwberlin.webservicekba.model.Todo;
import de.htwberlin.webservicekba.model.User;
import de.htwberlin.webservicekba.repo.TodoRepository;
import de.htwberlin.webservicekba.repo.UserRepository;
import org.ehcache.config.builders.CacheManagerConfiguration;
import org.ehcache.core.Ehcache;
import org.ehcache.core.EhcacheManager;
import org.ehcache.jsr107.config.Jsr107CacheConfiguration;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


import javax.cache.CacheManager;
import javax.cache.management.CacheMXBean;
import javax.cache.management.CacheStatisticsMXBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@SpringBootApplication
@EnableCaching
public class WebServiceKbaApplication implements CommandLineRunner {

//    @Autowired
//    private LocalSessionFactoryBean sessionFactory;

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebServiceKbaApplication.class, args);
    }

    /**
     * Wird bei jedem Start des Services automatisch ausgeführt.
     * Paar Daten befüllen, sofern keine/zu wenige vorhanden sind.
     *
     * @param args
     */
    @Override
    public void run(String... args) {


        if (todoRepository.findAll().isEmpty()) {
            Todo todo = Todo.builder().titel("Einkaufen 3.12").beschreibung("Milch, Kaffee, Tee, Toast, Eier").build();
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
            entityManager.getEntityManagerFactory().getCache();
            SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
            Cache cache = sessionFactory.getCache();
        }

    }
}
