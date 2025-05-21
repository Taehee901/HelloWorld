package com.yedam.inheritance;
/*
 * 부모:CellPhone
 *  - 전원켜기,전원끄기,통화 ==,볼륨up,볼륨down
 *  - Model,Color
 *  자식: SmartPhone
 *  	- TV보기
 *  
 *  
 *  
 * */
public class CellPhone {
	String model;
	String color;

	void powerOn(){
		System.out.println("전원을 켜기.");
	}
	void powerOff() {
		System.out.println("전원을 끄기.");
	}
	void 통화하기() {
		System.out.println("통화하다.");
	}
	
}
