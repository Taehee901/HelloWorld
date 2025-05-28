package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Member;

/*
 * Database에 insert,update,delete,select
 * 
 * */
public class MemberDAO extends DAO{//DAO상속
	
	//등록
	public int insert(Member member) {//한건추가.업데이트는순서는같고 쿼리는 달라짐
		//''오라클에서 문자열
		String sql = "insert into tbl_member(member_id,member_name,phone,point)"//
				//+ "   values('"+member.getMemberId()+"','"+member.getMemberName()+"')"
				//쿼리안에 파라미터 전달
				  + "values(?,?,?,?)";
		//커넥션
		//DB접속.
		getConnect();
		//예외처리
		try {
			//문자열은 문자처리,숫자는숫자처리해줘야해..stmt,p
			//stmt = conn.createStatement();//객체만들어서 실행
			psmt = conn.prepareStatement(sql);//쿼리 매개값전달
			psmt.setString(1, member.getMemberId());//"values(?)",값을 파라미터로 전달
			psmt.setString(2, member.getMemberName());//"values(,?)"
			psmt.setString(3, member.getPhone());
			psmt.setInt(4, member.getPoint());
//			int r = stmt.executeUpdate(sql);
//			return r;//처리건수 반환
			int r = psmt.executeUpdate();//매개값호출x
			return r;//건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//성공하거나실패해도 하고싶은코드할수있게
			disconnect();
		}
		return 0;//에러거나 제대로 안될경우,한건도 반영안됨 //반영x
	}//end of insert.
	
	//수정
	public int update(Member member) {
		String sql = "update tbl_member"//
				  + " set member_name = ?"
				  + "     ,phone = ?"//member.phone
				  +"      ,point = ?"//
				  +"  where member_id = ?";
		//접속
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);//쿼리 매개값전달
			psmt.setString(1, member.getMemberName());
			psmt.setString(2, member.getPhone());//"values(?)",값을 파라미터로 전달
			psmt.setInt(3, member.getPoint());//"values(,?)"
			psmt.setString(4, member.getMemberId());
			int r = psmt.executeUpdate();//매개값호출x
			return r;//건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return 0;
	}//end of update.
	
	//삭제
	public int delete(String memberId) {
		String sql = "delete from tbl_member"
				+ "   where  member_Id = ?";
		//접속
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);//쿼리 매개값전달
			psmt.setString(1, memberId);
			int r = psmt.executeUpdate();//매개값호출x
			return r;//건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return 0;
	}//end of delete
	
	//목록
	public List<Member> select(){
		String sql = "select * from tbl_member";
		getConnect();
		//값 담는 변수 선언
		List<Member> list = new ArrayList<Member>();//컬렉션에 저장.
		try {
			psmt = conn.prepareStatement(sql);
			//조회
			rs = psmt.executeQuery();//조회
			//포함건수만큼 반복
			while(rs.next()) {
				//가지고온 데이터건수만큼 반복 List담아서 반환
				Member member = new Member();
				//데이터베이스 조회값을 member 가져오겠다.
				//조회값중 member_id에 대한 걸 들고 와서 멤버 id 가져온다,저장
				
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setPoint(rs.getInt("point"));
				//컬렉션 추가
				list.add(member);
				//rs - 여러건수담고 있음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
