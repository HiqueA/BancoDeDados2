import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class MySqlDao implements Persistible<List<Trajeto>>{

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("hibernate");
	EntityManager em = emfactory.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	
	@Override
	public void save(List<Trajeto> t) {
		// TODO Auto-generated method stub
		tx.begin();
		for (Trajeto trajeto: t){
			em.persist(trajeto);
		}
		tx.commit();
		
	}

	@Override
	public void query(List<Trajeto> aleatoryList) {
		// TODO Auto-generated method stub
		
			String query =	"select * from Trajeto where longitude = rand()";
			
			em.createQuery(query);
			query.toString();
				
				
				
				/*"select p from Trajeto p where p.longitude "
						+ "= :longitude and p.latitude = :latitude",
				Trajeto.class);
		
		for (Trajeto trajeto : aleatoryList) {
					
			query.setParameter("longitude", trajeto.getLongitude());
			query.setParameter("latitude", trajeto.getLatitude());

			query.getSingleResult();
			
		}*/
		
	}
	

}
