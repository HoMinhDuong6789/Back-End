package BEAN;

public class Users {
	private int id;
	private String username;
	private String password;
	private int win;
	private int lose;
	private int score;

	public Users(int id, String username, String password, int win, int lose, int score) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.win = win;
		this.lose = lose;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	

}
