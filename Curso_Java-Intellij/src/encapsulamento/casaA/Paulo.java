package encapsulamento.casaA;

public class Paulo {

	Ana esposa = new Ana();

	void testeAcessos() {
		
		// System.out.println(esposa.segredo); //tire o comentário e vc verá que o atributo segredo é private, por 
		// isso não pode ser utilizado por outra classe a não ser a da Ana que é a proprietária deste atributo.
		System.out.println(esposa.facoDentroDeCasa); // facoDentroDeCasa não foi especificado que tipo de
		// atributo é, então ele será por default pacote, ou seja, pode ser utizando dentro do mesmo pacote
		// neste caso o pacote é 'encapsulamento.casaA'
		System.out.println(esposa.formaDeFalar);  // formaDeFalar é protected, pode ser acessível por herança normal
		System.out.println(esposa.todosSabem); // todosSabem é publico, então não tem qualquer restrição
	}
}
