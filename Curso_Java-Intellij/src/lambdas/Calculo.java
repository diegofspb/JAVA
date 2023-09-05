package lambdas;

@FunctionalInterface
public interface Calculo {
	
	// toda 'interface' é do tipo public e abstrata
	// Interface Funcional só pode conter 1 MÉTODO ABSTRATO, por isso @FunctionalInterface
	// poderá ter outros métodos como exemplo o método 'default' ou 'static'
	
	double executar (double a, double b);

}
