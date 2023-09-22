package tratamentoErro.personalizadaA;

import tratamentoErro.Aluno;

public class Validar {

	private Validar() {} // tornou o método construtor privado para que nenhuma outra classe possa instanciar esta classe Validar()

	//A escolha de tornar o método alunoValidado estático permite que você chame este método diretamente na classe Validar sem precisar criar uma instância da classe.
	public static void alunoValidado(Aluno aluno) {
		if(aluno == null) {
			throw new IllegalArgumentException("O aluno esta nulo !"); // caso o ojbeto não exista = não tenha sido instanciado
		}
		if(aluno.nome == null || aluno.nome.trim().isEmpty()) { //objeto criado, porém nome vazio
			throw new StringVaziaException("nome");
		}
		if(aluno.nota < 0 || aluno.nota>10) { // caso a nota seja negativo ou maior que 0
			throw new NumeroForaIntevaloException("nota");
		}
	}
}
