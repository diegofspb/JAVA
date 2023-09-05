package lambdas;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {	
	public static void main(String[] args) {
		/*
		Interface:
		 	https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
		 	- no site acima existem diversas 'INTERFACES', abaixo veremos apenas 1:
		 	
		 BinaryOperator<Classe> essa classe é que pode ser: INTEGER, DOUBLE, CHAR, CARACTERE, etc...
		*/		
		BinaryOperator<Double> calc1 = (x,y) -> {return x + y;};
		System.out.println(calc1.apply(3.0, 4.0));
		// Não permite: int -> Double (Classe)
		// permite sim: double -> Double (Classe)
		// por isso se deixasse calc.apply(2, 3) daria erro;
		BinaryOperator<Integer> calc2 = (x,y) -> {return x + y;};
		System.out.println(calc2.apply(3, 4));
		// note que a classe é que definirá o que será aceito na função, neste calc2 só aceita Inteiro
	}
}
