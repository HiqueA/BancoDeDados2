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
		
			String query =	"select t from Trajeto t where longitude = rand()";
			
			em.createQuery(query);
			query.toString();
				
				
				
			
		
	}
	

}
