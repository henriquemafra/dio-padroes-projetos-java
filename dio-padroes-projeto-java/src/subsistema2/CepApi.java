package subsistema2;

public class CepApi {
	
	private static CepApi instancia = new CepApi();
	
	private CepApi() {
		
		super();
		
	}
	
	public static CepApi getInstancia() {
		
		return instancia;
		
	}
	
	public String recuperarCidade(String cep) {
		
		return "Niterói";
		
	}
	
	public String recuperarEstado(String cep) {
		
		return "RJ";
		
	}

}
