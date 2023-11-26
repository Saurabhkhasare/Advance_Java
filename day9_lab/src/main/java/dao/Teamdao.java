package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Team;

public interface Teamdao {
//add a method to insert new team details
	String addTeamDetails(Team newTeam)throws HibernateException;
	
	//add a method to display team details by team abbrevation
	Team displayTeamDetails(String abbr)throws HibernateException;
	
	///Find out the teams , who need players with max age of the player> specified age
	List<Team> teamDetailsByAge(int age)throws HibernateException;
	
	//Update the team's no of wickets taken n batting avg Team will be specified by it's team id.
	Team updatewickBatAvg(int teamid,int wicket,double battingAvg) throws HibernateException;
}
