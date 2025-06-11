package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;
//sql의 변수의 이름 ,쿼리안에서는 이렇게 쓰겠다.
//로그인 사용자조회
//SQL 문장에 다수의 변수를 전달할 때, 각 변수를 구분하기 위해서,타입x
public interface MemberMapper {
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	//회원목록.
	public List<MemberVO> selectList(String order);
}
