package oo.polimorfismo;

public class Jantar {

	public static void main(String[] args) {
		
		Pessoa convidado = new Pessoa(99.65);
		
		Arroz ingrediente1 = new Arroz(0.2);
		Feijao ingrediente2 = new Feijao(0.1);
		//Comida ingrediente3 = new Comida(0.3); // foi apenas para mostrar que Comida é classe abstrata e por isso
		// não pode ser intanciada
		
		System.out.println("Peso inicial = " + convidado.getPeso());
		
		convidado.comer(ingrediente1);
		convidado.comer(ingrediente2);
		
		System.out.println("Peso apos comer 2 ingredientes = " + convidado.getPeso());
		
		Sorvete sorvete = new Sorvete(0.4);
		
		convidado.comer(sorvete);		
		
		System.out.println("Peso apos comer a SOBREMESA = " + convidado.getPeso());
	}
}
