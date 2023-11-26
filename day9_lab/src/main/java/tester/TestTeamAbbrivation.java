package tester;

import java.util.Scanner;
import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import dao.Teamdao;
import pojo.Team;

public class TestTeamAbbrivation {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			SessionFactory sf = getFactory();
			System.out.println("Enter the team abbrevation:");
			String abb = sc.next();
			Teamdao tdao = new TeamDaoImpl();
			System.out.println(tdao.displayTeamDetails(abb));
				
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	

}
