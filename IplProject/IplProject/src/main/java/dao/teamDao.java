package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Team;

public interface teamDao {
	
	// add a method to get abbreviations of all teams
	List<String> getTeamsAbbreviation()throws SQLException;
	
	// add a method to get team details in detail
	
	Team getTeamDetails(String abbreviations)throws SQLException;
	
}
