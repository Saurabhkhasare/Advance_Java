package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pojos.User;
import utils.DBUtils;

public class UserDaoImpl implements UserDao {
	private Connection connection;
	private PreparedStatement pst1, pst2;

	public UserDaoImpl() throws SQLException {
		connection = DBUtils.openConnection();
		pst1 = connection.prepareStatement("select * from users where email=? and password=?");
		pst2 = connection.prepareStatement("update  users  set status= 1 where id=? ");
		System.out.println("Users dao created!");

	}

	@Override
	public User authenticateUser(String email, String pass) throws SQLException {
		//SET IN PARAMETER
		pst1.setString(1, email);
		pst1.setString(2, pass);
		ResultSet rst = pst1.executeQuery();
	//	User user = null;
		while (rst.next()) {
			// public User(int userId, String firstName, String lastName, String email, Date
			// dob, boolean votingStatus,
			// String role)
			return new User(rst.getInt(1), rst.getNString(2), rst.getNString(3), email, rst.getDate(6),
					rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}

	public void updateVotingStatus(int uId) throws SQLException {
		pst2.setInt(1, uId);
		int n = pst2.executeUpdate();
		if (n != 0)
			System.out.println("voting status updated");
		else
			System.out.println("user not found");
	

	}

}
