package dao;

import static DButils.DBUtils.getCn;
import static DButils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DButils.DBUtils;
import pojo.Player;

public class playerDaoImpl implements playerDao {
    private Connection cn;
    private PreparedStatement pst1;
    
    public playerDaoImpl() throws SQLException {
		
		cn=DBUtils.openConnection();
		pst1=cn.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		System.out.println("Player dao is created");
		
	}
	
	
	@Override
	public String addPlayerToTeam(Player newPlayer, int teamid) throws SQLException {
		// set IN params
//first_name,last_name, dob,batting_avg,wickets_taken,team_id
		pst1.setString(1,newPlayer.getFirstname());
		pst1.setString(2,newPlayer.getLastname());
		pst1.setDate(3,newPlayer.getDob());
		pst1.setDouble(4,newPlayer.getBattingAvg());
		pst1.setInt(5,newPlayer.getWicketTaken());
		pst1.setInt(6, teamid);
		// update rows
		
		int rows=pst1.executeUpdate();
		if(rows == 1)
		  return"new player is added to team";
		return "no player is added!!!!!";
	}
	
	public void cleanup() throws SQLException {
		
		if(pst1 != null)
			pst1.close();
	}

}
