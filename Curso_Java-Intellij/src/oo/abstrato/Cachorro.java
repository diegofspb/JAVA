package oo.abstrato;

public class Cachorro extends Mamifero{

	@Override
	public String mamar() {
		// TODO Auto-generated method stub
		return null;
	}

	// se esta é concreta, se fosse classe abstrata não precisaria implementar o método abstrato que está em Mamifero;
	// ou seja, se uma classe 'extends' de uma Classe abstrata com método abstrato, essa nova classe
	// obrigatoriamente terá que implementar o método abstrato não implementado da classe extendida


}
