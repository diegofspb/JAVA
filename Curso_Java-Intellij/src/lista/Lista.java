package lista;

import java.util.ArrayList;

public class Lista {

    public static void main(String[] args) {

        ArrayList<Pessoa> pessoa = new ArrayList<>();
        // aqui eu crio uma lista de nome 'pessoa' que só aceita objeto <Pessoa>

        Pessoa p1 = new Pessoa("Maria");
        pessoa.add(p1);

        // ou de forma mais simplificada:
        pessoa.add(new Pessoa("João"));
        pessoa.add(new Pessoa("Jaspion"));
        pessoa.add(new Pessoa("Jiraya"));

        for(Pessoa p: pessoa){
            System.out.println(p);
            // se chamar o método acima System.out.println(p.getNome()); ele não vai executar o toString()
        }
        // agora pegando um indice específico:
        System.out.println("Pegando um nome através do indice: " + pessoa.get(2).getNome());
        // removendo um nome da ista
        pessoa.remove(2);    // aqui remove o nome da posição 2 que é o Jaspion

        for(Pessoa p: pessoa){
            System.out.println(p);
        }
        //Pesquisa dentro da lista com retorno booleano
        System.out.println(pessoa.contains(new Pessoa("Jiraya")));
    }
}
