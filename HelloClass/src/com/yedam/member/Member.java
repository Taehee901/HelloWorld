package com.yedam.member;

public class Member {
	//필드.
	private String memberId;
	private String memberName;
	private String phone;
	private int point;
	//생성자.
	public Member() {}
//	public Member(String memberId,String memberName) {
//		
//	}
	
	//우클릭 - source -Generate Constructor using Fields-after member(string,string)-package
	//전체필드를 매개값으로 갖는 생성자
	public Member(String memberId, String memberName, String phone, int point) {
//		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}
	//메소드(getter,setter)
	//우클릭 - source-getter/setter
	//회원id의 get(값 가져옴)/set(값 지정함)
	void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	String getMemberId() {
		return memberId;
	}
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	String getMemberName() {
		return memberName;
	}

	void setPhone(String phone) {
		this.phone = phone;
	}
	String getPhone() {
		return phone;
	}
	void setPoint(int point) {
		this.point = point;
	}
	
	public int getPoint() {
		return point;
	}
	//이름,연락처,포인트 출력메소드. = member소속된 
	public void showInfo() {
		System.out.printf("이름은 %s,연락처는 %s,포인트는 %d\n",memberName,phone,point);
	}

	
//	void setMemberId(String memberId) {
//		this.memberId = memberId;
//	}
//	String getMemberId()  {
//		return memberId;
//	}
	//회원명의 get/set
	//set 값지정
//	void setMemberName(String memberName) {
//		this.memberName = memberName;
//	}
	//전체필드를 매개값으로 갖는 생성자
//	
//	String getMemberName()  {
//		return memberName;
//	}
//	//연락처 get/set
//	void setPhone(String phone) {
//		this.phone = phone;
//	}
//	//매개값이 없고 반환값이 있습니다.
//	String getPhone() {
//		return phone;
//	}
//	//포인트 get/set
//	void setPoint(int point) {
//		this.point = point;
//	}
//	int getPoint() {
//		return point;
//	}
	
}


