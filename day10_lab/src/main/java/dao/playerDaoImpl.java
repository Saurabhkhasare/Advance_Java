package dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import java.sql.SQLException;

import pojo.BaseEntity;
import pojo.Player;
import pojo.Team;

public class playerDaoImpl implements playerDao{

	@Override
	public String addPlayerToTeam(Player newPlayer, int teamid) throws SQLException {
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		// L1 cache is created.
		try {
			//3.get team from its id
			Team teams = session.get(Team.class, teamid);
			if(teams != null)
			{
				teams.addPlayer(newPlayer);
				session.persist(newPlayer);
			}
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();// no auto dirty checking --- session is auto closed =>
			// L1 cache is destroyed n pooled out db cn rets to the pool
			// re throw the exc to the caller
			throw e;
		}
		return  "Emp details added , with ID ";
	}
	
}