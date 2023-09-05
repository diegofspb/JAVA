package encapsulamento;

public class Pessoa {

	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	private int idade; //desta forma apenas a classse Pessoa pode alterar/ler a variável idade
	
//criando um método para alterar o atributo private idade aqui dentro da classe, pois se for em outra classe não funciona
// o método abaixo é do tipo construtor, por ter exatamente o mesmo nome da Classe
	
	public Pessoa(String nome, int idadeDoConstrutor) {
		setNome(nome);
		setIdade(idadeDoConstrutor); // o que estava aqui era => this.idade = idadeDoConstrutor
		// porém foi aproveitado uma função já criada justamente que alterar o valor do atributo idade
		// deixando o código melhor
	}
	// Getter é um método que 'LER'
	public int getIdade() {
		return idade;
	}
	//Setter é um método que 'ALTERA'
	public void setIdade(int novaIdade) {
		if(novaIdade>0) {			
			this.idade = novaIdade;
		}else{
			this.idade = Math.abs(novaIdade);
		}
	}
	
	// Utilizando o método toString que serve para quando exibir a variável no println ser exibico também um texto padrão
	
	@Override // significa que está sobrescrevendo o método
	
	public String toString() {
		return "Ola eu sou o " + getNome() + " tenho " + getIdade() + "anos";
	}
}
