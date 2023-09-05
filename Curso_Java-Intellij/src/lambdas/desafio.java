package lambdas;

import java.text.DecimalFormat;

public class desafio {

	public static void main(String[] args) {		
		/*  RESOLVI ERRADO, o certo é encadear tudo utilizando Interfaces
		 1. A partir do produto calcular o preço real (com desconto)
		 2. Imposto municipal: >=2500 (8,5%) / <2500 (isento)
		 3. Frete: >=3000(100)/ <3000 (50)
		 4. Arredondar para ficar 2 cadas decimais
		 5. formatar R$ 1234,56   no lugar do ponto botar virgula
		 */
		Produto p = new Produto("iPad", 3235.89, 0.13);
		Double precoComDesconto = p.preco * (1-p.desconto);
		Double imposto = precoComDesconto>=2500 ? precoComDesconto * 0.085: 0;
		Double frete = precoComDesconto>=3000 ? 100.00 : 50.00;
		System.out.println("O preco do " + p.nome + " com desconto = R$ " + precoComDesconto);
		System.out.println("O preco do Imposto eh R$ " + imposto);
		System.out.println("O preco do frete eh R$ " + frete);
		Double precoFinal = precoComDesconto + imposto + frete;
		System.out.println("O preco real do " + p.nome + " eh R$ " + precoFinal);
		DecimalFormat df = new DecimalFormat();
		String numeroFormatado = df.format(precoFinal);
		System.out.println("O preco real FORMATADO eh R$ " + numeroFormatado);
     

		
		
		
		
	}
}
