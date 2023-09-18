package testes_treinamento;

public class MediaTeste {
    private double total;
    private int quantidade;

    public MediaTeste adicionar(double valor){
        total += valor;
        quantidade ++;
        return this;
    }

    public double getValor(){
        return total / quantidade;
    }

}
