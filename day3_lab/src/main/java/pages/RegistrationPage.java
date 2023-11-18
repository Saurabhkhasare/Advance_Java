package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class RegistrataionPage
 */
@WebServlet("/registration")
public class RegistrationPage extends HttpServlet {
	private UserDaoImpl userdao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			userdao = new UserDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			userdao.cleanUp();
		} catch (Exception e) {
			// inform WC about the err : OPTIONAL !
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set response content type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String firstname = request.getParameter("fnm");
			String lastname = request.getParameter("lnm");
			String email = request.getParameter("em");
			String pass = request.getParameter("pass");
			
			String date = request.getParameter("dob");
			LocalDate dob1 = LocalDate.parse(date);
			int years = Period.between(dob1, LocalDate.now()).getYears();
			Date dob = Date.valueOf(date);

			 if (years < 21)
				pw.print("<h4>Age MUST be 21 </h4>");
			else {
				String message = userdao.registerNewVoter(new User(firstname, lastname, email, pass, dob));
				response.sendRedirect("candidate_list");
			}
		} catch (Exception e) {
			throw new RuntimeException("err in do-post" + getClass(), e);
		}

	}

}
