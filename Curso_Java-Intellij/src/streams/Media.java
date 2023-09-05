package streams;

public class Media {
	
	private double total;
	private int quantidade;
	
	//essa forma de usar o nome da classe para criar um função + nome é chamado de método Builder e permite o encadeamento
	// quando o objeto for criado em outro local, no final deste artigo tem a explicações disso
	// o nome 'Media' está presente na delaração 'adicionar' porque sim retorna uma instância de Media.
	public Media adicionar(double valor) {
		total += valor;
		quantidade++;
		return this;
	}	
	// o nome 'Media' não está presente na declaração getValor porque não retorna uma instância de Media.
	public double getValor() {
		return total / quantidade;
	}
	/*
A decisão de usar o nome da classe na declaração do método depende de como o método se comporta e qual é o tipo de retorno esperado.

-> Se o método opera na instância da própria classe e retorna uma instância dessa classe (como no caso do método adicionar), 
você deve usar o nome da classe na declaração do método.
-> Se o método opera na instância da própria classe, mas retorna apenas um valor ou não retorna nada (void), 
você não precisa incluir o nome da classe na declaração do método.*/
	
	public static Media combinar(Media m1, Media m2) {
		Media resultante = new Media();
		resultante.total = m1.total + m2.total;
		resultante.quantidade = m1.quantidade + m2.quantidade;
		return resultante;
	}
}

/*
 Exmplicando o Método Builder

		public Media adicionar(double valor) {
		    total += valor;
		    quantidade++;
		    return this;
		}

Nesta função, temos a declaração de retorno `return this;`. 
O `this` é uma referência para o próprio objeto atual em que o método está sendo executado. 
Quando uma função retorna `this`, ela está retornando uma 
referência para o próprio objeto (instância da classe `Media` nesse caso) em que o método foi chamado.

Vamos considerar um exemplo de como isso pode ser usado:
Media media = new Media();
media.adicionar(10.0).adicionar(20.0).adicionar(30.0);

Nesse exemplo, primeiro criamos uma instância da classe `Media` chamada `media`. 
Em seguida, chamamos três vezes o método `adicionar()` na mesma linha, cada vez passando um 
valor diferente (10.0, 20.0 e 30.0). O que acontece é o seguinte:

1.  Na primeira chamada de `adicionar(10.0)`, o valor 10.0 é adicionado ao total e a quantidade é incrementada em 1. 
	Em seguida, o método `adicionar()` retorna `this`, ou seja, a referência para o objeto `media` original.
2.  Com a referência ao objeto `media` retornada na primeira chamada, podemos chamar novamente o 
	método `adicionar(20.0)`. O valor 20.0 é adicionado ao total, a quantidade é incrementada em 1 e, 
	novamente, o método `adicionar()` retorna `this`, ou seja, a referência para o objeto `media`.
3. Agora, com a referência ao objeto `media` retornada na segunda chamada, 
chamamos o método `adicionar(30.0)`. O valor 30.0 é adicionado ao total, a quantidade é incrementada em 1 e, 
mais uma vez, o método `adicionar()` retorna `this`, ou seja, a referência para o objeto `media`.

O resultado desse encadeamento é que os três valores foram adicionados ao objeto `media`, e você pode 
continuar encadeando mais chamadas de métodos da classe `Media` se necessário.

Isso é conhecido como padrão de projeto "Builder". Ele permite criar uma interface fluente, onde 
você pode chamar vários métodos sequencialmente em um objeto sem precisar sempre repetir o nome do objeto em 
cada chamada de método. É uma abordagem que facilita a legibilidade do código quando você deseja realizar 
várias operações em sequência no mesmo objeto.
 */
