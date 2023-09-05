package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Supplierr { 

	public static void main(String[] args) {
		// Supplier não exige nenhum parâmetro
		Supplier< List<String> > umaLista = ()-> Arrays.asList("ana", "Bia", "Lia");
		
		System.out.println(umaLista.get());
	}
}
