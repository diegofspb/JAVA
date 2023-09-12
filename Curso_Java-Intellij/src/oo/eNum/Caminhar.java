package oo.eNum;

public class Caminhar {
    public static void main(String[] args) {
        Posicao posicao = new Posicao();
        posicao.caminhar(Direcao.NORTE);
        posicao.caminhar(Direcao.NORTE);
        posicao.caminhar(Direcao.NORTE);
        posicao.caminhar(Direcao.NORTE);
        posicao.caminhar(Direcao.SUL);
        posicao.caminhar(Direcao.SUL);

        System.out.println(posicao.x);
        System.out.println(posicao.y);
    }



}
