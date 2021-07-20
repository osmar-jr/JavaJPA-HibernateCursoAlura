package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoTeste {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setTitular("JOSE ALMEIDA");
        conta.setNumero(37487489);
        conta.setAgencia(1237891);
        conta.setSaldo(324.29);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setValor(new BigDecimal(1200.90));
        movimentacao.setConta(conta);

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(conta);
        entityManager.persist(movimentacao);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
