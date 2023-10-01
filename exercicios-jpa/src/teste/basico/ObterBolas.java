package teste.basico;

import Modelo.basico.Bola;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterBolas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT b FROM Bola b";

        TypedQuery<Bola> query = em.createQuery(jpql, Bola.class);

        List<Bola> bolas = query.getResultList();

        for (Bola bola: bolas) {
            System.out.println("Marca " + bola.getMarca() + " Cor: " + bola.getCor());
        }
    }
}
