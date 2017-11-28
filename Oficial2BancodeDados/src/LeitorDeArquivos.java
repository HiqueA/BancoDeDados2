import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LeitorDeArquivos {
	DateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String[] getNomes() {
		File diretorio = new File("Arquivos");

		File[] arquivos = diretorio.listFiles();
		String[] nomes = new String[arquivos.length];
		for (int i = 0; i < arquivos.length; i++) {
			nomes[i] = arquivos[i].getAbsolutePath();

		}

		return nomes;

	}

	public List<Trajeto> leArquivo(String nome) throws FileNotFoundException, ParseException {
		List<Trajeto> trajetos = new ArrayList<>();

		Scanner scanner = new Scanner(new FileReader(nome)).useDelimiter("[,\n]");
		while (scanner.hasNext()) {
			Long id = scanner.nextLong();
			String stringData = scanner.next();

			Date data = dataFormatada.parse(stringData);

			String stringLongitude = scanner.next();
			Double longitude = Double.parseDouble(stringLongitude);
			String stringLatitude = scanner.next();
			Double latitude = Double.parseDouble(stringLatitude);
			trajetos.add(new Trajeto(id, data, longitude, latitude));

		}

		scanner.close();
		return trajetos;

	}
}
