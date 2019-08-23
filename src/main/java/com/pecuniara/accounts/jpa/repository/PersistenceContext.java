package com.pecuniara.accounts.jpa.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class PersistenceContext {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("receipts");;
    private EntityManager em;
    public static void createEMF(){
        emf = Persistence.createEntityManagerFactory("receipts");
    }
    @Bean
    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
}
