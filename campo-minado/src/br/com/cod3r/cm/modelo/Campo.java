package br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.cod3r.cm.excecao.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;	
	private boolean aberto = false; //não precisa botar false,
	private boolean minado; // não coloquei os outros false, porque o padrão já é false
	private boolean marcado;
	// a classe abaixo está private para que nada de fora desta classe
	// possa alterar quem serão os vizinhos = os quadrados vizinhos
	private List<Campo> vizinhos = new ArrayList<Campo>(); 
	
	Campo(int linha, int coluna){  //Método construtor
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha; // ou seja, x diferente do x da outra posição
		boolean colunaDiferente = coluna != vizinho.coluna; // ou seja, y diferente do y da outra posição
		boolean diagonal = linhaDiferente && colunaDiferente;
		//Math.abs() deixa o valor absoluto, exemplo -1 fica 1
		int deltaLinha = Math.abs(linha - vizinho.linha); // diferença entre as linhas 
		int deltaColuna = Math.abs(coluna - vizinho.coluna); // diferença entre as colunas		
// no meu entendimento apenas o deltaGeral resolveria, pois resultado 1 = vizinho não diagonal e 2 = diagonal
		int deltaGeral = deltaColuna + deltaLinha;
		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if(deltaGeral == 2 && diagonal){
			vizinhos.add(vizinho);
			return true;
		}else {
			return false;
		}
	}
	
	void alternarMarcacao() { //é aquela bandeira de marcação no campo minado informado que ali tem bomba
		if(!aberto) {
			marcado = !marcado; // ou seja, se clicar ele marca, se clicar de novo ele desmarca
		}
	}
/* esta função abrir é quando o usuário clicar na tela vai abrir vários espaços até chegar na bomba
	se for uma bomba o código entra na exceção e explode = acaba o jogo, porém está função abrir
	também prevê que caso usuário clice que novo e já esteja aberto então não vai fazer nada
	por isso tem o if que só permite abrir novamente se não tiver já aberto if(!aberto)
	como também não pode estar marcado, lembrando que marcado é quando vc clica, a area expandi
	e para na lateral das bombas e vc coloca um marcador evitando que você possa clicar na bomba
	e explodir, por isso  o if tem estas duas condições internas	
*/			
	boolean abrir() {
		if(!aberto && !marcado) { // se o campo tiver não aberto(!aberto) e não marcado(!marcado) então...
			aberto = true;
			if(minado) { // se tiver minado = explode, então...
				 throw new ExplosaoException(); //throw é usada para lançar uma exceção / problema
				 //esta exceção esta na classe criada ExplosaoException.java 
				 // nem sempre exceção = erro
				 // aqui a exceção é quando o usário clicar em uma bomba
			}
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		}else {
			return false;			
		}
	}
	boolean vizinhancaSegura() {
		// none = nenhum, sentão noneMatch = nenhuma bomba ?
		return vizinhos.stream().noneMatch( v -> v.minado );
	}
	
	void minar() {
		minado = true;
	}
	
	public boolean isMinado() {
		return minado;
	}
	
	public boolean isMarcado() {
		return marcado;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	boolean isAberto() {		
		return aberto;
	}
	boolean isFechado() {		
		return !isAberto();
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	public String toString() {
		if(marcado) {
			return "x";		
		}else if(aberto && minado) {
			return "*";
		}else if(aberto && minasNaVizinhanca()>0) {
			return Long.toString(minasNaVizinhanca());
		}else if(aberto) {
			return " ";
		}else {
			return "?";
		}
	}
	
	
}
