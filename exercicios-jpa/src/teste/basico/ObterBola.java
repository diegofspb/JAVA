package teste.basico;

import Modelo.basico.Bola;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterBola {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        Bola bola = em.find(Bola.class, 1L);
        System.out.println("Bola da marca: " + bola.getMarca() + " Cor: " + bola.getCor());
    }
}
