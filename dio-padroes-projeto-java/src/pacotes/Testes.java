package pacotes;

import pacotes.facade.Facade;
import pacotes.singleton.*;
import pacotes.strategy.*;

public class Testes {

	public static void main(String[] args) {
		
		//Testando singleton
		System.out.println("Testando o pacote singleton: ");
		Singleton testeSingleton = Singleton.getInstancia();
		System.out.println(testeSingleton);
		
		
		//Testando strategy
		System.out.println("\nTestando o pacote strategy: ");
		Comportamento padrao = new ComportamentoPadrao();
		Comportamento ofensivo = new ComportamentoOfensivo();
		Comportamento defensivo = new ComportamentoDefensivo();
		
		Robo robo = new Robo();
		robo.setComportamentoAtual(padrao);
		robo.selecionarComportamento();
		robo.setComportamentoAtual(ofensivo);
		robo.selecionarComportamento();
		robo.setComportamentoAtual(defensivo);
		robo.selecionarComportamento();
		
		//Testando facade
		System.out.println("\nTestando o pacote facade: ");
		Facade facade = new Facade();
		facade.migrarCliente("Luiz", "14385621471");
		
	}

}
