package br.com.zup.bootcamp.teste;

import br.com.zup.bootcamp.modelo.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaAluno {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setNome("João Paulo");
        aluno.setEmail("joao@alunos.com.br");
        aluno.setIdade(22);

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Maria Clara");
        aluno1.setEmail("maria@alunos.com.br");
        aluno1.setIdade(21);

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("alunos");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(aluno);
        entityManager.persist(aluno1);
        entityManager.getTransaction().commit();

        entityManager.close();


    }
}
