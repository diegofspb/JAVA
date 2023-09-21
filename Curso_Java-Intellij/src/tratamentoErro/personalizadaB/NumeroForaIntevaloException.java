package tratamentoErro.personalizadaB;


@SuppressWarnings("serial")
public class NumeroForaIntevaloException extends Exception{
	
	private String nomedoAtributo;
	
	public NumeroForaIntevaloException(String nomedoAtributo) {
		this.nomedoAtributo = nomedoAtributo;
	}
	
	public String getMessage() {
		return String.format("O atributo %s esta fora do intervalo.", nomedoAtributo);
	}

}
