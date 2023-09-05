package classe.exercicios.contaBancaria;

public class Cliente {

    public static void main(String[] args) {
        ContaBancaria c1 = new ContaBancaria("João");

        c1.depositar(80);
        System.out.println(c1.conta());
        System.out.println("Após o Saque: ");
        c1.sacar(12.5);
        System.out.println(c1.exibirSaldo());
    }
}
