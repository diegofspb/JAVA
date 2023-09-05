package classe.exercicios.contaBancaria;
import java.util.Random;
public class ContaBancaria {

    final int numeroConta;
    double saldo;
    String titular;

    Random rand = new Random();
    ContaBancaria(String titular){
        this.numeroConta = rand.nextInt(9000) + 1000;
        this.titular = titular;
    }
    void depositar(double valor){
        this.saldo += valor;
    }
    void sacar(double valor){
        this.saldo -= valor;
    }
    public String exibirSaldo(){
        return "Saldo atual = " + this.saldo;
    }
    public String conta(){
        return "Numero da conta: " +
                this.numeroConta +
                "\n" +
                "Titular: " +
                this.titular +
                "\n" +
                "Saldo atual = " + this.saldo;
    }

}
