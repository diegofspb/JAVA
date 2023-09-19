package nota_aula5;

public class Carro {
    String marca;
    String modelo;

    Carro(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public String toString(){
        System.out.println("A marca do carro é " + this.marca + " e o modelo é " + this.modelo);
        return "";
    }


    public String mostrarDetalhes(){
        return toString();
    }
}
