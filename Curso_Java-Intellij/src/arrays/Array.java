package arrays;

public class Array {
    public static void main(String[] args) {

        String[] nomes = {"a","b","c"}; // inicializando de forma direta, o tamanho é calculo automaticamente
        int[] numeros = new int[6] ;  //inicializando array através da alocação de memória

        numeros[2] = 3;
        System.out.println("O tamanho do array é: " + nomes.length);
        System.out.println(numeros[2]);
    }
}
