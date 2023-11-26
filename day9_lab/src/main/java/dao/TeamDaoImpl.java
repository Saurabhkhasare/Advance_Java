package dao;

import pojo.Team;


import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.List;

public class TeamDaoImpl implements Teamdao {

	@Override
	public String addTeamDetails(Team newTeam) {
		//1.open hibernate session from sessionfactory
		Session session = getFactory().getCurrentSession();
		//2.begin a transaction
		Transaction tx = session.beginTransaction();
		try {
			session.save(newTeam);
			//end of try =. success
			tx.commit();//insert query fired
		}catch (RuntimeException e) {
			//rollback the transaction and re throw to the caller
			if(tx != null)
				tx.rollback();
			throw e;
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return "added new Team with ID" +newTeam.getTeamId();
	}

	@Override
	public Team displayTeamDetails(String abbr) {
	Team teams = null;
		String jpql = "select t from Team t where  t.abbreviation=:ab";
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get list of emps
			teams = session.createQuery(jpql, Team.class) // Query<Emp>
					.setParameter("ab", abbr)
					.getSingleResult();

			tx.commit();// session.flush ---> auto dirty chking --> select : same state : NO DMLs --> l1
						// cache
						// destroyed , db cn rets to the pool ,session closed
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return teams;// list of DETACHED
	}

	@Override
	public List<Team> teamDetailsByAge(int age) {
		List<Team> list = null;
		String jpql="select t from Team t where t.maxAge  > :minage";
		//get session from sesssionfactory
		Session session = getFactory().getCurrentSession();
		//Begin a transaction
		Transaction tx = session.beginTransaction();
		try {
			list = session.createQuery(jpql, Team.class)
					.setParameter("minage", age)
					.getResultList();
			//commit
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public Team updatewickBatAvg(int teamid, int wicket, double battingAvg) throws HibernateException {
		Team teams = null;
		String msg="Updating failed";
		String jpql = "select t from Team t where t.teamId=:tid";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class)
					.setParameter("tid", teamid)
					.getSingleResult();
			teams.setMinWicketsTaken(wicket);
			teams.setMinBattingAvg(battingAvg);
			//commit
			tx.commit();
			msg="Updating failed";
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return teams;
	}

}
