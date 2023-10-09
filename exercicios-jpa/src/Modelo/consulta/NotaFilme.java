package Modelo.consulta;

//esta pesquisa é realizada com código SQL, no meu entendimento este exemplo é para que o banco de dados processe a pesquisa e faça o calculo da media já retornando tudo pronto
// os parâmetros de pesquisa estão no arquivo consulta.xml
public class NotaFilme {
    private double media;

    public NotaFilme(double media) {
        this.media = media;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
