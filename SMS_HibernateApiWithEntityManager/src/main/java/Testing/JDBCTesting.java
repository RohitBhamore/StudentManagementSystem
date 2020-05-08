package Testing;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTesting {

	public static void main(String[] args) {

		final String URL = "jdbc:mysql://localhost:3306/hb_student_tracker";
		final String USER_NAME = "hbstudent";
		final String PASSWORD = "hbstudent";

		try {

			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			
			if(con != null) {
				System.out.println("DONE");
			}else {
				System.out.println("NOT DONE");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
