package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BEAN.QueQuan;


public class QqDAO {
	
	
	public static List<QueQuan> selection(Connection conn) {
		List<QueQuan> list= new ArrayList();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from quequan");
			System.out.println("matinh\ttentinh");
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				
				System.out.println(id + "\t" + name);
			list.add(new QueQuan(id, name));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
