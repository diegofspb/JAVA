package nota_aula3.questao2;

public class SistemaEmpresa {
    public static void main(String[] args) {

        Gerente gerente = new Gerente();
        gerente.nome = "Maria";
        gerente.salario = 2000.00;
        gerente.departamento = "Vendas";

        System.out.println(gerente);

        Diretor diretor = new Diretor();
        diretor.nome = "João";
        diretor.salario = 18000.00;
        diretor.acoes = 750;

        System.out.println(diretor);
    }
}
