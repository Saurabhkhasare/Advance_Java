package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.playerDaoImpl;
import dao.teamDaoImpl;
import pojo.Player;
import pojo.Team;

/**
 * Servlet implementation class teamValidate
 */
@WebServlet(value = "/teamValidate")
public class teamValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Player players = new Player();
	private Team teams = new Team();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.set content
		response.setContentType("text/html");
		// 2.printwriter
		try (PrintWriter pw = response.getWriter()) {
			pw.print("hi");
			// 3.get session
			HttpSession session = request.getSession();

			// 4.get instance of daos
			teamDaoImpl teamdao = (teamDaoImpl) session.getAttribute("team_dao");// string converted to object ---
																					// string="team_dao"
			playerDaoImpl playerdao = (playerDaoImpl) session.getAttribute("player_dao");

			teams = teamdao.getTeamDetails(request.getParameter("abbrevation"));
			players.setFirstname(request.getParameter("fname"));
			players.setLastname(request.getParameter("lname"));
			players.setDob(Date.valueOf(request.getParameter("dob")));
			players.setBattingAvg(Integer.valueOf(request.getParameter("battingAvg")));
			players.setWicketTaken(Integer.valueOf(request.getParameter("wickets")));

			Period pr = Period.between(LocalDate.now(), players.getDob().toLocalDate());

			int age = pr.getYears();

			if (age > teams.getMaxAge()) {
				pw.print("you are not eligible ");

			} else if (players.getBattingAvg() < teams.getMinBattingAvg()) {
				pw.print("Batting avg is less ");
			} else if (players.getWicketTaken() < teams.getMinWicketsTaken()) {
				pw.print("wickets taken are less");

			} else {
				String res = playerdao.addPlayerToTeam(players, teams.getTeamid());
				pw.print(res);
			}

		} catch (Exception e) {
			throw new ServletException("err in do-get" + getClass(), e);
		}
	}

}
