package generics;

public class Caixa<TIPO> {

    // Usando o generics, após o nome da classe pode-se colocar Caixa <qualquer coisa aqui>, geralemente uma letra maiúcsula <T>
    private TIPO coisa; // a variável coisa não foi especificada que tipo é, pois ao usar <TIPO> ela pode assumir qualquer coisa

    public void guardar(TIPO coisa){
        this.coisa = coisa;
    }

    public TIPO abrir(){
        return this.coisa;
    }
}
