package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private Class<E> classe; //atributo com o nome 'classe' que é do tipo Generics e é também do tipo Classe

    static { // tudo que estiver neste bloco será executado 1 única vez quando a Classe for chamada/instanciada
        try {
            emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        }catch (Exception e){
            // aqui jogaria o erro em um arquivo de log
        }
    }
    public DAO(){ // **** MÉTODO CONSTRUTOR 1 ****
        this(null);
    }
    // considerando o método construtor 1 acima, de inicio pensei que era obrigação por causa do Hibernate,
    // porém o professor informou que é para tornar possível instanciar esta classe sem obrigação
    // de incluir uma classe na instancia, conforme o método construtor 2 que está abaixo

    public DAO(Class<E> classe){ // **** MÉTODO CONSTRUTOR 2 ****
        this.classe = classe;
        em = emf.createEntityManager();
    }
    public DAO<E> abrirT(){ // método que abre a transação
        em.getTransaction().begin();
        return this; // lembre, quando faz isso 'return this'(Método Builder) você retorna a própria função e isso permite encadeamento
    }
    public DAO<E> fecharT(){ //método que fecha a transação
        em.getTransaction().commit();
        return this; // transforma em método BUILDER e permite encadeamento de funções
    }
    public DAO<E> incluir(E entidade){ // incluir/adicionar um registro no banco de dados
        em.persist(entidade);
        return this; // transforma em método BUILDER e permite encadeamento de funções
    }
    // o nome 'Atomico' em programação significa juntar tarefas e executar tudo de uma vez = atomico
    public DAO<E> incluirAtomico(E entidade){  //esta função soma as funções acima, ou seja, a abre transação, inlui dados e depois fecha
        // 'E' é a classe usada quando se instancia inicialmente o DAO, pois o DAO só é instanciado com uma classe, conforme método construtor lá em cima
        // 'entidade' é exatamente o nome dado a instancia, exemplo Cliente cliente1, então 'entidade = cliente1' enquanto 'E = Classe'
        return this.abrirT().incluir(entidade).fecharT();
    }
    public E obterPorId(Object id){ // método para obter um registro específico na tabela apenas usando ID
        // nos exemplos do professor geralmente o id é do tipo Long, então é possível colocar no lugar de Object id colocar Long id
        // Object foi usando para generalizar, pois é possível que o ID em uma tabela seja do tipo Long, em outra tabela seja int, em outra seja String ,......
        return em.find(classe,id);
        // lembrando que o em.fin() retorna um objeto, sexemplo se tiver pesquisando cliente, basta colocar o resultado do em.find() dentro de
        // uma variavel que tem que ser do tipo cliente e usar os métodos get ou seter, exemplo: Cliente cliente = em.find(Cliente.class, id)
    }
    public List<E> obterTodos(){ //Este método chama o método que está abaixo: 'obterTodos(int qtde, int deslocamento)', porém com valores já setados qtd=10 e deslocamento=0
        return this.obterTodos(10,0);
    }  //abaixo uma sobrecarga de método
    public List<E> obterTodos(int qtde, int deslocamento){ //Este método é responsável por realizar a consulta ao banco de dados para obter uma lista de entidades (E).
        if(classe == null){
            throw new UnsupportedOperationException("Classe nula.");
        }
        // Java Persistence Query Language (jpql) é uma consulta apenas parecida com o sql que seleciona todos os registros da tabela associada à classe E
        // tem que se estudada separado, pois o código abaixo indica a mesma coisa que SELECT * FROM 'nome_tabela'
        String jpql = "SELECT e FROM " + classe.getName() + " e";
        /*
            classe.getName(): Este trecho de código obtém o nome da classe Java representada pela variável classe.
            Por exemplo, se classe representar a classe Usuario, classe.getName() retornaria a string "Usuario".
            "SELECT e FROM " + classe.getName() + " e"
            é o mesmo que "SELECT * FROM usuarios" no contexto de consulta SQL
            seria o mesmo que: "SELECT usuario FROM usuario" neste contexto de ORM JPA JAVA
            seria o mesmo que: "SELECT u FROM usuario u" neste contexto de ORM JPA JAVA


            "SELECT e FROM " + classe.getName() + " e": Aqui, estamos construindo uma consulta JPQL (Java Persistence Query Language).
            A letra 'e' é usada como um alias(apelido) para a entidade que está sendo selecionada na consulta.

            O uso de um alias é opcional, mas é uma prática comum na linguagem JPQL para simplificar e tornar as consultas mais legíveis.

            "SELECT e": Esta parte da consulta indica que estamos selecionando a entidade representada pela classe.

            "FROM " + classe.getName() + " e": Aqui, estamos especificando a tabela (ou entidade) da qual estamos selecionando os dados.
            O classe.getName() fornece o nome da classe mapeada (ou seja, o nome da tabela) e 'e' é o alias que usaremos para se referir a essa entidade na consulta.
        */
        TypedQuery<E> query = em.createQuery(jpql, classe);
        /*
            TypedQuery<E>: é uma consulta tipada, ou seja, ela realizar uma query(consulta) utilizando um <objeto> como parâmetro
            TypedQuery é uma interface que permite consulta parametrizada(com parâmetros) no banco de dados com JPA,
            TypedQuery já que é uma consulta parametrizada, então só pode ser usada com em.createQuery(parametro1, parametro2) que cria uma consulta(query) com 2 parâmetros
            O <E> deve ser um tipo que corresponda à entidade mapeada no banco de dados.

            em.createQuery(jpql, classe): Isso cria a consulta JPA com uso de parâmetros.

            'em' é uma instância de EntityManager, que é uma parte fundamental do JPA e é usado para interagir com o banco de dados.
            '.createQuery' é a consulta que aceita 2 parâmetros
             - jpql(PARÂMETRO 1) contém a string com o comento sql para consulta no banco de dados;
             - classe (PARAMETRO 2) corresponde a entidade (tabela) no banco de dados;

            createQuery(jpql, classe) cria uma consulta JPA com base na consulta 'jpql' (Java Persistence Query Language) representada pela string jpql
            e no tipo da entidade representado por classe.
            A consulta JPQL é uma linguagem de consulta orientada a objetos semelhante ao SQL, mas que opera em objetos Java em vez de tabelas de banco de dados.
        */
        query.setMaxResults(qtde); //limita o número de resultados retornados
        query.setFirstResult(deslocamento); //defini o ponto de partida (ou deslocamento) na lista de resultados.
        // Por exemplo, se qtde for 10 e deslocamento for 0, ele retornará os primeiros 10 registros da tabela.
        return query.getResultList();
    }
    public void fechar(){
        em.close();
    }
}
