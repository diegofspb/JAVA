package teste.basico;

import Modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
    public static void main(String[] args) {

        /*
            A sequência envolve criar uma única instância de EntityManagerFactory durante a inicialização do aplicativo,
            geralmente no momento da inicialização do contexto de aplicação.

            Depois, você cria instâncias de EntityManager a partir da fábrica EntityManagerFactory sempre que precisar executar operações de persistência.
            Quando não estiver mais em uso, você fecha o EntityManager e, em seguida, fecha a EntityManagerFactory quando o aplicativo for desligado.

            EntityManagerFactory é uma fábrica de gerenciadores de entidade, ou seja, cria um objeto EntityManager
            No Hibernate, você cria uma única instância de EntityManagerFactory para toda a aplicação.
         */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");

        /*
             exercicios-jpa é o nome da persistência que está em xml, lá está assim: <persistence-unit name="exercicios-jpa">
             a persistencia contém usário, senha e o endereço(url) do banco de dados para fazer a conexão
             EntityManager é uma ‘interface’ responsável pelo CRUD com o B.D.
        */

        EntityManager em = emf.createEntityManager();

        /*
             obs.: pelo que entendi, o EntityManagerFactory é algo geral e o EntityManager é específico, cada tipo de acesso ao BD gera novo EntityManager
             mas não precisa gerar novamente o EntityManagerFactory que é gerado apenas 1 vez. CONFIRMAR ISSO!
        */

        Usuario novoUsuario = new Usuario("Gui", "gui@gmail.com.br");

        em.getTransaction().begin(); // uma transação está sendo iniciada para realizar uma alteração no banco de dados.
        em.persist(novoUsuario); //Aqui, você está pedindo ao EntityManager (em) para persistir (ou seja, salvar) o objeto 'novoUsuario' no banco de dados.
        em.getTransaction().commit(); // Finalmente, esta linha realiza o commit da transação.
        /*
             Isso confirma todas as operações de persistência realizadas dentro da transação.
             Se houver algum erro durante a transação, você pode fazer um rollback para desfazer todas as operações.
        */

        em.close();
        emf.close();

    }
}
