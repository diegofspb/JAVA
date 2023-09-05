package colecoes;

import java.util.HashMap;
import java.util.Map;

public class Mapa {

	public static void main(String[] args) {
		Map<Integer, String> usuarios = new HashMap<Integer, String>();
		/*
		 * Interessante que para adicionar um elemento no método Map, foi criado o nome Put
		 * pois se colocar adicionar não seria correto, uma vez que vc para adiciconar um
		 * elemento, tem que informar a chave = valor, então se colocar a mesma chave e já tiver um valor
		 * automaticamente o valor será alterado para o novo valor que vc digitar
		 * */
		usuarios.put(1, "Roberto");
		usuarios.put(2, "Maria");
		usuarios.put(3, "Joao");
		usuarios.put(4, "Tiago");
		
		System.out.println(usuarios);
		// exibindo só as chaves
		System.out.println(usuarios.keySet());
		// exibindo só os valores
		System.out.println(usuarios.values());
		// pesquisando uma chave especifica = resposta booleana
		System.out.println(usuarios.containsKey(20));
		// pesquisando um valor específico
		System.out.println(usuarios.containsValue("Maria"));
		// exibindo o valor de uma chave
		System.out.println(usuarios.get(2));
	}
}
