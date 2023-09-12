package nota_aula3.questao2;

public class Gerente extends Funcionario{
    String departamento;

    public double bonusSalario(){
        return salario * 0.1;
    }
    public String toString(){
        return  "Gerente: " + nome +
                " - Salário: " + salario +
                " - Bonus Salário " + bonusSalario() +
                " - Departamento: " + departamento;
    }

}
