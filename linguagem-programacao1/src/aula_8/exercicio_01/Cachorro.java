package aula_8.exercicio_01;

public class Cachorro extends Animal{
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("O cachorro está latindo!");
    }

    @Override
    public void deslocamento() {
        System.out.println("O cachorro está correndo!");
    }
}
