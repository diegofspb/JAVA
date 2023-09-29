package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        }catch (Exception e){
            // aqui jogaria o erro em um arquivo de log
        }
    }
    public DAO(){ // **** MÉTODO CONSTRUTOR 1 ****
        //lembrando que o Hibernate exige criação de uma Classse construtora vazia
        this(null);
    }
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
    // o nome 'Atomico' em programação significa juntar tarefas por exemplo, e executar de uma vez = atomico
    public DAO<E> incluirAtomico(E entidade){  //esta função soma as funções acima, ou seja, a abre transação, inlui dados e depois fecha
        return this.abrirT().incluir(entidade).fecharT();
    }
    public List<E> obterTodos(){ //Este método chama o método que está abaixo: 'obterTodos(int qtde, int deslocamento)', porém com valores já setados qtd=10 e deslocamento=0
        return this.obterTodos(10,0);
    }
    public List<E> obterTodos(int qtde, int deslocamento){ //Este método é responsável por realizar a consulta ao banco de dados para obter uma lista de entidades (E).
        if(classe == null){
            throw new UnsupportedOperationException("Classe nula.");
        }
        // Java Persistence Query Language (jpql) é uma consulta sql que seleciona todos os registros da tabela associada à classe E
        String jpql = "SELECT e FROM " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        /*
            TypedQuery<E>: Este é o tipo da consulta.
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
