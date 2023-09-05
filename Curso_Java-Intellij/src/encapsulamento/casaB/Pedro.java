package encapsulamento.casaB;

import encapsulamento.casaA.Ana; //Ana está em outro pacote, por isso para executar o 'extends' tem que importar antes aqui

public class Pedro extends Ana {

	Ana mae = new Ana(); // quando você importa uma classe como foi feito acima, não precisa instanciar, pois ao
	// importar uma classe e utilizar o 'extends' em seguida, vc já pode utilizar normalmente os atributos/métodos
	
	// veja abaixo que está dando erro em quase tudo:
	void testeAcessos() {
		
		// System.out.println(mae.segredo); // o atributo segredo é private, está sublinhado de vermelho e por
		// isso não pode ser utilizado por outra classe a não ser a da Ana que é a proprietária deste atributo.
		// System.out.println(mae.facoDentroDeCasa); // facoDentroDeCasa é do tipo pacote, ou seja, só é visível dentro
		// do mesmo pacote, não é este o caso
		//System.out.println(mae.formaDeFalar);  // formaDeFalar é protected, pode ser acessível por herança normal
		//System.out.println(mae.todosSabem); // todosSabem é publico, então não tem qualquer restrição
		
	// ############ AGORA A FORMA CORRETA é acessa diretamente atributos/métodos
		
		//System.out.println(segredo); // privado continua sem acesso por herança
		//System.out.println(facoDentroDeCasa); // tipo pacote continua sem acesso por esta classe estar em outro pacote
		//System.out.println(formaDeFalar);  // protected foi herdado normalmente
		//System.out.println(todosSabem); // publico sempre sem restrição
	}
}
