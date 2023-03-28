package assignment8;

import java.sql.*;

class JDBCconnection {
	Connection connection;
	Statement statement;
	ResultSet resultSet;

	JDBCconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/assignment8i", "root", "barath+;");
			statement = connection.createStatement();
			int table = statement.executeUpdate("create table pradeep(empno integer,ename varchar(20),deptno integer)");
		
			statement = connection.createStatement();
			int row1 = statement.executeUpdate(" insert into pradeep values (001,'sakre',23)");
			int row2 = statement.executeUpdate(" insert into pradeep values (001,'pradeep',223)");
			int row3 = statement.executeUpdate(" insert into pradeep values (001,'vivek',243)");
		
			resultSet = statement.executeQuery("select * from pradeep");
			while (resultSet.next())
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class Exercise1 {
	public static void main(String args[]) {
		new JDBCconnection();
	}
}