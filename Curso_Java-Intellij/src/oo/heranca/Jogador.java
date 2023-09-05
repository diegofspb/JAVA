package oo.heranca;
public class Jogador {	
	int vida = 100;
	int x; //posição do jogador
	int y;	
	boolean atacar(Jogador oponente) {	//o parâmetro foi Jogador, pois só um jogador pode atacar o outro, ou seja
		// o ataque apenas poderá ser realizado por uma variável instanciada com Jogador ou uma classe 'com extends';
		//diff ou delta são funções que calculam a diferença entre 2 variáveis, 
		// no caso abaixo so foi aproveitado o nome mesmo, mas a variável não faz nada;		
		int deltax = Math.abs(x - oponente.x);  // para entender estas posições imagine um L
		int deltay = Math.abs(y - oponente.y); // parecido com os gráficos de física eixos x e y;
		//Math.abs(arredonda para mais o que tiver aqui);		
		// a ideia abaixo é dizer que se eles estiverem um ao lado do outro podem atacar;
		if(deltax == 0 && deltay==1){
			oponente.vida -= 10;
		}else if(deltax == 1 && deltay == 0) {
			oponente.vida -=10;
			return true;			
		}else {
			return false;
		}		
		return true;
	}	
	boolean andar(Direcao direcao) {		
		switch(direcao) {		
		case NORTE:
			y--;
			break;		
		case LESTE:
			x++;
			break;		
		case SUL:
			y++;
			break;
		case OESTE:
			x--;
			break;
		}		
		return true;
	}
}
