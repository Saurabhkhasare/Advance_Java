package dao;

import pojo.Team;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class TeamDaoImpl implements Teamdao {

	@Override
	public String addTeamDetails(Team newTeam) {
		//1.open hibernate session from sessionfactory
		Session session = getFactory().openSession();
		//2.begin a transaction
		Transaction tx = session.beginTransaction();
		try {
			session.save(newTeam);
			//end of try =. success
			tx.commit();
		}catch (RuntimeException e) {
			//rollback the transaction and re throw to the caller
			if(tx != null)
				tx.rollback();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return "added new Team with ID" +newTeam.getTeamId();
	}

}
