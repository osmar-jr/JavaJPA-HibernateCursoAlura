package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class RelacionamentoMovimentacaoCategoriaTeste {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("Ferias");
        Categoria categoria1 = new Categoria("Negocios");

        Conta conta = new Conta();
        conta.setId(2L);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal(200.00));
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Ferias em SP");
        movimentacao.setCategorias(Arrays.asList(categoria, categoria1));
        movimentacao.setConta(conta);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal(250.00));
        movimentacao1.setData(LocalDateTime.now());
        movimentacao1.setDescricao("Volta para SP");
        movimentacao1.setCategorias(Arrays.asList(categoria, categoria1));
        movimentacao1.setConta(conta);

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(categoria);
        entityManager.persist(categoria1);
        entityManager.persist(movimentacao);
        entityManager.persist(movimentacao1);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
