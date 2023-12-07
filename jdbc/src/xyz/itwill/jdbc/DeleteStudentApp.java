package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 학생정보 중 학번이 [3000]인 학생정보를 삭제하는 JDBC 프로그램 작성
public class DeleteStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "oracle:jdbc:thin:@localhost:1521:xe";
			String username = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, username, password);
			
			String sql="delete from student where no=3000";
			stmt=con.createStatement();
			int rows=stmt.executeUpdate(sql);
			
			
			System.out.println("[메세지]"+rows+"명의 정보가 삭제되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]SQL 관련 에러 발생 = "+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
