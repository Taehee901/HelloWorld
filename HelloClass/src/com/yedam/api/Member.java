package com.yedam.api;

public class Member extends Object {//모든클래스는 object를 상속하지만 생략되어있음..
	public String memberName;
	public int age;
	
	//생성자만듦(기본)
	public Member() {}
	//필드 다받는생성자
	public Member(String memberName,int age) {
		//   필드
		this.memberName = memberName;
		this.age = age;
	}
	
	//이름,나이 = > 물리적으로는 주소값이다르지만..
	//같으면 논리적으로 동등한지.
	//super부모가리킴
	@Override
	public boolean equals(Object obj) {
//		return super.equals(obj);//obj매개값
		//매개값의 유형이 Member임
		if(obj instanceof Member) {//Member 타입유형아니면
			//캐스팅해서 비교
			Member member = (Member) obj;
			//논리적 비교(의미상으로 true)
			return this.memberName == member.memberName //
					&& this.age == member.age;
		}
		return false;			
	}

	//equals +  hascode
	
	//hascode만 사용했을때..
	//이름:홍길동, 나이:10
	//	이름:김민석, 나이:12
	//이름:홍길동, 나이:10
	
	//그루핑할때 hascod먼저 분류 equlas 중복값 추가x
	@Override //부모클래스가 있고 재정의o
	public int hashCode() {
		//이름:홍길동, 나이:10
//		이름:김민석, 나이:12
		//hascode와 equals 반환값 비교해서 같은 값이면 동등한 객체로 인정 set에서 추가할때 중복값이라 판단 추가x
		return age;//반환되는 값 int 타입
	}
	
	
	//toString방식으로 출력
	@Override
	public String toString() {
		return "이름:" + memberName +", 나이:" +age;
	}
}

