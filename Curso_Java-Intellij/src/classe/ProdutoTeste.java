package classe;

public class ProdutoTeste {

    public static void main(String[] args) {

        // Scanner entrada = new Scanner(System.in);
        Produto p1 = new Produto("computador"); // coloquei parâmetro para entender o Método construtor
        Produto.desconto = 0.25;   // só em colocar p1. já aparece os atributos la da outra classe criada
        // acima estava assim:p2.desconto = 0.25, porém estava aparecendo erro, pois a variável desconto foi
        // transformada em estática, o que significa que alterando aqui, ela vai ficar com valor alterado para
        // todas as instâncias, ou seja, alterando aqui o valor vai alterado para p2 também
        // por isso, a forma certa de alterar é direto na raiz, ou seja, direto na classe e agora o programa
        // parou de apresentar erro
        p1.nome = "notebook"; // é idêntido ao PHP
        p1.preco = 5444.54;
        double precoFinal1 = p1.precoComDesconto();
        double descontoGerente1 = p1.precoComDesconto(0.2); //mesmo nome da função/metodo
        /*
         * o comentário do scanner foi para mostrar que para utilizar outra classe
         * bastou utilizar a mesma estrutura do scanner que seria
         * Produto (TIPO) p1 (NOME) = new Produto() ;
         * na teoria uma CLASSE define um TIPO
         * se realmente fosse utilizar o Scanner teria que importar lá em cima
         * porém, quando a classe a ser importada estiver dentro do mesmo pacote
         * que neste caso o nome do pacote é "classe" então não precisa importar
         * */
        var p2 = new Produto(); //teoria diz que se colocar var e instanciar Produto(), o
        // java já entende que esse var é do tipo Produto como feito no exemplo anterior
        //p2.desconto = 0.35;   // só em colocar p2. já aparece os atributos la da outra classe criada
        p2.nome = "Caneta"; // é idêntido ao PHP
        p2.preco = 4.04;
        double precoFinal2 = p2.precoComDesconto();
        double descontoGerente2 = p2.precoComDesconto(0.1); //mesmo nome da função/metodo

        Produto p3 = new Produto("mouse", 344435, 0.3); // utilizando metodo construtor que aceita (nome + preco + desconto)
        // só em colocar p3. já aparece os atributos la da outra classe criada

        double precoFinal3 = p3.precoComDesconto();
        double descontoGerente3 = p3.precoComDesconto(0.2); //mesmo nome da função/metodo

        System.out.printf("O produto %s possui preco com desconto R$ %.2f",p1.nome,precoFinal1);
        System.out.printf("\nO produto %s com desconto do gerente R$ %.2f",p1.nome,descontoGerente1);
        System.out.printf("\nO produto %s possui preco com desconto R$ %.2f",p2.nome,precoFinal2);
        System.out.printf("\nO produto %s com desconto do gerente R$ %.2f",p2.nome,descontoGerente2);
        System.out.printf("\nO produto %s possui preco com desconto R$ %.2f",p3.nome,precoFinal3);
        System.out.printf("\nO produto %s com desconto do gerente R$ %.2f",p3.nome,descontoGerente3);

    }
}
