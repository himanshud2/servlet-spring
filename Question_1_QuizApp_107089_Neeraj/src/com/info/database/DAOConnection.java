package com.info.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOConnection {
	static Connection con = null;

	static Connection getConnection(String path) throws NamingException, SQLException {
		Context ctx;

		ctx = new InitialContext();
		DataSource ds;
		ds = (DataSource) ctx.lookup(path);
		con = ds.getConnection();

		return con;
	}

}
