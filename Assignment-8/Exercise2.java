package assignment8;

import java.sql.*;

public class Exercise2 {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost/assignment8ii";
		Connection connection = null;
		Statement statement;
		PreparedStatement preparedStatement1;
		PreparedStatement preparedStatement2;
		String salesQuey = "update COFFES set SALES = ? where COF_NAME like ?";
		String totalQuery = "update COFFES set TOTAL = TOTAL + ? where COF_NAME like ?";
		String query = "select COF_NAME, SALES, TOTAL from COFFES";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			connection = DriverManager.getConnection(url, "root", "barath+;");

			preparedStatement1 = connection.prepareStatement(salesQuey);
			preparedStatement2 = connection.prepareStatement(totalQuery);
			int[] salesForWeek = { 175, 150, 60, 155, 90 };
			String[] coffees = { "Colombian", "French_Roast", "Espresso", "Colombian_Decaf", "French_Roast_Decaf" };
			connection.setAutoCommit(false);
			for (int i = 0; i < coffees.length; i++) {
				preparedStatement1.setInt(1, salesForWeek[i]);
				preparedStatement1.setString(2, coffees[i]);
				preparedStatement1.executeUpdate();
				preparedStatement2.setInt(1, salesForWeek[i]);
				preparedStatement2.setString(2, coffees[i]);
				preparedStatement2.executeUpdate();
				connection.commit();
			}
			preparedStatement1.close();
			preparedStatement2.close();

			connection.setAutoCommit(true);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String coffeeName = resultSet.getString("COF_NAME");
				int sales = resultSet.getInt("SALES");
				int total = resultSet.getInt("TOTAL");
				System.out.println(coffeeName + " " + sales + " " + total);
			}
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			if (connection != null) {
				try {
					System.err.println("Transaction is being rolled back");
					connection.rollback();
				} catch (SQLException excep) {
					System.err.print("SQLException: ");
					System.err.println(excep.getMessage());
				}
			}
		}
	}
}