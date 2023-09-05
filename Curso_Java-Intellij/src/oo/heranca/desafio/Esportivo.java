package oo.heranca.desafio;

public interface Esportivo {

	/*
	 * a diferença entre classe e interface é que a interface:
	 *  - Possui métodos, porém são métodos vazios;
	 *  - Interface apenas informa a necessidade de se criar o conteúdo quando uma classe herda o método da interface;
	 *  - Uma classe só herda de uma classe, porém uma classe pode herdar de várias interfaces;
	 *  - 
	 * */
	
	void ligarTurbo();
	void desligarTurbo();
}
