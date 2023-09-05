package excecao;

public class Basico {
	
	public static void main(String[] args) {
// note que se vc usar o catch vc substitui o erro por uma mensagem mais clara ou uma saída para o erro
// o catch também pode calar todos os erros, isso não é bom, mas todo o código abaixo apresenta erro 
// e se você não exibir uma mensagem alternativa de erro ou uma solução, o código neste caso será todo executado sem erro
		Aluno a1 = null;
		
		try {
			imprimirNomedoAluno(a1);
		}catch(Exception excecao) { //TIPO Exception Nome: excecao (pode ser qualquer nome)
			System.out.println("Erro ao imprimir nome do usuario");
		}
		
		try {
			System.out.println(7/0); // vai dar erro porque é uma divisão impossível
		} catch (ArithmeticException e) {  //aqui tipo da exeção foi copiado da própria mensagem de erro, veja abaixo esse nome
			// TODO Auto-generated catch block
			// e.printStackTrace(); se deixar assim ele exibe ainda o erro, porém mais resumido
			System.out.println("Ocorreu um erro: " + e.getMessage());
		// e.getMessage() ele exibe só o tipo do erro, ou seja, a mensagem de erro que seria exibido de forma resumida com
		// o e.printStackTrace(); agora pode ser ainda mais resumida e estilizada com uso do e.get(Message()) 
		}
/*
		Mensagem de erro só do print 7/0
					Exception in thread "main" java.lang.ArithmeticException: / by zero
							at excecao.Basico.main(Basico.java:11)
	 Exception = erro
	 thread = linha, ou seja, erro na classe main linha 11;
*/
	}	
	
	public static void imprimirNomedoAluno(Aluno aluno) {
		System.out.println(aluno.nome);
	}
	

}
