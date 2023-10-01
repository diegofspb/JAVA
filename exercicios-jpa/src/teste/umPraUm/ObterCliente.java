package teste.umPraUm;

import Modelo.umPraUm.Cliente;
import infra.DAO;

public class ObterCliente {
    public static void main(String[] args) {
        DAO<Cliente> dao = new DAO<>(Cliente.class);

        Cliente cliente = dao.obterPorId(1L);
        System.out.println(cliente.getAssento().getNome());
        /*
            interpretando o código acima:
                cliente pega getAssento()
                getAssento() é um método dentro da classe cliente que tem relação OneToOne com Assento
                quando uma classe tem relação com a outra através do ORM, então ela pode ter acesso de tudo da outra classe
                'cliente.getAssento()' quer dizer que cliente acessou Assento
                'cliente.getAssento().getNome()' quer dizen que cliente acessou a classe Assento e agora pegou o nome do assento através do método getNome() de Assento
         */
        System.out.println(cliente.getAssento().getCliente().getNome());
        /*
            cliente -> assento -> dentro da classe Assento assessou de volta a classe cliente 'getCliente()' -> dentro de cliente acessou o nome do cliente 'getNome()'
        */

        dao.fechar();
    }
}
