package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 공통기능,커넥션객체 반환,데이터베이스
 * 
 *  - 데이터베이스의 연결정보(url,id,pwd)를 활용해서 세션획득
 * */
public class DAO {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";//데이터베이스 접속주소
	String id = "scott";//데이터베이스 사용자명
	String pass = "tiger";//데이터베이스 사용자 비밀번호
	Connection conn;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	
	// 커넥션을 반환하는 메소드
	//Connection생성하는 메소드.
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//end of getConnect()
	public void disconnect() {
		try {
			if(conn != null) conn.close();	
			if(stmt != null) stmt.close();
			if(rs   != null)   rs.close();			
		}catch(SQLException e) {
			
		}
	}
	
	
}
