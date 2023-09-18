package testes_treinamento;

public class Teste {
    public static void main(String[] args) {
        MediaTeste m1 = new MediaTeste().adicionar(8.3).adicionar(6.7);
        System.out.println(m1.getValor());
    }
}
