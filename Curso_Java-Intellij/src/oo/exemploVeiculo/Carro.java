package oo.exemploVeiculo;

public class Carro {

	// Motor motor; se fizesse isso sem instanciar, o carro ganharia um motor com valor null.
	Motor motor = new Motor(); //como faz para dizer que o carro tem motor? exatamente instanciar!
	// se colocasse static em 'Motor motor' ficaria atributo de classe, porém deixando assim
	// fica atributo de instancia
	
	void acelerar() { //nesta classe carro é possível relizar estas ações = acelerar, frear, ligar
		motor.fatorInjecao += 0.4;
	}	
	void frear() {
		motor.fatorInjecao -= 0.4;
	}
	void ligar() {
		motor.ligado = true;
	}
	void desligar() {
		motor.ligado = false;
	}
	boolean estaLigado() {
		return motor.ligado;
	}
	
	/* "void" é usada para indicar que um método não retorna um valor específico. 
	 * Ele é usado quando o propósito do método é apenas executar uma ação ou 
	 * realizar uma operação sem retornar um resultado utilizável.*/
	
	
}
