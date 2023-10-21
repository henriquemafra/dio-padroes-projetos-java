package subsistema1;

public class Cadastro {
	
	private Cadastro() {
		
		super();
		
	}
	
	public static void gravarClientes(String nome, String cep, String cidade, String estado) {
		
		System.out.println("Cliente salvo. Dados do cliente: ");
		System.out.println(nome);
		System.out.println(cep);
		System.out.println(cidade);
		System.out.println(estado);
		
	}

}
