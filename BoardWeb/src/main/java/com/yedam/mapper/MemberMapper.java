package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;
//sql의 변수의 이름 ,쿼리안에서는 이렇게 쓰겠다.
//로그인 사용자조회
public interface MemberMapper {
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	
}
