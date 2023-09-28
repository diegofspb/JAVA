package teste.basico;

import Modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 1L);
        usuario.setNome("Novo nome 3");

        em.getTransaction().begin();
        /*

            leia o arquivo 'estado gerenciado.txt' para entender melhor tudo

            em.merge(usuario);
            o método 'merge' executa o comando sql 'UPDATE', porém como o objeto 'usuario' está em 'estado gerenciado', ou seja,
            o objeto 'usuario' está sob o controle de um 'EntityManager JPA', significa que:
            O EntityManager JPA está monitorando todas as alterações no objeto 'usuario' ,então quando se usar um método que modifique o objeto 'usuario'
            como o 'setNome("alterando o mome")', então o EntityManager JPA assim que uma transação for confirmada pelo comando 'em.getTransaction().commit()'
            atualizará automaticamente o banco de dados, mesmo sem a presença do comando 'em.merge(usuario)' que é quem efetivamente teria poder para isso

            para resolver a questão acima, o indicado é usar o método '.detach()' para retirar o objeto usuário do estado gerenciado e colocar ele no estado Detached = desanexado

            execute este arquivo e note que sim será alterado o nome e depois veja no exemplo 'AlterarUsuario3'
            que após o uso do '.detach()' o nome só será alterado com a presença do 'merge'
         */

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
