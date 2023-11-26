package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;
import pojo.Player;
import dao.playerDao;
import dao.playerDaoImpl;

public class testadd {
	public static void main(String[] args) {
try(Scanner sc = new Scanner(System.in)){
	playerDao dao = new playerDaoImpl();
	System.out.println("String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken ");
	
	Player p = new Player(sc.next(), sc.next(), , sc.nextDouble(),  sc.nextInt());
	System.out.println(dao.addPlayerToTeam(p, sc.nextInt()));
}catch (Exception e) {
	e.printStackTrace();
}
	}	
}
