package tester;

import java.util.Scanner;

import dao.CandidateDaoImple;

public class TestListAllCandidates {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance
			CandidateDaoImple dao = new CandidateDaoImple();
			System.out.println("All candidates");
			dao.getAllCandidates().forEach(System.out::println);
				//clean up
			dao.cleanUp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
