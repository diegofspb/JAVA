package streams;

public class Aluno {

	final String nome;
	final double nota;
	
	public Aluno(String nome, double nota) {   // criando o método construtor, botão direito do mouse->resouse->generate_constructor, 
		// super(); desnecessário
		this.nome = nome;
		this.nota = nota;
	}
	
	public String toString() { //foi construido para uso na aula de MaxMin
		return nome + " tem nota " + nota;
	}
}
