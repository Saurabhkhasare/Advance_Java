package dao;

import java.sql.SQLException;

import pojo.Player;

public interface playerDao {
    
	// add a method to add player to the team
	String addPlayerToTeam(Player newPlayer, int teamid)throws SQLException;
}
