package oo.exemploCompraDificuldade2;
public class SistemaCaixaLoja {
    public static void main(String[] args) {
        System.out.println("$$ Sistema Caixa Loja $$");

        Produto p1 = new Produto("bola", 3.45);
        Produto p2 = new Produto("copo", 4.23);
        Produto p3 = new Produto("vela", 1.25);
        Produto p4 = new Produto("agua", 1.56);

        Item item1 = new Item(3, p1);
        Item item2 = new Item(5, p2);
        Item item3 = new Item(7, p4);
        Item item4 = new Item(2, p4);

        Compra compra1 = new Compra();
        compra1.itens.add(item1);
        compra1.itens.add(item2);

        Compra compra2 = new Compra();
        compra2.itens.add(item3);
        compra2.itens.add(item4);

        Cliente c1 = new Cliente();
        c1.nome = "Maria";
        c1.compras.add(compra1);
        c1.compras.add(compra2);

        System.out.printf("Total da Compra: R$ %.2f",c1.obterValorTotal());

    }
}
