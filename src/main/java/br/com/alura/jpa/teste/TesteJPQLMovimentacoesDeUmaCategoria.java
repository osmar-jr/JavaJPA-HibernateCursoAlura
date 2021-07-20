package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJPQLMovimentacoesDeUmaCategoria {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("contas");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(2L);
        String jpqlQuery = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

        TypedQuery<Movimentacao> query = entityManager.createQuery(jpqlQuery, Movimentacao.class);
        query.setParameter("pCategoria", categoria);
        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao : resultList) {

            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Categorias: " + movimentacao.getCategorias());
            System.out.println("Tipo de Movimentação: " + movimentacao.getTipoMovimentacao());
            System.out.println("Valor: " + movimentacao.getValor());
            System.out.println("Titular: " + movimentacao.getConta().getTitular());
            System.out.println("--------------------------------------------------------------");
        }
    }
}
