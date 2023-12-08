package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EMP 테이블에 저장된 모든 사원의 사원번호,사원이름,급여를 급여로 내림차순 정렬되도록 검색하여 출력하는 JDBC 프로그램 작성
public class SelectEmpApp {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, username, password);
			
			stmt=con.createStatement();
			
			String sql="SELECT EMPNO, ENAME,SAL FROM EMP ORDER BY SAL DESC";
			
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				int empno=rs.getInt("EMPNO");
				String ename=rs.getString("ENAME");
				int sal=rs.getInt("SAL");
				
				System.out.println("사원번호 = "+empno);
				System.out.println("사원이름 = "+ename);
				System.out.println("급여 = "+sal);
				System.out.println("==================================");
			} 
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 에러 = "+e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
