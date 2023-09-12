package exercicios_sala;

public class ContraCheque {
    int matricula;
    String nome;
    double salario;
    ContraCheque(int matricula, String nome, double salario){
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
    }
    double calcularDesconto(double desconto){
        return salario - (salario * (desconto/100));
    }
    public static void main(String[] args) {

        ContraCheque funcionario1 = new ContraCheque(1234, "João Batista", 54515.25);
        System.out.printf("Nome: %s\n" +
                "Matricula: %d\n" +
                "Salário Bruto: %.2f\n" +
                "Salário com desconto Inss: %.2f",
                funcionario1.nome, funcionario1.matricula, funcionario1.salario, funcionario1.calcularDesconto(15));
    }

}
