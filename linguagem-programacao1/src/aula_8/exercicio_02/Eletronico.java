package aula_8.exercicio_02;

public class Eletronico extends Produto{
    public Eletronico(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public void desconto() {
        this.setValor(
                this.getValor() - (this.getValor() * 0.05)
        );
    }
}
