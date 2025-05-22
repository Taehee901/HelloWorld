package com.yedam.interfaces;
/*
 * 클래스(Television)는 RemoteControl 인터페이스를 상속(x) 구현클래스.
 * 
 * */
public class Television implements RemoteControl{//반드시구현클래스 

	@Override
	public void turnOn() {
		System.out.println("텔레비젼을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("텔레비젼을 끕니다.");
	}

}
