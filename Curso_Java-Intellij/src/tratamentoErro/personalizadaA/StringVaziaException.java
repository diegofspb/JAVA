package tratamentoErro.personalizadaA;


@SuppressWarnings("serial")
public class StringVaziaException extends RuntimeException{
	
	private String nomedoAtributo;
	
	public StringVaziaException(String nomedoAtributo) {
		this.nomedoAtributo = nomedoAtributo;
	}
	
	public String getMessage() {
		return String.format("O atributo %s esta vazio", nomedoAtributo);
	}

}
