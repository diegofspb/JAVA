package oo.eNum;

public class Posicao {
    int x;
    int y;

    boolean caminhar(Direcao direcao){
        switch (direcao){
            case NORTE:
                x++;
                break;
            case SUL:
                y++;
                break;
        }
        return true;
    }
}
