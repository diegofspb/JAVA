package lambdas;

public class Produto {

	final String nome;
	final double preco;
	final double desconto;
	public Produto(String nome, double preco, double desconto) {
		// pode deletar essa classe super()
		super(); // por padrão ao criar o método construtor através de resource -> generate constructor etc..
		// essa classe super() é criada informando que você está herdando de outra classe o método construtor
		// porém, essa classe não está herdando nada de canto nenhum, por padrão toda classe herda da classe global Object
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}
	public String toString() {
		double precoFinal = preco * (1-desconto);
		return nome + " tem preco de R$ " + precoFinal;
	}
}
