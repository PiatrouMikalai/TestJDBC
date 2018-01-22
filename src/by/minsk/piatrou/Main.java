package by.minsk.piatrou;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		JDBCRunner runner = new JDBCRunner();
		while(true) {
			System.out.println("\n" + "Выберите действие:" + "\n" 
					+ "1. Вывести на экран всех студентов" + "\n"
					+ "2. Добавить студента" + "\n"
					+ "3. Вывести студентов с номером от и до:");
			
			Scanner in = new Scanner(System.in);
			int number = in.nextInt();
			switch(number) {
				case 1:
					runner.selectAllDB();
					for(int i = 0; i < JDBCRunner.students.size(); i++) {
						System.out.println(JDBCRunner.students.get(i));
					}
					break;
				case 2:
					System.out.println("Введите имя и фамилию:");
					String firstName = in.nextLine();
					String lastName = in.nextLine();
					runner.addNewStudent(firstName, lastName);
					break;
				case 3:
					System.out.println("Введите пределы:");
					int from = in.nextInt();
					int to = in.nextInt();
					runner.showStudentBetween(from, to);
					break;
			}
		}
	}
}
