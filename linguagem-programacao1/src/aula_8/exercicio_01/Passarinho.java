package aula_8.exercicio_01;

public class Passarinho extends Animal{
    public Passarinho(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("O passaro está cantando!");
    }
    @Override
    public void deslocamento() {
        System.out.println("O passaro está voando!");
    }
}
