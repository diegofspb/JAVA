package oo.abstrato;

public abstract class Mamifero extends Animal{

	// veja que na Classe Cachorro não será necessário implementar além do método mamar() que foi criado abaixo
	// também o método mover, ou seja:
	// se uma classe abstrata tiver um método abstrato, ela não precisa obrigatoriamente criar o corpo da classe
	// se outra classe abstrata 'extends' de uma classe abstrata, também não terá obrigação de criar o corpo do método
	// isso tem efeito acumulativo, se uma classe abstrata 'extends' outra classe e por ai vai, dada uma criando um
	// método abstrato, então vai somando os métodos abstratos para quando aparecer uma classe concreta que 'extends' 
	// de uma classe abstrata, ai sim essa classe concreta terá que implementar, ou seja, 
	// criar o corpo de todos os métodos abstratos 'não implementados' 
	public String mover() {
		return "Usando as patas";
	}
	
	public abstract String mamar();
	// essa classe abstrata mamar parece como interface, vc aqui não implementa o corpo, ou seja
	// não existe o que realmente essa classe faz, porém quando outra classe implementa
	// esse método mamar() ai sim terá que criar o que ela faz, ou seja, criar o corpo da classe
	//PORÉMMMMM
	// se a outra classe implementar esta classe Mamifero e não for também abstrata, então ela terá de implementar obrigatoriamente
}
