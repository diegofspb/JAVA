package encapsulamento;

public class PessoaTeste {

	public static void main(String[] args) {
		
		//lembrando que toda vez que você instancia uma classe, vc obrigatória utiliza o método
		// construtor padrão da classe que seria quando vc não coloca nada ou
		// no caso abaixo o método construtor espera um valor inteiro conforme é possível ver na classe Pessoa
		
		Pessoa p1 = new Pessoa("Joao", -30);
		System.out.println("Idade inical no Construtor = " + p1.getIdade());
		//p1.idade = 30;  alterar o valor da 'private idade' não é possível, apenas dentro da prórpria classe Pessoa
		// A forma correta para alterar a idade é:
		p1.setIdade(-50); // o valor negativo foi para mostrar a funcionalidade de Math.abs(atributo), que faz
		// com que o valor da variável seja absoluto = abs = tudo fica positivo mesmo se digitar negativo
		
		//System.out.println(p1.idade);  // Lê o valor da variável
		// idade é do tipo private, então não pode ser lida/alterada aqui
		// para podermos ler o atributo idade, foi criada uma função na classe Pessoa de nome lerIdade(), pois
		// dentro da classe Pessoa o atributo private idade pode ser manipulado
		
		System.out.println("Nova idade = " + p1.getIdade());
		System.out.println(p1);
	}
}
