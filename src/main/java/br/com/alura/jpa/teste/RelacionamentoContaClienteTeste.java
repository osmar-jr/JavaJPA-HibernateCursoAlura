package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RelacionamentoContaClienteTeste {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(1L);

        Cliente cliente = new Cliente();
        cliente.setConta(conta);
        cliente.setNome("Andressa");
        cliente.setProfissao("Developer");
        cliente.setEndereco("Rua dos Largados, 10");

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
