package treinamento;

public class NumeroNegativoException extends RuntimeException{
    String atributo;

    NumeroNegativoException(String atributo){
        this.atributo = atributo;
    }

    public String getMessage(){
        return String.format("O erro foi em " + this.atributo);
    }
}
