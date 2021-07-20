package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaTeste {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Conta conta = new Conta();
        conta.setNumero(12348235);
        conta.setAgencia(53284321);
        conta.setTitular("Maria");

        entityManager.getTransaction().begin();
        entityManager.persist(conta);


        conta.setSaldo(1000.0);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
