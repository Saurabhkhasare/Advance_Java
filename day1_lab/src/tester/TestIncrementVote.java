package tester;

import java.util.Scanner;

import dao.CandidateDaoImple;

public class TestIncrementVote {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			CandidateDaoImple dao= new CandidateDaoImple();
			System.out.println("Enter id to update votes");
			int id = sc.nextInt();
			dao.incrementVote(id);
			
			dao.cleanUp();

	}catch (Exception e) {
		e.printStackTrace();
	}

}
}
