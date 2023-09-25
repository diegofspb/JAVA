package generics;

public class CaixaTeste {

    public static void main(String[] args) {

        Caixa<String> c1 = new Caixa<>();  // aqui a Classe Caixa recebe uma string
        c1.guardar("uma string");
        System.out.println(c1.abrir());

        Caixa<Double> c2 = new Caixa<>(); // aqui a Classe Caixa recebe um double
        c2.guardar(5.6);
        System.out.println(c2.abrir());
    }
}
