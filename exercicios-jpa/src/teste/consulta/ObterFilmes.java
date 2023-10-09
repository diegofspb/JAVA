package teste.consulta;

import Modelo.muitosParaMuitos.filme.Ator;
import Modelo.muitosParaMuitos.filme.Filme;
import infra.DAO;

import java.util.List;

public class ObterFilmes {
    public static void main(String[] args) {
        DAO<Filme> dao = new DAO<>(Filme.class);
        List<Filme> filmes = dao.consultar("obterFilmesNotaMaiorQue", "nota", 8.5);

        for(Filme filme: filmes){
            System.out.println("Filme: " + filme.getNome() + " Nota: "+ filme.getNota());
            for (Ator ator: filme.getAtores()) {
                System.out.println("Ator: " + ator.getNome());
            }
        }
    }
}
