

public class Cronometro {
	long tempoInicio;
	long tempoFim;
	long tempoTotal;
	public void inicia(){
		tempoInicio = System.currentTimeMillis();
	}
	public void para(){
		tempoFim = System.currentTimeMillis();
		tempoTotal = tempoFim-tempoInicio;
		
		
	}
	
	public long getMilisegundos(){
		return tempoTotal;
	}
	public long getSegundos(){
		return tempoTotal/1000;
	}
	
	public long getMinutos(){
		return tempoTotal/60000;
	}
	
	
	
	
	
	
 
 
}
