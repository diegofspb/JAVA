package excecao;

import java.util.Scanner;

public class Finally {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		try {
			System.out.println(7 / entrada.nextInt());
			// se tivesse deixado aqui o entrada.close(); e o código da linha de cima desse erro, então
			// pularia o entrada.close(); e cairia direto no catch e a 'entrada' continuaria aberto
		} catch (Exception e) {			
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Finally ....");
			entrada.close();		
			// finally é quando tudo der errado ou não, mesmo assim o finally será executado de qualquer forma
			// o exemplo dado pelo professor foi caso vc estivesse acessando o banco de dados e houvesse algum
			// erro, mesmo assim o finally conseguira fechar a conexão mesmo com o erro 
		}
		
		System.out.println("FIM");
	}
}
