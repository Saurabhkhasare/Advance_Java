package pages;

import static DButils.DBUtils.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.playerDaoImpl;
import dao.teamDaoImpl;


/**
 * Servlet implementation class addPlayer
 */
@WebServlet("/addPlayer")
public class addPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private teamDaoImpl teamDao;
      private playerDaoImpl playerDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			teamDao=new teamDaoImpl();
			playerDao=new playerDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in do-get" + getClass(), e);
		}
		
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.set content type
		response.setContentType("text/html");
		//2.printwriter
		try(PrintWriter pw=response.getWriter()){
		//3.create session
			
			HttpSession session=request.getSession();
			
		//4.set attributes
			
		session.setAttribute("player_dao",playerDao );
		session.setAttribute("team_dao",teamDao );
		
		List<String> teamAbbreviations= teamDao.getTeamsAbbreviation();
		pw.print("<form method='post' action='teamValidate'>");
		pw.print("<h5> Choose a Team : <select name='abbrevation'>");
		for (String s : teamAbbreviations)
			pw.print("<h5><option value='" + s + "'</option>" + s + "</h5>");
		pw.print("</h5> </select>");
		pw.print("<h5>Player First Name <input type='text' name='fname'/></h5>");
		pw.print("<h5>Player Last Name <input type='text' name='lname'/></h5>");
		pw.print("<h5>DoB <input type='date' name='dob'/></h5>");
		pw.print("<h5>Batting Avg <input type='number' name='battingAvg'/></h5>");
		pw.print("<h5>Wickets Taken <input type='text' name='wickets'/></h5>");
		pw.print("<h5><input type='submit' value='createPlayerx'/></h5>");
		pw.print("</form>");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			playerDao.cleanup();
			teamDao.cleanup();
		    closeConnection();
		} catch (Exception e) {
			// inform WC about the err : OPTIONAL !
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}


}
