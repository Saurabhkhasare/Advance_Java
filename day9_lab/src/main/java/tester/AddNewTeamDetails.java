package tester;
import static utils.HibernateUtils.getFactory;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import dao.Teamdao;
import pojo.Team;

public class AddNewTeamDetails {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			SessionFactory sf = getFactory();
			System.out.println("hibernate booted successfully..."+sf);
			Teamdao dao = new TeamDaoImpl();
			System.out.println("Enter new Team Details:  name, abbreviation, owner,  maxAge,  minBattingAvg , minWicketsTaken");
			Team newTeam = new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			System.out.println(dao.addTeamDetails(newTeam));
		}//sf.close() --> Data Base connection pool cleanded up...
		catch (Exception e) {
		e.printStackTrace();
		}
	}

}
