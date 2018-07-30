package retail.common;

 
public class SessionAModel   {
	
	// 관리자 ID
	private String admin_id;
	// 이름
	private String admin_name;
	// 관리등급
	private String admin_grade;
	
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_grade() {
		return admin_grade;
	}
	public void setAdmin_grade(String admin_grade) {
		this.admin_grade = admin_grade;
	}
}
