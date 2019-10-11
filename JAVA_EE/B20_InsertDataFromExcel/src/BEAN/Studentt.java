package BEAN;

public class Studentt {
	private int id;
	private String hoten;
	private String quequan;

	public Studentt(int id, String hoten, String quequan) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.quequan = quequan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	@Override
	public String toString() {
		return "Studentt [id=" + id + ", hoten=" + hoten + ", quequan=" + quequan + "]";
	}
	
	

}
