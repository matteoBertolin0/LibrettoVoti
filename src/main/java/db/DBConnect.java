package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&&password=11235813";
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			System.out.println("Errore di connesione al datbase");
			e.printStackTrace();
			return null;
		}
	}
}
