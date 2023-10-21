package br.com.aulaSpring.exerciciossb.controllers;

import br.com.aulaSpring.exerciciossb.models.entities.Produto;
import br.com.aulaSpring.exerciciossb.models.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    ){
        Produto produto = new Produto(nome, preco);
        produtoRepository.save(produto); // produtoRepository olhar explicação na classe ProdutoRepository
        return produto; // retorna o produto criado em formato de json
    }

    - a forma correta é no lugar de instanciar um objeto e informar todos os parâmetros, é utilizar puramente o objeto para salvar :
     */
    @PostMapping("/salvar")
//    public @ResponseBody Produto salvarProduto(@RequestBody @Valid Produto produto) { // retorna uma respsta padrão, ou seja 200
        public ResponseEntity<Produto>  salvarProduto(@RequestBody @Valid Produto produto) { //usando ResponseEntity é possível personalizar o return
    /*
      @RequestBody permite que os dados passados via request pela url se transformem diretamente em um Objeto, neste caso é objeto do tipo Produto
      exemplo:
            ao utilizar o Postman, envio uma request do tipo 'Post' com os dados de nome+valor, que são os dados para inicar o construtor de Produto
            ao utilizar o  @RequestBody é a mesma coisa que eu tivesse feito:

                        Produto produto = new Produto(nome, valor);

      @Valid obriga os dados que forem inseridos obedeçe as regras de validação lançadas na model ou classe do Produto
      ao utilizar o @Valid e ocorrer um erro, surgirá uma mensagem informando o erro específico que ocorreu, já se você não usar o @Valid o programa quebra

     */
        produtoRepository.save(produto); // save(só aceita um objeto/entidade)
//        return produto; ou:
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public Produto alterarProduto(@PathVariable long id, @RequestBody Produto produtoAtualizado){

        // Optional<> é usado para representar uma possível ausência de valor (ou um valor nulo) e é o retorno de '.findById()'

        Optional<Produto> produtoExistenteOptional = produtoRepository.findById(id);

        /*
            Diferença entre '.findById' e 'getReferenceById':
                - findById é usado quando você deseja obter uma instância completa da entidade com todos os atributos carregados.
                - getReference é usado quando você precisa apenas de uma referência à entidade sem carregar todos os atributos.

            O método findById retorna um Optional porque o objeto que você está procurando pode ou não existir no banco de dados.
            Se o objeto for encontrado, ele será armazenado no Optional, caso contrário, o Optional estará vazio.
        */

        if (produtoExistenteOptional.isPresent()) {

            /*
                 Para obter o valor dentro do Optional, você pode usar o método get(),
                 mas deve fazer isso apenas após verificar se o Optional não está vazio (usando isPresent()).
                 Isso evita exceções NoSuchElementException que ocorreriam se você tentasse acessar um valor em um Optional vazio.
            */

            Produto produtoExistente = produtoExistenteOptional.get();

            // Atualize os campos do produto existente com os valores do produto atualizado
            produtoExistente.setNome((produtoAtualizado.getNome()));
            produtoExistente.setPreco(produtoAtualizado.getPreco());

            // Salvando o produto atualizado no banco de dados
            Produto produtoAtualizadoNoBanco = produtoRepository.save(produtoExistente);

            return produtoAtualizadoNoBanco;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o ID: " + id);

        }
    }
    /*
        @RequestBody é usado antes da declaração Produto produto.
        Isso significa que o corpo da solicitação PUT deve conter dados que podem ser convertidos em um objeto do tipo Produto.
        Esses dados normalmente são enviados no formato JSON ou XML,
        e o Spring Boot usa um mecanismo de desserialização para transformar esses dados no objeto Produto
    */


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
    public Optional<Produto> obterProdutoPorId(@PathVariable long id){ // @PathVariable permite que seja utilizado a 'id' passada na url para dentro de 'long id'
        return produtoRepository.findById(id);
    }
        /*
            interessante, o professor sempre inicia a criação do método com public void
            depois, após utilizar o objeto 'produtoRepository.' após o ponto final, ele verifica a lista disponível de métodos e escolhe o que vai usar
            nesta lista é possível ver o que o método recebe e o que devolve
            neste exemplo o .findById() recebe um id e devolve um Optional<>
            após notar que o .findById() devolve uma interface Optional<>, foi alterado o início do método 'public void' para 'public Opctional<Produto>'
         */

//    @PutMapping // este método foi desconsiderado por poder ser reaproveitado no método salvarProduto() lá em cima
//    public Produto alterarProduto(@Valid Produto produto){
//        produtoRepository.save(produto);
//        return produto;
//    }

    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable long id){
        produtoRepository.deleteById(id);
    }




}
