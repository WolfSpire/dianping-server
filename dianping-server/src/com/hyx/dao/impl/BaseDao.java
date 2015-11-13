package com.hyx.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.Statement;

import com.hyx.dao.*;
public class BaseDao {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/dianping?useUnicode=true&characterEncoding=utf8";
	private static String user = "root";
	private static String password = "Mysql";
	static {
		try {
			// ResourceBundle
			// bundle=ResourceBundle.getBundle("/dianping_server/src/config.properties");
			// String driver=bundle.getString("com.mysql.jdbc.Driver");

			// password=bundle.getString("password");
			Class.forName(driver);
		} catch (Exception e) {
		}
	}

	protected Connection getConn() throws Exception {
		return new Inner().getConn();
	}

	protected void close(ResultSet resultSet, Statement statement,
			Connection connection) throws Exception {
		new Inner().close(resultSet, statement, connection);
	}

	private class Inner implements Dao {
		public void close(ResultSet resultSet, Statement statement,
				Connection connection) throws Exception {
			if (resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
			if (statement != null) {
				statement.close();
				statement = null;
			}
			if (connection != null) {
				connection.close();
				connection = null;
			}

		}

		public Connection getConn() throws Exception {
			return DriverManager.getConnection(url, user, password);
		}

	}

}
