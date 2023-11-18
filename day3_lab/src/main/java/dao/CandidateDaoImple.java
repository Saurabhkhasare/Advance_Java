package dao;

import static utils.DBUtils.closeConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;
import utils.DBUtils;

public class CandidateDaoImple implements CandidateDao {
	private Connection connection;
	private PreparedStatement pst1,pst2;
	

	public CandidateDaoImple() throws SQLException {
		
		connection = DBUtils.openConnection();
		pst1 = connection.prepareStatement("select * from candidates");
		pst2 = connection.prepareStatement("update candidates set votes=votes+1 where id =?");
		System.out.println("candidate dao created!");
	}


	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		// TODO Auto-generated method stub
		List<Candidate> candidateList=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				candidateList.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
		}//JVM : rst.close()
		return candidateList;
		
	}
	
	@Override
	public void incrementVote(int uId) throws SQLException {
		pst2.setInt(1, uId);
	
		int rowsUpdated = pst2.executeUpdate();
		
	    if(rowsUpdated > 0)
	    	System.out.println("candidate votes updated");
	    else
	    	System.out.println("candidate not registerd");
		
	}

	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("candidate  dao cleaned up !");
	}

}





