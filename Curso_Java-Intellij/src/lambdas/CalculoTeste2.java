package lambdas;
public class CalculoTeste2 {	
	public static void main(String[] args) {
		/*
		lambda function:
		 - Criar uma função anônima com return
		 - não precisa instanciar, é como se ao utilizar o nome da Classe + nome da variável já instanciasse automaticamente
		 - Calculo é do tipo interface, então precisa de implementação, é isso que está ocorrendo abaixo;
		 - na Interface Calculo existe apenas 1 método sem corpo, está assim: double executar (double a, double b);
		 - simplesmente ao utilizar apenas um 'return' já está implementando = criando corpo = existindo algo a retornar		 
		*/		
		Calculo calc = (x,y) -> {return x + y;};
		
		System.out.println(calc.executar(3, 4));		
		
		/* ou forma MENOS usada:	
				Calculo soma = (x,y) -> {
				return x + y;
			};	
		 */// forma resumida e mais usada pelos programadores:
		
		calc = (a, b) -> a * b;
		System.out.println(calc.executar(2, 3));
		
		// foram realizadas 2 tipos de operações acima, uma de soma e outra de multiplicação
		// não foi preciso chamar as classes 'Somar' e 'Multiplicar', pois a função lambda é resumida e fez tudo
		// e também não foi preciso implementar a classe Calculo
		
	}
}
