package teste.umPraUm;

import Modelo.umPraUm.Assento;
import Modelo.umPraUm.Cliente;
import infra.DAO;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        // Construtor de assento é apemas 1 String
        // Primeiro se criou o Assento para depois poder criar um Cliente com (nome + assento)
        Assento assento = new Assento("C31");
        // Construtor de 'Cliente' é (String nome, ASSENTO)
        Cliente cliente = new Cliente("João", assento);

        DAO<Object> dao = new DAO<>(); // aqui foi criado da forma mais genérica possível

        dao.abrirT()
                .incluir(assento) // métodos BUILD, permite concatenar e executar em fila
                .incluir(cliente)
                .fecharT()
                .fechar();
    }
}
