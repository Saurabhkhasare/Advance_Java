package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import dao.Teamdao;

public class TestListByAge {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			SessionFactory sf = getFactory();
			System.out.println("Enter the age:");
			int age= sc.nextInt();
			Teamdao tdao = new TeamDaoImpl();
			System.out.println(tdao.teamDetailsByAge(age));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
