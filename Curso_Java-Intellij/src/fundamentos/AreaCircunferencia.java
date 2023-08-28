package fundamentos;

public class AreaCircunferencia {
	
	//neste exercício vamos aprender a declarar uma variável 
	// -> TIPO DA VARIAVEL + NOME DA VARIAVEL
	
	public static void main(String[] args) {
		// int raio = 3;   
		// double raio = 3.4;
		
		double raio = 3.4;
		final double PI = 3.14159; //NOME de constante = MAIÚSCULA
//adicionando a palavra "final" isso quer dizer que a variável se tornará imutável/constante
		
// apenas declara-se a variável 1 vez
		
		System.out.println(PI*raio*raio);
		
		//exemplo concatenando texto + variavel
		
		double area = PI*raio*raio;
		
		System.out.println("Area = " + area);
	}
}
