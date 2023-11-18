package tester;

import java.util.List;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.User;

public class AuthanticationTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter mail and password");
			User users = dao.getAuthantication(sc.next(), sc.next());
			System.out.println(" Users Details ");
			System.out.println(users);

	}catch (Exception e) {
		e.printStackTrace();
	}
	
}
}