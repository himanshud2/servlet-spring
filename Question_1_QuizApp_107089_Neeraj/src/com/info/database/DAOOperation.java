package com.info.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.info.userbean.User;

public class DAOOperation {
	public User checkUser(String username, String password, String path) throws SQLException, NamingException {
		System.out.println(username);
		System.out.println(password);
		Connection con = DAOConnection.getConnection(path);
		User user = new User();
		String query = "select * from quizUser where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			user.setUsername(username);
			user.setPassword(password);
			user.setTopic(rs.getString(4));
			return user;
		} else {
			return null;
		}
	}

	public ResultSet getTopic(String path) throws NamingException, SQLException {
		Connection con = DAOConnection.getConnection(path);
		String query = "select distinct topic from quiz";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	public boolean registerUser(User user, String path) throws NamingException, SQLException {

		Connection con = DAOConnection.getConnection(path);
		String query = "insert into quizUser values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getAge());
		ps.setString(4, user.getTopic());
		int rs = ps.executeUpdate();
		if (rs > 0)
			return true;
		else
			return false;
	}
	public ResultSet getQuiz(String topic,String path) throws NamingException, SQLException
	{
		Connection con = DAOConnection.getConnection(path);
		String query = "select * from quiz where topic=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, topic);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
}
