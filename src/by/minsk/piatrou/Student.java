package by.minsk.piatrou;

public class Student {
	private Integer studentID;
	private String studentFirstName;
	private String studentLastName;
	
	public Student() {}
	
	public Student(Integer studentID, String studentFirstName, String studentLastName) {
		this.studentID = studentID;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
	}
	
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	
	@Override
	public String toString() {
		return this.getStudentID() + " " + this.getStudentFirstName() + " " + this.getStudentLastName();
	}
}