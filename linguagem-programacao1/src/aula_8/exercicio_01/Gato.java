package aula_8.exercicio_01;

public class Gato extends Animal{

    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("O gato está miando!");
    }

    @Override
    public void deslocamento() {
        System.out.println("O gato está correndo!");
    }
}
