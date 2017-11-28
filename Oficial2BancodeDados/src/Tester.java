import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Cronometro c = new Cronometro();
		LeitorDeArquivos leitor = new LeitorDeArquivos();
		List<Trajeto> lista = new ArrayList();
		MySqlDao myDAO = new MySqlDao();
		MongoDao mongoDAO= new MongoDao();
		
		
		
		
		
		System.out.println("Começou");
		String[] arquivos = leitor.getNomes();
		for (int i = 0; i < arquivos.length; i++) {
			try {
				lista.addAll(leitor.leArquivo(arquivos[i]));
				System.out.println(i);
			} catch (FileNotFoundException e) {
				//  Auto-generated catch block
				e.printStackTrace();
			}
		}	
		c.inicia();
		//myDAO.save(lista);
		myDAO.query(lista);
		c.para();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Tempo em Milissegundos: "+c.getMilisegundos());
		System.out.println("Tempo em segundos: "+c.getSegundos());
		System.out.println("Tempo em minutos: "+c.getMinutos());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		c.inicia();
		//mongoDAO.save(lista);
		mongoDAO.query(lista);
		c.para();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Tempo em Milissegundos: "+c.getMilisegundos());
		System.out.println("Tempo em segundos: "+c.getSegundos());
		System.out.println("Tempo em minutos: "+c.getMinutos());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
	}

}
