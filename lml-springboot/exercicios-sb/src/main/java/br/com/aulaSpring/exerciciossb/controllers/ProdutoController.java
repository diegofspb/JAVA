package br.com.aulaSpring.exerciciossb.controllers;

import br.com.aulaSpring.exerciciossb.models.entities.Produto;
import br.com.aulaSpring.exerciciossb.models.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired // é uma anotation que significa injeção de pedendência, quando ele aparece significa que a classe abaixo dele foi automaticamente instanciada
    private ProdutoRepository produtoRepository;
    /*
        Note que foi criado um package contendo a clase ProdutoRepository e lá não foi criado nenhum método ou atributo
        na classe ProdutoRepository ocorreu apenas um 'extends' de  CrudRepository<Produto, Integer>


   - a forma abaixo de salvar um produto é errada, pois você é obrigado a informar todos os parâmetros:

    @PostMapping
    public @ResponseBody Produto salvarProduto(
            @RequestParam String nome,
            @RequestParam double preco,
            @RequestParam double desconto
    ){
        Produto produto = new Produto(nome, preco, desconto);
        produtoRepository.save(produto); // produtoRepository olhar explicação na classe ProdutoRepository
        return produto; // retorna o produto criado em formato de json
    }

    - a forma correta é no lugar de instanciar um objeto e informar todos os parâmetros, é utilizar puramente o objeto para salvar :
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto salvarProduto(@Valid Produto produto){  //@Valid obriga os dados que forem inseridos obedeçam as regras de validação
        // ao utilizar o @Valid e ocorrer um erro, surgirá uma mensagem informando o erro específico que ocorreu, já se você não usar o @Valid o programa quebra
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos(){
        return produtoRepository.findAll(); //. findAll() retorna tudo do B.D não é viável
        // lembrando que o produtoRepository é um objeto da classe ProdutoRepository e este extendeu de CrudRepository permitindo executar 'CRUD' livremente
        // o .findAll() é um método do CrudRepository e retorna um Iterable<>, por isso este método retorna Iterable<>
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    /*

    Obs.: o código abaixo não funcionou, pois ao trocar o CrudRepository pelo PagingAndSortingRepository os comandos de save e find desativaram

    @GetMapping(path = "/pagina/{numeroPagina}")  //realizando uma consulta paginada
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina){
        Pageable page = PageRequest.of(0,3);  // escolhe a primeira pagina que é a 0 e no máximo 3 elementos
        return produtoRepository.findAll(page);
    }
    */


    @GetMapping(path = "/{id}") // significa que quando for passado uma 'id' na url, então este método será chamado
    public Optional<Produto> obterProdutoPorId(@PathVariable int id){ // @PathVariable permite que seja utilizado a 'id' passada na url para dentro de 'int id'
        return produtoRepository.findById(id);
    }
        /*
            interessante, o professor sempre inicia a criação do método com public void
            depois, após utilizar o objeto 'produtoRepository.' após o ponto final, ele verifica a lista disponível de métodos e escolhe o que vai usar
            nesta lista é possível ver o que o método recebe e o que ele devolve como resposta
            neste exemplo o .findById() recebe um id e devolve um Optional<>
            após notar que o .findById() devolve uma interface Optional<>, foi alterado o início do método 'public void' para 'public Opctional<Produto>'
         */

//    @PutMapping // este método foi desconsiderado por poder ser reaproveitado no método salvarProduto() lá em cima
//    public Produto alterarProduto(@Valid Produto produto){
//        produtoRepository.save(produto);
//        return produto;
//    }

    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }


}
