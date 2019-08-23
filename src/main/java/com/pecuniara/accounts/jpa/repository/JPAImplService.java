package com.pecuniara.accounts.jpa.repository;

import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAImplService {
    private static EntityManagerFactory emf;
    private EntityManager em;
    public static void createEMF(){
        emf = Persistence.createEntityManagerFactory("receipts");
    }
    @Bean
    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
}
