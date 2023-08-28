package fundamentos;

public class VariaveisTipos {
    public static void main(String[] args) {

        /*
         * importante! o Java primeiro analisa o tipo do valor que está sendo atribuído a variável,
         * depois verifica que a declaração da variável corresponde ao valor atribuido e se tiver
         * tudo ok, então a variável receberá o valor, senão dará erro, isso é possível ver no
         * exemplo long, onde o valor digitado é do tipo inteiro e a variável criada é do tipo long
         * então apareceu um erro e para resolver bastou colocar no final do valor da variável
         * a letra L para demonstrar que o valor não se trata de um int e sim de um long
         */
        byte anos = 127; // 1 byte suporta entre -127 até 127, se colocar 128 já da erro
        short numeros = 32767; // short = 2 bytes e o máximo é 32767
        int id = 54552; //int = 4 bytes e o tamanho é de 2 milhoes
        //long pontos = 3234845222; desde jeito, apesar de ter sido declarado o valor long, mas
        // o java entende que é um inteiro (int), por este motivo, coloca-se L no final para
        //informar que na verdade esse valor inteiro será transformado em um long
        long pontos2 = 3234845222L; //note que agora parou de dar erro

        // float salario = 1.44;  float = 4 bytes e note que deu erro,
        /* se vc colocar um ponto dentro de um número o java vai entender que se trata
         * de um doble e não de um float e para resolver isso bastou informar que o valor na realidade
         * se trata de um float, veja abaixo o correto
         * */
        float salario2 = 1.44F;
        double acumulado = 156465654654654.01; //double = 8 bytes é grande

        char status = 'a'; //tipo caractere e só aceita 1 letra
    }
}
