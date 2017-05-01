package pl.motyka.mateusz.klaser.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] argv) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;

		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://ec2-54-163-234-20.compute-1.amazonaws.com:5432/ddp2jaehjne5b4?sslmode=require",
					"brztpukkcgsqsh", "b64070bcb78a9ca228404b85e9a27abe0ba2b40a43c546d196661fae06dcdc2f");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now!");

		} else {
			System.out.println("Failed to make connection!");
		}
		pst = connection.prepareStatement("SELECT * FROM pokemony");
		rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
		}
	}
}