package Modelo.heranca;

public class Alunobolsista extends Aluno{
    private double valorBolsa;

    public Alunobolsista(Long matricula, String nome, double valorBolsa){
        super(matricula, nome); // AlunoBolsista extends Aluno, então os atributos matricula e nome vem de lá e pode ser setado por aqui
        this.valorBolsa = valorBolsa;
    }

}
