package nota_aula3.questao1;

public class SistemaVeiculos {
    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.marca = "Fiat";
        carro.modelo = "Uno";
        carro.anoFabricacao = 1940;
        carro.numPortas = 4;

        Moto moto = new Moto();
        moto.marca = "Honda";
        moto.modelo = "900r";
        moto.anoFabricacao = 2021;
        moto.cilindradas = 900;

        System.out.println(carro.imprimirDetalhes());
        System.out.println(moto.imprimirDetalhes());
    }

}
