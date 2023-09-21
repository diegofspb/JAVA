package tratamentoErro.personalizadaA;


@SuppressWarnings("serial")
public class NumeroForaIntevaloException extends RuntimeException{
	
	private String nomedoAtributo;
	
	public NumeroForaIntevaloException(String nomedoAtributo) {
		this.nomedoAtributo = nomedoAtributo;
	}
	
	public String getMessage() {
		return String.format("O atributo %s esta fora do intervalo.", nomedoAtributo);
	}

}
