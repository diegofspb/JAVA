package generics;

public class CaixaObjeto {
    // este exemplo é sem utilizar o 'generics', o arquivo 'Caixa' é que possui o exemplo de generics
    private Object coisa;

    public void guardar(Object coisa){
        this.coisa = coisa;
    }

    public Object abrir(){
        return this.coisa;
    }
}
