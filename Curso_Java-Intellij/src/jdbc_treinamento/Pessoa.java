package jdbc_treinamento;

public class Pessoa {
    String nome;
    int id;

    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return " id(" +getId() +") nome = " + getNome();
    }
}
