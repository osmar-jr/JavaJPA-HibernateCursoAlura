package br.com.zup.bootcamp.teste;

import br.com.zup.bootcamp.modelo.Aluno;
import br.com.zup.bootcamp.modelo.Avaliacao;
import br.com.zup.bootcamp.modelo.Resposta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesterRelacionamentoAlunoAtividadeResposta {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        aluno1.setId(1L);

        Aluno aluno2 = new Aluno();
        aluno2.setId(2L);

        Avaliacao avaliacao1 = new Avaliacao();
        avaliacao1.setId(1L);

        Avaliacao avaliacao2 = new Avaliacao();
        avaliacao2.setId(2L);

        Resposta resposta1 = new Resposta();
        resposta1.setDescricao("Resposta 1 - Avaliacao 1 Aluno 1");
        resposta1.setAluno(aluno1);
        resposta1.setAvaliacao(avaliacao1);

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("alunos");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        entityManager.persist(resposta1);
        entityManager.getTransaction().commit();

        entityManager.close();


    }
}
