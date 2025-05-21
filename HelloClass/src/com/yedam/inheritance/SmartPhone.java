package com.yedam.inheritance;

/*
 * CellPhone을 상속.
 * 
 * */
public class SmartPhone extends CellPhone {// cellphone의 모든것상속
	// 추가속성
	int channel;

	void watch() {
		System.out.println(channel + "을 시청합니다.");
	}

	// 부모클래스의 기능을 자식클래스 재정의 =>(overriding)
//	void powerOn() {
//		System.out.println("😍전원을 켭니다👌");
//	}
	@Override
	void powerOn() {
		System.out.println("😍전원을 켭니다👌");
	}
	//부모클래스 메소드 타입 이름이 맞는지아닌지 체크
	@Override
	void powerOff() {
		System.out.println("😍전원을 끕니다👌");
	}
}
