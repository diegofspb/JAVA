package teste.basico;

import Modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
// todo código abaixo não foi utilizado o método DAO
public class AlterarUsuario1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin(); //uma transação está sendo iniciada para realizar uma alteração no banco de dados.

        Usuario usuario = em.find(Usuario.class, 1L);  // em.find() gera um comando sql select, ou seja, uma busca no banco de dados
        /*
            o método find pertence ao EntityManager e serve para procurar um objeto do tipo Usuario com a chave primária (ID) igual a 1L no banco de dados.
            O resultado é armazenado na variável usuario.
            o mapeamento JPA é feito de tal forma que uma classe Java, como Usuario, corresponde a uma tabela no banco de dados com o mesmo nome, neste caso, "usuario".
            quando você realiza uma consulta usando em.find(Usuario.class, 1L);, o JPA traduz isso em uma consulta SQL que procura um registro na tabela "usuario" com
            a chave primária 1L e, em seguida, mapeia os resultados para um objeto Usuario em Java.
         */
        usuario.setNome("Maria Jose alterado1"); //setNome é o método setter da classe Usuario que altera o atributo nome
        usuario.setEmail("emailAlterado@gmail.com"); // setEmail também é um método setter para alteração do atributo que neste caso é o email
        em.merge(usuario);
        /*
            O método merge é usado para fazer com que as alterações feitas no objeto usuario sejam refletidas no banco de dados.
            Ele informa ao EntityManager para sincronizar o estado do objeto com o banco de dados.
            Nesse caso, o Hibernate irá gerar uma instrução SQL de atualização para atualizar os dados do usuário no banco de dados.
        */

        em.getTransaction().commit(); // é um método de confirmação
        /*
            Esta linha confirma a transação, ou seja, as alterações feitas no banco de dados durante a transação são efetivadas.
            Se ocorrer algum erro durante a transação, você pode chamar rollback() em vez de commit() para desfazer as alterações.
        */
        em.close();
        emf.close();
    }
}
