package DAO;

public class LoginDAO {
	public static boolean Validate(String name, String pass) {
		
		if (name.equalsIgnoreCase("Admin")&&pass.equals("123456")) {
			return true;
		}
		return false;
	}
}
