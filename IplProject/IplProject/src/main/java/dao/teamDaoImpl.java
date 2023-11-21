package dao;

import static DButils.DBUtils.getCn;
import static DButils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DButils.DBUtils;
import pojo.Team;

public class teamDaoImpl implements teamDao {
    private Connection cn;
    private PreparedStatement pst1,pst2;
    
    public teamDaoImpl() throws SQLException {
    	
    	cn=DBUtils.openConnection();
    	
    	pst1=cn.prepareStatement("select abbrevation from teams" );
    	pst2=cn.prepareStatement("select *from teams where abbrevation=?");
    }
	
	@Override
	public List<String> getTeamsAbbreviation() throws SQLException {
		List<String> abbreviations = new ArrayList<>();
		
		try(ResultSet rst=pst1.executeQuery()){
			while(rst.next())
				abbreviations.add(rst.getString(1));
			
		}
		return abbreviations;
	}

	@Override
	public Team getTeamDetails(String abbreviations) throws SQLException {
		
		pst2.setString(1, abbreviations);
		try(ResultSet rst=pst2.executeQuery()){
			if(rst.next())
				return new Team(rst.getInt(1), rst.getString(2), abbreviations,rst.getString(4) , rst.getInt(5), rst.getDouble(6), rst.getInt(7));
			
		}
		return null;
	}
	
public void cleanup() throws SQLException {
		
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		System.out.println("team dao cleaned up");
		
	}
 
}
