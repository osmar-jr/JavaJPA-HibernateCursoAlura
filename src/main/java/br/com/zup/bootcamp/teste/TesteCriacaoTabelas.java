package br.com.zup.bootcamp.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriacaoTabelas {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("alunos");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.close();
    }
}
