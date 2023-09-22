package treinamento;

import java.util.Objects;

public class Aluno {
    String nome;
    double nota;

    Aluno(String nome, double nota){
        this.nome = nome;
        this.nota = nota;
    }

    public String toString(){
        return "Nome: " + nome + " Nota: " + nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return Double.compare(nota, aluno.nota) == 0 && Objects.equals(nome, aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nota);
    }
}
