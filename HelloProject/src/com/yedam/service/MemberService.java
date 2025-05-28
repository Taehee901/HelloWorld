package com.yedam.service;

import java.util.List;

import com.yedam.vo.Member;

/*
 * 업무로직(회원등록,변경,삭제,목록출력)
 * 추상메소드만 정의
 * return 타입 boolean
 * */
public interface MemberService {
	public boolean addMember(Member member);//등록.
	public boolean modifyMember(Member member);//변경
	public boolean removeMember(String memberId);//삭제
	public List<Member> memberList();//출력.,한건??
}
