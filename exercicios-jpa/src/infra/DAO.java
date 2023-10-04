package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {  // uso do 'generics' lembrando que generics só pode ser utilizado para criar: Classes e Métodos

    /*
        'DAO<E>' é uma declaração de classe genérica que usa um parâmetro de tipo genérico chamado E.
        Isso significa que a classe DAO é genérica e pode ser parametrizada com um tipo específico no momento da criação de uma instância.
            Por exemplo:
                - você pode criar uma instância de:
                    DAO<Usuario> para trabalhar com a classe Usuario;
                    DAO<Produto> para trabalhar com a classe Produto.
    */
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private Class<E> classe; // Class foi para especificar que o generics <E>, após instancia o DAO<E> será uma classe Class<E> classe, se deixar só <E> classe seria um atributo qualquer
    // exemplo CERTO: Class<E> classe -> após instancia de Usuario usuario1 -> Class<Usuario> usuario1 -> aqui o atributo é a classe 'Usuario' representado pelo nome usuario1
    // exemplo ERRADO: se fosse <E> classe -> após instancia de Usuario usuario1 -> Usuario usuario1 -> aqui o atributo é usuario1 do tipo Usuario (ERRADO)

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
    // considerando o método construtor 1 acima, de inicio pensei que era apenas obrigação por causa do Hibernate de criar 1 método construtor 'sem argumentos'
    // porém o professor informou que é para tornar possível instanciar esta classe sem obrigação
    // de incluir uma classe na instancia, já que esta classe DAO<E> só pode ser instanciada com qualquer classe E do tipo generics

    public DAO(Class<E> classe){ // **** MÉTODO CONSTRUTOR 2 ****
        this.classe = classe;
        em = emf.createEntityManager();

        // quando este método construtor é chamado, por exemplo por uma classe 'Usuario.class', então tudo nesta classe que é <E> lê-se <Usuario>
        // exemplo no método abaixo que é 'public DAO<E> abrirT(){ }' vira 'public DAO<Usuario> abrirT(){ }'
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
        // O tipo de retorno do método é DAO<E>, o que significa que o método retorna uma instância da classe DAO parametrizada com o tipo genérico E.
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

        String jpql = "SELECT e FROM " + classe.getName() + " e";
        /*
            classe.getName(): Este trecho de código obtém o nome da classe Java representada pela variável classe.
            Por exemplo, se classe representar a classe Usuario, classe.getName() retornaria a string "Usuario".
            "SELECT e FROM " + classe.getName() + " e"
            é o mesmo que "SELECT * FROM usuarios" no contexto de consulta SQL que corresponde a "SELECT u FROM usuario u" em JPQL

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
            O <E> é a classe instancia no método construtor

                - 'em' é uma instância de EntityManager, que é uma parte fundamental do JPA e é usado para interagir com o banco de dados.

                - '.createQuery' é a consulta que aceita 2 parâmetros:
                     -> jpql = string com comando parecido com SQL para consulta no banco de dados;
                     -> classe = tipo de retorno, por isso se chama 'consulta tipada'.

            A consulta JPQL é uma linguagem de consulta orientada a objetos semelhante ao SQL, mas que opera em objetos Java em vez de tabelas de banco de dados.
        */
        query.setMaxResults(qtde); //limita o número de resultados retornados
        query.setFirstResult(deslocamento); //defini o ponto de partida (ou deslocamento) na lista de resultados.
        // Por exemplo, se qtde for 10 e deslocamento for 0, ele retornará os primeiros 10 registros da tabela.
        return query.getResultList();
    }
    // este método 'consultar' é relacionado ao consulta.xml para personalizar as consultas (query) transformando em 'NamedQuery'
    public List<E> consultar(String nomeConsulta, Object... params){ // 'Object... params' permite que vários parametros sejam passados e serão lidos como um 'array'
        // explicação do 'Object... params' em arquivo separado

       TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe); //nomeConsulta é o nome da consulta personalizada criada no consulta.xml e classe é o tipo do retorno

        /*
            O segundo parâmetro 'classe', que é opcional, é o tipo da classe que representa o tipo de resultado esperado da consulta.
            Este parâmetro é usado para tipar o resultado da consulta, especificando o tipo dos objetos que a consulta retornará.
            Quando esse parâmetro é fornecido, a consulta é considerada uma consulta tipada, e o tipo de retorno será esse tipo específico.
            Quando esse parâmetro é omitido, a consulta é considerada não tipada e o tipo de retorno será Object.
         */

       for (int i = 0; i < params.length; i += 2){
           query.setParameter(
                   params[i].toString(),
                   params[i+1]
           );
       }
       /*
            Este é um loop que percorre os parâmetros passados no 'Object... params'
            Esses parâmetros são pares de chave-valor, onde:

                o índice 'par' (i) é o nome do parâmetro da consulta JPQL
                o índice 'ímpar' (i+1) é o valor a ser associado a esse parâmetro.

            query.setParameter(params[i].toString(), params[i+1]):

                  - Isso define o valor do parâmetro da consulta JPQL usando o nome do parâmetro (convertido para String) e o valor associado.

            #### DIFERENÇA entre createNamedQuery e createQuery:

                    createNamedQuery = consulta tipada + nomeada e  pré-definida em um arquivo xml;
                    createQuery = consulta tipada + JPQL(string com código similar ao SQL ditigada livremente);

       */
       return query.getResultList();
    }
    public E consultarUm(String nomeConsulta, Object... params){
        List<E> lista = consultar(nomeConsulta, params);
        return lista.isEmpty() ? null: lista.get(0);
    }
    public void fechar(){
        em.close();
    }
}
