package aula_8.exercicio_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        Produto p1 = new Livro("Biblia", 50.0);
        Produto p2 = new Eletronico("NoteBook", 3200.00);
        Produto p3 = new Roupa("Camisa", 25.90);


        List<Produto> produtos = Arrays.asList(p1,p2,p3);

        for (Produto produto: produtos) {

            if (produto instanceof Livro) {
                produto.desconto();
                System.out.println("O produto é um: " + produto.getNome() + " e com desconto de 10% fica R$ " + produto.getValor());
            } else if (produto instanceof Eletronico) {
                produto.desconto();
                System.out.println("O produto é um: " + produto.getNome() + " e com desconto de 5% fica R$ " + produto.getValor());
            }else{
                System.out.println("O produto é um: " + produto.getNome() + " e não possui desconto, o valor fica R$ " + produto.getValor());
            }
        }


    }
}
