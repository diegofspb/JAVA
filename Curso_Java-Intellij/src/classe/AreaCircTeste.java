package classe;

public class AreaCircTeste {

    public static void main(String[] args) {
        AreaCirc a1 = new AreaCirc(5.6);
        AreaCirc a2 = new AreaCirc(5.6);


        //a1.pi = 10; // pi é estático, então fazendo isso, o programa apenas vai Ler o ultimo valor de pi, ou seja = 5
        //a2.pi = 5; // ESTE é ultimo valor de pi instanciado

        //AreaCirc.PI = 3.1415; //a forma correta de se alterar o valor de pi é acessando diretamente a CLASSE

        System.out.println(a1.area());
        System.out.println(a2.area());
    }
}
