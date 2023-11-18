package tester;

import java.util.Scanner;

import dao.CandidateDaoImple;
import dao.UserDaoImpl;
import pojos.User;

public class TestAuthantication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			CandidateDaoImple dao= new CandidateDaoImple();
			
			System.out.println("enter email and password :");
			String email=sc.next();
			String pass=sc.next();
			UserDaoImpl d= new UserDaoImpl();
			User u =d.authenticateUser(email, pass);
			if (u!= null) {
				System.out.println(u);
			}
			else {
				System.out.println("invalid ");
			}
			
			dao.cleanUp();
			
	}catch (Exception e) {
		e.printStackTrace();
	}

}
}