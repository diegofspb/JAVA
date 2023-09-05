package arrays.mediaAluno;

public class Aluno {
    String nome;
    double nota;
    double[] notas;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setNota(double nota){
        this.nota = nota;
    }
    public double getNota(){
        return nota;
    }
    public double media(double[] notas){
        double somaNotas = 0;
        for (double nota: notas){
            somaNotas += nota;
        }
        double media = somaNotas / (notas.length);
        return media;
    }
}
