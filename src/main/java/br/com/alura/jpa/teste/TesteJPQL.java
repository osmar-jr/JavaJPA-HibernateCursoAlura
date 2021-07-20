package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TesteJPQL {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);
        String jpqlQuery = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

        TypedQuery<Movimentacao> query = entityManager.createQuery(jpqlQuery, Movimentacao.class);
        query.setParameter("pConta", conta);
        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao : resultList) {
            System.out.println(movimentacao.getDescricao());
            System.out.println(movimentacao.getTipoMovimentacao());
            System.out.println(movimentacao.getValor());
            System.out.println(movimentacao.getConta().getTitular());
        }
    }
}
