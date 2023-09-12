package oo.exemploVeiculo;
public class CarroTeste {
	public static void main(String[] args) {
		Carro c1 = new Carro();
		System.out.println("Está ligado? " + c1.estaLigado()); // resultado false
		c1.ligar(); // ao executar essa função o carro é ligado
		System.out.println("Está ligado? " + c1.estaLigado()); // agora oo resultado é true
		System.out.println(c1.motor.giros());		
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		System.out.println(c1.motor.giros());
		c1.frear();
		c1.frear();
		c1.frear();		
		System.out.println(c1.motor.giros());
		
	}
}
