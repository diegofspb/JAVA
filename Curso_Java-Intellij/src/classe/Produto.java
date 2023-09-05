package classe;

public class Produto {

    /*
     * esta classe produto não possui o método main, pois a ideia
     * é criar esta classe apenas com os atributos e outra classe foi criada
     * com nome ProdutoTeste.java para conter os métodos separados e lá é
     * que estes atributos abaixo serão utilizados
     * */
    String nome;
    double preco;
    static double desconto = 0.25;

    // ao criar apenas este método construtor, dá erro no código de ProtudoTeste.java
    // pois agora a classe Produto exige que seja incluído um parâmetro nomeInicial quando instanciar o objeto Produto;
    Produto(String nomeInicial){ // este é um método construtor explicado no final deste arquivo
        nome = nomeInicial;
    }
    // ao criar o método construtor abaixo sem parâmetros o código do ProtudoTeste.java parou de dar erro, pois
    // agora ele passou a aceitar que um produto seja criado sem precisar de qualquer parâmetro;
    Produto(){

    }
    // agora o mais interessante é que foi criado outro método construtor permitindo que seja criado um produto
    // utilizando nome + precoINical, ou seja, cada método construtor determinará como o produto poderá ser criado
    // e a ausencia do método construtor significa que é possível criar um produto sem qualquer parâmetro por padrão;
    Produto(String nomeInicial, double precoInicial, double descontoInicial){
        nome = nomeInicial;
        preco = precoInicial;
        //desconto = descontoInicial;
    }


    // TIPO nome() {estrutura com return};
    double precoComDesconto() {    //nome está em Pascal Case
        return preco * (1-desconto);
    }

    double precoComDesconto(double descontoDoGerente) {
        return preco * (1-(desconto + descontoDoGerente));
    }

	/*
	 * é possível criar mais de uma função com o mesmo nome, porém o java só aceita se
	 * a qtd de parâmetros forem difentes;
	 *
	 *
	 *  @@@@@@@@@@ MÉTODO CONSTRUTOR - segundo chatgpt:
	 *
	 *  Aqui estão algumas características importantes dos construtores em Java:

Nome: O nome de um construtor deve ser exatamente o mesmo nome da classe em que ele está definido.

Ausência de tipo de retorno: Os construtores não têm um tipo de retorno especificado (nem mesmo void).
Eles são implicitamente chamados quando um objeto é criado e não podem ser invocados diretamente
por meio de uma chamada de método.

Sobrecarga de construtores: É possível definir vários construtores na mesma classe com diferentes listas de parâmetros.
Isso é conhecido como sobrecarga de construtores. Permite criar objetos de uma classe de diferentes maneiras,
fornecendo diferentes argumentos ao criar um objeto.

Inicialização de membros: Os construtores são usados para inicializar os membros de um objeto,
atribuindo valores iniciais a eles. Isso garante que o objeto esteja em um estado válido e coerente assim que for criado.

Construtor padrão: Se nenhum construtor for explicitamente definido em uma classe,
Java fornece automaticamente um construtor padrão sem argumentos.
Esse construtor padrão apenas chama o construtor padrão da superclasse (se existir).
Caso contrário, é fornecido implicitamente pela linguagem.
	 * */


}
