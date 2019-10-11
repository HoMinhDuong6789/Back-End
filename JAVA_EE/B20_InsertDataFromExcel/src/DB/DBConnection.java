package DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBConnection {

	public static java.sql.Connection CreateConnection() throws SQLException {
		java.sql.Connection conn = null;
		String url = // "jdbc:mysql://localhost:8080/caro";
						// "jdbc:mysql://localhost:8080/caro";//?autoReconnect=true&useSSL=false";
				"jdbc:mysql://localhost:3306/qlktx?autoReconnect=true&useSSL=false";
		String name = "root";
		String pass = "";
		try {

			
			Class.forName("com.mysql.jdbc.Driver");
			// jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false
			conn=DriverManager.getConnection(url, name, pass);;
			
			return conn;

			// conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
}
