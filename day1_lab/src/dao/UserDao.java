package dao;

import java.sql.SQLException;

import pojos.User;

public interface UserDao {
	public User authenticateUser(String email,String pass) throws SQLException;
	public void updateVotingStatus(int uId)throws SQLException;
}
