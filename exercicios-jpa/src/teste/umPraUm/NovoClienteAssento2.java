package teste.umPraUm;

import Modelo.umPraUm.Assento;
import Modelo.umPraUm.Cliente;
import infra.DAO;

public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("RODRIGO", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);
        dao.incluirAtomico(cliente);
        // se não fosse feito alteração na tabela Cliente em FK assento ao incluir @OneToOne (cascade = CascadeType.PERSIST), ele iria apenas tentar adicionar
        // o cliente e daria erro ao notar que existe uma fk não incluida
        // porém ao utilizar @OneToOne (cascade = CascadeType.PERSIST), o Hibernate buscará qualquer dependencia e tentará resolver

        dao.fechar();
    }
}
