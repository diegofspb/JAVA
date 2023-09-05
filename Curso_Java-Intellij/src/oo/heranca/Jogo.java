package oo.heranca;
public class Jogo {
	public static void main(String[] args) {		
		Jogador monstro = new Jogador();		
		monstro.x = 10;
		monstro.y = 10;
		
		Heroi heroi = new Heroi();	 // Porque na classe Heroi tem 'Heroi extends Jogador'
		heroi.x = 10;
		heroi.y = 11; // esse 11 faz com que um jogador fique ao lado do outro, permitindo o ataque	
		
		System.out.println("Monstro tem: " + monstro.vida);
		System.out.println("Heroi tem: = " + heroi.vida);	
		
		monstro.atacar(heroi); //na classe Jogador, a função atacar está assim: boolean atacar(Jogador oponente)
		heroi.atacar(monstro); // pois apenas um jogador pode atacar o outro
		// ***importante: a classe Heroi herdou a classe Jogador e reaproveitou o função ataque para executar 3 vezes seguidas
		
		System.out.println("Monstro tem: " + monstro.vida);
		System.out.println("Heroi tem: = " + heroi.vida);
		
		monstro.andar(Direcao.NORTE); // ISSo é para mostrar que quando um dos dois andar e ficar
		// longe do alcance então não haverá mais ataque
		System.out.println("Monstro fora do alcance: " + monstro.vida);
		System.out.println("Heroi tem: = " + heroi.vida);
	}
}
