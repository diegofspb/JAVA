package exercicios_sala;

import java.util.Scanner;

public class Aluno {

    private String nome;  //private significa que será visível apenas nesta classe
    private double[] notas; //o plano é que notas possam ser adicionadas em uma lista

    public Aluno(String nome, int numNotas){ //public significa que será visível em qualquer lugar
        this.nome = nome;
        this.notas = new double[numNotas]; //numNotas é a quantidade de notas que o usuário pretende inserir, pois
        // aqui estamos criando um array vazio com tamanho de numNotas
        // Em Java, para criar um array, você precisa usar a palavra-chave 'new' para alocar espaço na memória
    }
    public void lerNotas(Scanner entrada){
        for (int i = 0; i < notas.length; i++){
            System.out.println("Informe a " + (i+1) + " nota :");
            notas[i] = entrada.nextDouble(); // aqui efetivamente o array notas vai receber cada uma nota
        }
    }
    public double media(){
        double somandoNotas = 0;
        for(double nota: notas){
            somandoNotas += nota;
        }
        return somandoNotas / notas.length;
    }
    public boolean aprovado(){
        if(media()>=7){
            return true;
        }else{
            return false;
        }
    }
}
