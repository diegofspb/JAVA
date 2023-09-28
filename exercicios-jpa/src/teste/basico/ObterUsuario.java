package teste.basico;

import Modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();
        // quando se usa Unsuario.class você está recebendo a referência da classe, ou seja, todos os dados da classe Usuario
        Usuario usuario = em.find(Usuario.class, 2L);
        System.out.println(usuario.getNome());

        em.close();
        emf.close();

    }
}
