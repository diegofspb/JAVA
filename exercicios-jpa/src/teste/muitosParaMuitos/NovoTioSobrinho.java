package teste.muitosParaMuitos;

import Modelo.muitosParaMuitos.familia.Sobrinho;
import Modelo.muitosParaMuitos.familia.Tio;
import infra.DAO;

public class NovoTioSobrinho {
    public static void main(String[] args) {
        Tio tia1 = new Tio("Maria");
        Tio tio2 = new Tio("João");

        Sobrinho sobrinho1 = new Sobrinho("Davi");
        Sobrinho sobrinha2 = new Sobrinho("Ana");

        // como esta relação é Bidirecional, visto ser obrigatório a criação de uma nova tabela acessória para uma relação muitos x muitos
        // aqui é necessário também deixar especificado como ficará a relação BIdirecional

        //exemplo:

        // tia1 é tia do sobrinho1
        tia1.getSobrinhos().add(sobrinho1);
        // sobrinho1 é sobrinho da tia1
        sobrinho1.getTios().add(tia1);

        tia1.getSobrinhos().add(sobrinha2);
        sobrinha2.getTios().add(tia1);

        tio2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio2);

        tio2.getSobrinhos().add(sobrinha2);
        sobrinha2.getTios().add(tio2);

        DAO<Object> dao = new DAO<>();

        dao.abrirT()
                .incluir(tia1)
                .incluir(tio2)
                .incluir(sobrinho1)
                .incluir(sobrinha2)
                .fecharT()
                .fechar();





    }
}
