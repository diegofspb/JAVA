package teste.muitosParaMuitos;

import Modelo.muitosParaMuitos.filme.Ator;
import Modelo.muitosParaMuitos.filme.Filme;
import infra.DAO;

import java.util.Date;

public class NovoFilmeAtor {
    public static void main(String[] args) {
        Filme filmeA = new Filme("Star Wars", 8.7);
        Filme filmeB = new Filme("Fugitivo", 8.9);

        Ator atorA = new Ator("Harrison Ford");
        Ator atorb = new Ator("Carrie Fisher");

        filmeA.adicionarAtor(atorA);
        filmeA.adicionarAtor(atorb);

        filmeB.adicionarAtor(atorA);

        DAO<Filme> dao = new DAO<>();
        dao.incluirAtomico(filmeA);

    }
}
