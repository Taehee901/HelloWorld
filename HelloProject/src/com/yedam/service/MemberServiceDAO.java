package com.yedam.service;

import java.util.List;

//import com.yedam.common.DAO;
import com.yedam.common.MemberDAO;
import com.yedam.vo.Member;

/*
 * 업무단위처리(데이터베이스의 여러테이블에 반영)
 * 업무단위처리(데이터베이스의 여러테이블에 반영)
 * */
//DAO상속 MemberService인터페이스 MeberServiceDAO클래스 ,Service(업무)
public class MemberServiceDAO implements MemberService{//데이터베이스 처리하는 서비스를하나로뭉침 1:1기능이라 -> 정석대로하는걸로바뀜
	MemberDAO dao = new MemberDAO();	//기능정의하는 필드.
//	PointDAO pdao = new PointDAD();
//	PurchaseDAO
	
	//MemberDao
	@Override
//openi~
	public boolean addMember(Member member) {//회원추가되면,여러테이블에 들어가야함()
//		pado.insert();
//		p2do.insert();//필요내용다 정의하고 작업을하는방식
		//구조 1:1
		return dao.insert(member) == 1;//추가기능 1 t ,not f
	}

	@Override
	public boolean modifyMember(Member member) {
		return dao.update(member) == 1;
	}

	//멤버테이블뿐 아닌 다른테이블다지워줘야함 - 회원탈퇴시
	@Override
	public boolean removeMember(String memberId) {
		return dao.delete(memberId) == 1;
	}

	@Override
	public List<Member> memberList() {
		return dao.select();
	}//
	
}
