package classe.exercicios.comer;

public class Jantar {
    // contém o método main, criar pessoa e comida e instancia comida informando nome, peso
    public static void main(String[] args) {

        Comida arroz = new Comida("arroz",1.2);
        Comida feijao = new Comida("feijao",0.2);

        Pessoa p1 = new Pessoa("Joao", 72.5);
        System.out.println(p1.apresentar());

        p1.comer(arroz);
        System.out.println("Depois de comer arroz");
        System.out.println(p1.apresentar());

        p1.comer(feijao);
        System.out.println("Depois de comer feijão");
        System.out.println(p1.apresentar());
    }
}
