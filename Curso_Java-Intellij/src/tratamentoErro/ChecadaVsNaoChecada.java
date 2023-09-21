package tratamentoErro;

public class ChecadaVsNaoChecada {

	public static void main(String[] args) {

		//geraErro2(); // aqui o código reclamou pois é obrigatório o tratamento do erro 'Exception', ou seja só funciona se usar o try catch
		
		try {
			geraErro2();   // aqui foi obrigatório o tratamento do erro pois herda 'Exception' e não de RuntimeException
		}catch(Throwable e) {
			System.out.println("erro da função geraErrro2() " + e.getMessage());
		}

		geraErro1(); // aqui o erro não precisou ser tratado (RuntimeException) e o código não 'reclamou' = linha vermelha
		
		System.out.println("Fim !");
	}
//RuntimeException são chamadas de "unchecked exceptions" (exceções não verificadas) = NÃO OBRIGATÓRIO TRATAR
	// exemplo de exceção 'NÃO CHECADA' ou 'NÃO VERIFICADA':
	static void geraErro1() {
// new RuntimeException("Ocorreu um erro bem legal #01");  throw significa lançar, então se não colocar throw no início,
// o erro será sim criado, mas não lançado, ou seja, o erro não vai aparecer, por isso abaixo é que está correto:
		throw new RuntimeException("Ocorreu um erro com numero #01 herdado de RunTimeException e não foi obrigado tratar ");
// throw new RuntimeException lança o erro e quebra aplicação, então o que tiver após ele não será executado
// **Importantíssimo, qualquer classe que herde de RuntimeException NÃO terá obrigatoriedade de tratar o erro = exceção 'NÃO CHECADA' ou 'NÃO VERIFICADA'
	}

// Exception são chamadas de "checked exceptions" (exceções verificadas). = OBRIGATÓRIO VERIFICAR
// exemplo de exceção 'CHECADA' ou 'VERIFICADA' que obriga o uso de throws Exception:
	static void geraErro2() throws Exception {
		throw new Exception("mensagem personalizada do erro Nº #02 com herança direta de Exception então foi obrigado tratar com try catch e uso de throws Exception na classe");
// **Importantíssimo, qualquer classe que herde de 'Exception' SIM terá obrigatoriedade de tratar o erro, ou seja, de usar o try catch
	}
// throw indica que você está lançando uma exceção, se não usar o throw a exção não é lançada, mesma coisa de 'RuntimeException'
// se usar apenas o new Exception ou new RuntimeException, em outra parte do código vai ter que usar o 'throw'
}

