package project;

import java.util.List;


/*
 * 업무로직(회원등록,변경,삭제,목록출력)
 * 추상메소드만 정의
 * return 타입 boolean
 * */
public interface RpgMemberService {
	public boolean addMember(RpgMember rpgchar);//등록.
	public boolean modifyMember(RpgMember rpgchar);//변경
	public boolean removeMember(String chId);//삭제
	public List<RpgMember> memberList();//출력.,한건??
}
