package oo.exemploCurso;

import java.util.Scanner;

public class SistemaFaculdade {
    public static void main(String[] args) {
        System.out.println("@@ Sistema Faculdade @@");

        Curso c1 = new Curso();
        c1.nome = "Direito";
        c1.turma.add(new Aluno("Maria", 21));
        c1.turma.add(new Aluno("João", 42));

        Curso c2 = new Curso();
        c2.nome = "Letras";
        c2.turma.add(new Aluno("ARLAN", 33));
        c2.turma.add(new Aluno("Sara", 28));

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um curso para saber quais alunos estão matriculados: ");
        String curso = entrada.next();

        if(c1.nome.equalsIgnoreCase(curso)){
            for(Aluno aluno: c1.turma){
                System.out.println(aluno);
            }
        }else{
            for(Aluno aluno: c2.turma){
                System.out.println(aluno);
            }
        }
    }
}
