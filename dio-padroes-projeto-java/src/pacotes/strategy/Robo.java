package pacotes.strategy;

public class Robo {
	
	private Comportamento comportamentoAtual;

	public void setComportamentoAtual(Comportamento comportamentoAtual) {
		
		this.comportamentoAtual = comportamentoAtual;
		
	}
	
	public void selecionarComportamento () {
		
		comportamentoAtual.selecionarComportamento();
		
	}
	
}