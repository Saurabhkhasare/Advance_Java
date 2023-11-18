package tester;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import dao.CandidateDao;
import dao.CandidateDaoImple;
import dao.UserDaoImpl;
import pojos.Candidate;
import pojos.User;

public class TestLayeredApp1 {
public static void main(String[] args) {
	try (Scanner sc = new Scanner(System.in)){
		CandidateDaoImple dao= new CandidateDaoImple();
		List<Candidate> candidatelist= dao.getAllCandidates();
		for (Candidate candidate : candidatelist) {
			System.out.println(candidate);
		}
				

		
		UserDaoImpl d= new UserDaoImpl();
		d.updateVotingStatus(2);
		
		dao.incrementVote(3);
		
		dao.cleanUp();
		
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
}
