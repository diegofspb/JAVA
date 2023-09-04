package nota_aula4;

import java.util.Scanner;

public class Cadastro {
    public static void main(String[] args) {
        boolean decisao = true;
        do {
            Produto p1 = new Produto();
            Scanner entrada = new Scanner(System.in);
            System.out.println("Informe o código do produto: ");
            p1.setCodigo(entrada.nextInt());
            System.out.println("Informe o nome do produto");
            p1.setNome(entrada.next());
            System.out.println("Informe a quantidade do produto");
            p1.setQtd(entrada.nextInt());

            System.out.printf("Todos os dados salvos com sucesso:\nProduto:\nCódigo: %d \nNome: %s \nQuantidade: %d \n",
                    p1.getCodigo(),p1.getNome(),p1.getQtd());

            System.out.println("Deseja realizar a venda de um " + p1.getNome() + "? (0=Sim / 1=Não)");
            int escolha = entrada.nextInt();
            if(escolha == 0){
                System.out.println("Qual a quantidade ?");
                int quantidade = entrada.nextInt();
                p1.venda(quantidade);
                System.out.printf("Estoque atual do produto %s é = %d \n", p1.getNome(), p1.getQtd());
            }

            System.out.println("Deseja sair programa ? (0=Sim / 1=Não)");
            int saida = entrada.nextInt();
            if(saida == 0){
                decisao = false;
            }
        }while (decisao);

        System.out.println("Programa Finalizado!");
    }
}
