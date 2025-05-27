package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement
 * 4. 실행
 * 5. ResultSet
 * 6. 출력
 * 
 * 
 * */
public class DatabaseExe {
	public static void main(String[] args) {
		//oracle 11g xe기준 데이터베이스 접속 기본 주소
		//jdbc:oracle:thin 드라이버 타입
		//@구분기호,localhost-데이터베이스 ip,1521접속 포트,xe - service name
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//데이터베이스 접속주소
		String id = "scott";//데이터베이스 사용자명
		String pass = "tiger";//데이터베이스 사용자 비밀번호
		//세션처리.
		Connection conn = null;
		
		//라이브러리제대로 연결되어있는지확인위해
		try {
			//forName은 주소체크
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//오라클 계정 비번 등
			//쿼리실행위해 받아옴
			conn = DriverManager.getConnection(url, id, pass);
			//자동세션하고싶지않다면
			conn.setAutoCommit(false);
			System.out.println("연결성공.");
		} catch (ClassNotFoundException e) {
			//드라이브연결되어있는지 확인 없을경우
			System.out.println("드라이버 연결.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Statement 객체 - SQL 구문을 실행하는 역할
		Statement stmt = null;
		ResultSet rs = null;
		//2번실행하면 재약조건위배(Primary_key =>중복된값이들어가면안되는규칙존재)
//		String sql = "update product"+ " set p_name = '치토스',"+ "p_price = 1000"+ "where  p_code = 202";//복사할 때 ; 실행하겠다는 의미니 지워야함
//		delete
		String sql = "delete from product where p_code = 202";
		//ORA-00933: SQL 명령어가 올바르게 종료되지 않았습니다
//		String sql ="update product\r\n"
//				+ "set    p_name = '치토스',\r\n"
//				+ "       p_price = 2700\r\n"
//				+ "where  p_code = 202";
		
//		String sql = "insert into product (p_code,\r\n"
//				+ "                     p_name,\r\n"
//				+ "                     p_price)\r\n"
//				+ "values (202,'치토스',2000)";//복사할 때 ; 실행하겠다는 의미니 지워야함
		//insert
		try {
			stmt = conn.createStatement();
			//오류발생시 코드오류가 아닌 sql오류니 sql쪽으로가서봐야함(쿼리가잘못된경우)
			int r = stmt.executeUpdate(sql);//insert,update,delete 값이 변경되는,데이터변경될때는 executeUpdate
			if(r > 0) {//처리된 건수가 0보다 클 경우
				//실체커밋호출
				conn.commit();//커밋
				System.out.println(r + "건 등록됨.");
			}else {
				//롤백,커밋 직접 선언
				conn.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
	
		}
		
		
		try {
//			stmt = conn.createStatement();//한번만 할당이 되면됨,
			//데이터가 한건,여러건,없을 수 도 있는데 받아온 세션을 resultset 컬렉션에 담아줌
			//어떤쿼리를 사용할거냐..?
			//select문과 같은 쿼리문을 실행할 때 사용,결과를 resultSet객체로 반환,결과를 resultset객체를통해 가져옴
			//교육하려고 * =>컬럼명으로한거임,프로젝트할때도 써야함
			//등록된 커넥션조회
			rs = stmt.executeQuery("select * from product");//rs 처리결과 담아줌,조회할때는 데이터 변경안되니executeQuery
			System.out.println("상품코드  상품이름    가격");
			System.out.println("--------------------");
			//가져올데이터가있는지없는지체크
			//null값이경우 -- null 표현
			while(rs.next()) {//실행하면 커서가 첫번째데이터위치로 이동 - 정보가져옴
				System.out.println(rs.getInt("p_code")+" " //컬럼 데이터가 정수타입일 경우 getInt 
						+rs.getString("p_name")+" "
						+rs.getInt("p_price")
						);//p_code컬럼
			}
			System.out.println("---------end of rows-----------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//그냥 close 값이 할당되어있는지 없는지 null 값인지확인,null일 경우 close할 필요없음
		//resultset값이 executeQuery처리된값을 만들어주는게 값할당,데이터가없더라도반환해줌
		try {
			if(rs != null)rs.close();
			if(stmt != null)stmt.close();
			if(conn != null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}//end of main
}
