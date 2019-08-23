package com.pecuniara.accounts.jpa;

import com.pecuniara.accounts.jpa.repository.PersistenceContext;

import javax.persistence.EntityManager;

public class Helper {
    public static EntityManager entityManager = PersistenceContext.getEm();
}
