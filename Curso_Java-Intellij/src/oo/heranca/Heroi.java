package oo.heranca;

public class Heroi extends Jogador{

	// o extendes permitiu que Heroi recebesse tudo que tem na classe Jogador
	// a ideia foi criar um jogador tipo Heroi que tenha mais força que um jogador comum	
	// teoria usando 'super.' que seria quando uma classe filha chama o método da classe pai
	
	boolean atacar(Jogador oponente) {
		boolean ataque1 = super.atacar(oponente);
		boolean ataque2 = super.atacar(oponente);
		boolean ataque3 = super.atacar(oponente);
		return ataque1 || ataque2 || ataque3;
	}
}
