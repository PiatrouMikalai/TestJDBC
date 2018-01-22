package by.minsk.piatrou;

import java.sql.*;
import java.util.ArrayList;

public class JDBCRunner{

	public static Connection cn;
	public static Statement st;
	public static ResultSet rs;
	public static PreparedStatement ps;
	
	private final String SQL_INSERT = "INSERT INTO university.students (studentFirstName, studentLastName) VALUES (?, ?)";
	private final String SQL_BETWEEN = "SELECT * FROM university.students WHERE students_id BETWEEN ? AND ?";
	
	
	public static ArrayList<Student> students = new ArrayList<>();
	
	public void selectAllDB() throws SQLException {
		try {
			cn = ConnectorDB.getConnection();
			st = cn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM university.students");
			
			Student student;
			
			while (rs.next()) {
				student = new Student();
				student.setStudentID(rs.getInt(1));
				student.setStudentFirstName(rs.getString(2));
				student.setStudentLastName( rs.getString(3));
				students.add(student);
			}
			
			st.close();
			cn.close();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void addNewStudent(String firstName, String lastName) throws SQLException {
		try {
			Student stud = new Student();
			cn = ConnectorDB.getConnection();
			ps = cn.prepareStatement(SQL_INSERT);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.executeUpdate();
			
			stud.setStudentID(JDBCRunner.students.get(JDBCRunner.students.size()-1).getStudentID() + 1);
			stud.setStudentFirstName(firstName);
			stud.setStudentLastName(lastName);
			students.add(stud);
			
			ps.close();
			cn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void showStudentBetween(int from, int to) {
		try {
			cn = ConnectorDB.getConnection();
			ps = cn.prepareStatement(SQL_BETWEEN);
			
			ps.setInt(1, from);
			ps.setInt(2, to);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				
				System.out.println(id + " " + firstName + " " + lastName);
			}
			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
