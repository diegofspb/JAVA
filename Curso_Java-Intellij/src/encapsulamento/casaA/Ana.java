package encapsulamento.casaA;

public class Ana {

	@SuppressWarnings("unused") // é utilizado para não ficar mais "reclamando" a variável por não está sendo utilizada
	
	private String segredo = "..."; // segredo por ser 'private' apenas pode ser utilizado pela classe Ana 
	
	String facoDentroDeCasa = "...."; //default ou pacote só é transmitido por herança se as duas classes = mesmo pacote
	
	protected String formaDeFalar = "..."; // são transmitidos por herança
	
	public String todosSabem = "...."; //sempre são transmitidos por herança
}
