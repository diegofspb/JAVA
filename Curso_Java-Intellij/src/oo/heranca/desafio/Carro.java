package oo.heranca.desafio;

public class Carro {

	int velocidadeAtual = 50;
	
	void acelerar() {	
		velocidadeAtual += 5;	
		
	}
	void frear() {	
		if(velocidadeAtual>0) {
			velocidadeAtual -= 5;			
		}else {
			velocidadeAtual = 0;			
		}
	}
}
