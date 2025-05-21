package com.yedam.inheritance;
/*
 * 부모:CellPhone
 *  - 전원켜기,전원끄기,통화 ==,볼륨up,볼륨down
 *  - Model,Color
 *  자식: SmartPhone
 *  	- TV보기

 *  
 * */
//매개값 두개받는 생성자 생성
public class CellPhone /*extends Object*/{//모든클래스 제일 위에가 Object 필드와 메소드 상속,정의안해도 있다생각해야함
	String model;
	String color;
	
	
	//https://velog.io/@p0tat0_chip/10%EC%9E%A5.-%EC%9E%90%EB%B0%94%EB%8A%94-%EC%83%81%EC%86%8D%EC%9D%B4%EB%9D%BC%EB%8A%94-%EA%B2%83%EC%9D%B4-%EC%9E%88%EC%96%B4%EC%9A%94
	
	//만약 부모클래스에 기본생성자가 없을 경우 컴파일 시자동으로 만들어줘서 문제는 없는데,매개변수있는 생성자 만들경우 기본생성자 없으면 오류 발생
	//매개값없는게 기본생성자
	public CellPhone() {};
	//생성자
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	void powerOn(){
		System.out.println("전원을 켜기.");
	}
	void powerOff() {
		System.out.println("전원을 끄기.");
	}
	void 통화하기() {
		System.out.println("통화하다.");
	}
	//socurce - generate toString
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}
	
	//toString() 오버라이딩

	
}
