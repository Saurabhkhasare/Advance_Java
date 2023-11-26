package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import dao.Teamdao;

public class TestWicketBattingAvg {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			SessionFactory sf = getFactory();
			System.out.println("Enter the teamid,wickets,battingAvg:");
		
			Teamdao tdao = new TeamDaoImpl();
			System.out.println(tdao.updatewickBatAvg(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
				
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}
