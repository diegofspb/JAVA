package excecao;

public class ChecadaVsNaoChecada {

	public static void main(String[] args) {
		geraErro1(); // aqui o erro não precisou ser tratado (RuntimeException) e o código não 'reclamou' = linha vermelha
		//geraErro2(); // aqui o código reclamou pois é obrigatório o tratamento do erro 'Exception'
		
		try {
			geraErro2();   // aqui foi obrigatório o tratamento do erro 'Exception'
		}catch(Throwable e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim !");
	}
//RuntimeException são chamadas de "unchecked exceptions" (exceções não verificadas) = NÃO OBRIGATÓRIO VERIFICAR
	static void geraErro1() {
		throw new RuntimeException("Ocorreu um erro bem legal #01");
// **Importantíssimo, qualquer classe que herde de RuntimeException NÃO terá obrigatoriedade de tratar o erro
	}
// Exception são chamadas de "checked exceptions" (exceções verificadas). = OBRIGATÓRIO VERIFICAR
	static void geraErro2() throws Exception {
		throw new Exception("Ocorreu um erro bem legal #02");
// **Importantíssimo, qualquer classe que herde de 'Exception' SIM terá obrigatoriedade de tratar o erro
	}
// throw indica que você está lançando uma exceção, se não usar o throw a exção não é lançada
// se usar apenas o new Exception ou new RuntimeException, em outra parte do código vai ter que usar o 'throw'
}

