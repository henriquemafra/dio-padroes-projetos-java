package pacotes.facade;

import subsistema1.Cadastro;
import subsistema2.CepApi;

public class Facade {
	
	public void migrarCliente(String nome, String cep) {
		
		String cidade = CepApi.getInstancia().recuperarCidade(cep);
		String estado = CepApi.getInstancia().recuperarEstado(cep);
		
		Cadastro.gravarClientes(nome, cep, cidade, estado);
		
	}
	
}
