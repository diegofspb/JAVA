package teste.consulta;

import Modelo.consulta.NotaFilme;
import infra.DAO;

public class ObterMediaFilme {
    public static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");

        System.out.println(nota.getMedia());

        dao.fechar();
    }
}
