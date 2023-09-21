package tratamentoErro.personalizadaB;


@SuppressWarnings("serial")
public class StringVaziaException extends Exception{
	
	private String nomedoAtributo;
	
	public StringVaziaException(String nomedoAtributo) {
		this.nomedoAtributo = nomedoAtributo;
	}
	
	public String getMessage() {
		return String.format("O atributo %s esta vazio", nomedoAtributo);
	}

}
