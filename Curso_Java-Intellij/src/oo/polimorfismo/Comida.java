package oo.polimorfismo;

public abstract class Comida {
	
 //ler arquivo Classe Abstrata
	
	private double peso;	
	
	//Função Construtora
	public Comida(double peso) {
		setPeso(peso);
	}	
	//Getters
	public double getPeso() {
		return peso;
	}
	//Setters
	public void setPeso(double peso) {
		if(peso>=0) {			
			this.peso = peso;
		}
	}
}
