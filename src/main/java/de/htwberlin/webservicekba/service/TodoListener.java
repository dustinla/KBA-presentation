package de.htwberlin.webservicekba.service;

import de.htwberlin.webservicekba.model.Todo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PostLoad;

@Component
public class TodoListener {

    @Autowired
    EntityManager entityManager;

    @PostLoad
    void postLoad(Todo todo) {
        entityManager.getEntityManagerFactory().getCache();
        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);

        long cacheHitCount = sessionFactory.getStatistics().getEntityStatistics("de.htwberlin.webservicekba.model.Todo").getCacheHitCount();
        System.out.println(todo);
        System.out.println("HitCount TODO");
        System.out.println(cacheHitCount);

    }
}
