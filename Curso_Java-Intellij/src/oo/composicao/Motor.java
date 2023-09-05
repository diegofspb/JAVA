package oo.composicao;

public class Motor {
	
	// esta classe Motor foi criada apenas para ser um CONSTRUTOR, contendo atributos e métodos 
	//  que servirão de modelo para quando forem instanciados em outras classes
	// ao executar as funções da classe Carro que instanciou esta Classe Motor, notei que na verdade
	// nada aqui na Classe Motor foi alterado

	boolean ligado = false;
	double fatorInjecao = 1;
	
	int giros() {
		if(!ligado) { //se o motor estiver desligado "!ligado" o valor do giro = 0, porém se tiver ligado = 3000
			return 0;
		}else {
			return (int) Math.round(fatorInjecao * 3000); 
			//fui obrigado a informar o tipo do retorno (int) que é um "CAST" para poder usar notação .
			//ou seja, ferramentas como a Math.
		}
	}
}


