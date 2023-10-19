package aula_8.exercicio_01;

public class Teste {
    public static void main(String[] args) {
        Animal a = new Cachorro("Super Cão");
        a.emitirSom();
        a.deslocamento();
        System.out.println("O nome dele é " + a.getNome());

        Animal b = new Gato("Gato Tom");
        b.emitirSom();
        b.deslocamento();
        System.out.println("O nome dele é " + b.getNome());

        Animal c = new Passarinho("Passarinho piu piu");
        c.emitirSom();
        c.deslocamento();
        System.out.println("O nome dele é " + c.getNome());

    }
}
