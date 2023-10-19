package br.com.aulaSpring.exerciciossb.models.repositories;

import br.com.aulaSpring.exerciciossb.models.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // no Spring basta vc criar um método com nome pré-definino pela convensão que o spring entende que ele realizará determinada função
    // no exemplo abaixo, ao iniciar o nome do método com 'findBy' o Spring entende que é para fazer uma pesquisa no bando de dados
    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);


    /*
        recomenda-se olhar na documentação outros nomes, exemplo:

            findByNomeContaining
            findByNomeIsContaining
            findByNomeContains

            findByNomeStartWith
            findByNomeEndsWith
            findByNomeNotContaining
     */
}

/*

--> Importante notar que o CrudRepository foi trocado pelo PagingAndSortingRepository porque este além das funções de CRUD do CrudRepsitory
    também tem a possibilidade de realizar pesquisas paginadas e outras funcionalidades que o CrudRepsitory não tem, mas as explicações abaixo
    são totalmente válidas pois também são aplicadas no CrudRepsitory.

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}

O CrudRepository é uma interface fornecida pelo Spring Data que fornece operações CRUD (Create, Read, Update, Delete) prontas para uso em um repositório.
Ele simplifica muito o acesso a dados em um banco de dados, eliminando a necessidade de escrever consultas SQL manualmente.

A interface ProdutoRepository estende CrudRepository e é parametrizada com dois tipos:

    Produto: Este é o tipo de entidade(tabela) com a qual o repositório trabalhará.
             No contexto do Spring Data JPA, uma entidade geralmente corresponde a uma tabela em um banco de dados relacional.

    Integer: Este é o tipo de dado do identificador (ID) da entidade.
             No caso, está definido como Integer, o que indica que o ID da entidade Produto é um número inteiro.
             Dentro da interface ProdutoRepository, você terá métodos herdados da interface CrudRepository para executar operações comuns em um banco de dados,
             como salvar, recuperar, atualizar e excluir registros da entidade Produto.
             Esses métodos serão fornecidos pelo Spring Data JPA com base na estrutura da classe Produto e nas convenções de nomenclatura.

Com a definição dessa interface, você pode injetar ProdutoRepository em outras partes de seu aplicativo Spring Boot para interagir com o banco de dados e
executar operações CRUD na entidade Produto de maneira simples e eficiente, sem a necessidade de escrever consultas SQL manualmente.

 */
