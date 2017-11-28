import java.util.List;

import org.bson.*;

import com.mongodb.*;
import com.mongodb.client.*;

public class MongoDao implements Persistible<List<Trajeto>> {
	MongoClient m = new MongoClient("127.0.0.1", 27017);

	private MongoDatabase db = m.getDatabase("hibernate");
	private MongoCollection<org.bson.Document> colecao = db.getCollection("Trajeto");

	@Override
	public void save(List<Trajeto> t) {
		// TODO Auto-generated method stub
		for (Trajeto trajeto : t) {

			colecao.insertOne(new Document().append("taxiID", trajeto.getTaxiId()).append("DateTime", trajeto.getData())
					.append("longitude", trajeto.getLongitude()).append("latitude", trajeto.getLatitude()));
		}

	}

	@Override
	public void query(List<Trajeto> t) {
		// TODO Auto-generated method stub
		FindIterable<Document> iterable = null;
		MongoCollection<Document> colecao = db.getCollection("TaxiTrajectory");

		for (Trajeto trajeto : t) {
			iterable = colecao.find(new Document().append("longitude", trajeto.getLongitude()).append("latitude",
					trajeto.getLatitude()));

		}
	}
}
