package teste.basico;

import Modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT u from Usuario u";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setMaxResults(5); // máximo de 5 resultados, isso evita quebrar o sistema quando a tabela é gigante

        List<Usuario> usuarios = query.getResultList();

        for(Usuario usuario: usuarios){
            System.out.println("ID: " + usuario.getId() + " Email: " + usuario.getEmail());
        }

        em.close();
        emf.close();
    }
}
