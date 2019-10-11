package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BEAN.Users;

public class UsersDAO {

	public static boolean InsertUsers(Connection conn, Users user) {
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO users(id,username,password,win,lose,score) " + "VALUES (?,?,?,?,?,?)";

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, user.getId());
			ptmt.setString(2, user.getUsername());
			ptmt.setString(3, user.getPassword());
			ptmt.setInt(4, user.getWin());
			ptmt.setInt(5, user.getLose());
			ptmt.setInt(6, user.getScore());

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

	public static List<Users> selection(Connection conn) {
		List<Users> list= new ArrayList();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			System.out.println("id\tusername\tpassword\twin\tlose\tscore");
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String pass=rs.getString(3);
				int win=rs.getInt(4);
				int lose=rs.getInt(5);
				int score=rs.getInt(6);
				System.out.println(id + "\t" + name + "\t\t" + pass + "\t\t"
						+ win + "\t" + lose + "\t" + score);
			list.add(new Users(id, name, pass, win, lose, score));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
