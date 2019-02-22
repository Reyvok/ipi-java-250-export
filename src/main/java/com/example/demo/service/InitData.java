package com.example.demo.service;

import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Classe permettant d'insérer des données dans l'application.
 */
@Service
@Transactional
public class InitData implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private EntityManager em;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        insertTestData();
    }

    private void insertTestData() {
        Client client1 = newClient("PETRILLO", "Ale;xandre", 30, "Lyon");
        em.persist(client1);

        Client client2 = newClient("HYVERNAT", "Luc", 20, "Lyon");
        em.persist(client2);

        Client client3 = newClient("MAZOYER", "Laurent", 25, "Lyon");
        em.persist(client3);

        Client client4 = newClient("HETSCH", "Yohan", 20, "Lyon");
        em.persist(client4);
    }

    private Client newClient(String nom, String prenom, Integer age, String adresse) {
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAge(age);
        client.setAdresse(adresse);
        return client;
    }
}
