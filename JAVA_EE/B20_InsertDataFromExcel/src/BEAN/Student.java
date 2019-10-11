package BEAN;

public class Student {

		private int id;
		private String hoten;
		private int idtinh;
		
		
		
		
		
		public Student(int id, String hoten, int idtinh) {
			super();
			this.id = id;
			this.hoten = hoten;
			this.idtinh = idtinh;
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
		public int getIdtinh() {
			return idtinh;
		}
		public void setIdtinh(int idtinh) {
			this.idtinh = idtinh;
		}
		
		
		
		
		
}
