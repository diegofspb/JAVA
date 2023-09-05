package lambdas;

public class CalculoTeste1 {

	public static void main(String[] args) {
		
		//Somando
		Calculo soma = new Somar();
		System.out.println(soma.executar(3, 4));
		//Multiplicando sobrescrevendo o a Instancia do Objeto por outra classe, pois ambas implementam a classe 'Calculo'
		soma = new Multiplicar();
		System.out.println(soma.executar(3, 4));		
		//Multiplicando
		Calculo multiplicacao = new Multiplicar();	
		System.out.println(multiplicacao.executar(3, 4));
	}
}
