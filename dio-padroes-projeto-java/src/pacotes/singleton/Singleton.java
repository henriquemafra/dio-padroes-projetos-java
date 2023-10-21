package pacotes.singleton;

public class Singleton {
	
	private static class Instancia{
		
		public static Singleton instancia = new Singleton();
		
	}
	
	private Singleton() {
		
		super();
		
	}
	
	public static Singleton getInstancia() {
		
		return Instancia.instancia;
		
	}
}
