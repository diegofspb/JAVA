package oo.exemploCurso;

public class Aluno {
    String nome;
    int idade;

    Aluno(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String toString(){
        return "Nome do aluno: " + nome;
    }

}
