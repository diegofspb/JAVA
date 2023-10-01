package teste.basico;

import Modelo.basico.Bola;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovaBola {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        Bola bola = new Bola("fuleragi", "rosa");

        em.getTransaction().begin();
        em.persist(bola);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
