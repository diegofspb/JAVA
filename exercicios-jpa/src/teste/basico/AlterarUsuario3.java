package teste.basico;

import Modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario3 {

    // para entender tudo aqui olhe o AlterarUsuario2
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 1L);
        em.detach(usuario);
        usuario.setNome("Alterar nome 5");

        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
