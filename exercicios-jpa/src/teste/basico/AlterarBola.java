package teste.basico;

import Modelo.basico.Bola;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarBola {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        Bola bola = em.find(Bola.class, 2L);

        bola.setCor("pretu");

        em.getTransaction().begin();
        em.persist(bola);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
