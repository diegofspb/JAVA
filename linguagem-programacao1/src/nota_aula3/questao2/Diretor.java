package nota_aula3.questao2;

public class Diretor extends Funcionario{
    int acoes;
    public String toString(){
        return  "Diretor: " + nome +
                " - Salário: " + salario +
                " - Ações da empresa : " + acoes;
    }
}
