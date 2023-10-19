package aula_8.exercicio_02;

public class Livro extends Produto{
    public Livro(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public void desconto() {
        this.setValor(
                this.getValor() - (this.getValor() * 0.1)
        );
    }
}
