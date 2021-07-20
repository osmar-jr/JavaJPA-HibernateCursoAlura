package br.com.zup.bootcamp.teste;

import br.com.zup.bootcamp.modelo.Avaliacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaAvaliacao {

    public static void main(String[] args) {
        Avaliacao avaliacao1 = new Avaliacao();
        avaliacao1.setTitulo("Avaliacao 1");
        avaliacao1.setDescricao("Descricao 1");


        Avaliacao avaliacao2 = new Avaliacao();
        avaliacao2.setTitulo("Avaliacao 2");
        avaliacao2.setDescricao("Descricao 2");

        Avaliacao avaliacao3 = new Avaliacao();
        avaliacao3.setTitulo("Avaliacao 3");
        avaliacao3.setDescricao("Descricao 3");

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("alunos");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(avaliacao1);
        entityManager.persist(avaliacao2);
        entityManager.persist(avaliacao3);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
