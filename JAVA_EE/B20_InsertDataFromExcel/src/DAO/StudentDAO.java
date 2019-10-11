package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BEAN.Studentt;
import DB.DBConnection;


public class StudentDAO {
	public static boolean InsertUsers(Connection conn, Studentt Studentt) {
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO Studentt(id,hoten,quequan) " + "VALUES (?,?,?)";

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, Studentt.getId());
			ptmt.setString(2, Studentt.getHoten());
			ptmt.setString(3, Studentt.getQuequan());
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			}
			ptmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static List<Studentt> selection(int start, int count,Connection conn) {
		List<Studentt> list = new ArrayList();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM studentt limit "+(start)+", "+count+" ");
			System.out.println("id\thoten\t\t\t\tquequan");
			while (rs.next()) {
				int id = rs.getInt(1);
				String hoten = rs.getString(2);
				String quequan = rs.getString(3);

				System.out.println(id + "\t" + hoten + "\t\t\t" + quequan);
				list.add(new Studentt(id, hoten, quequan));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * public static void main(String[] args) { try { Connection conn=
	 * DBConnection.CreateConnection(); List<Studentt> studeentt=
	 * StudentDAO.selection(0, 15, conn); for (Studentt studentt : studeentt) {
	 * System.out.println(studentt.toString()); }
	 * 
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
}
