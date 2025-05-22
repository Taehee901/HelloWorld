package com.yedam.interfaces;
/*//패키지이름과같으면x
 * 
 * 인터페이스 : 필드(상수)
 * 
 * */
public interface RemoteControl {
	public int MAX_VOLUME = 10;//MAX_VOLUME두단어조합,따로 선언안해도 final
	
	//추상메소드abstract해도되고 안해도됨
	//구현클래스
	public abstract void turnOn();
	public void turnOff();
}
