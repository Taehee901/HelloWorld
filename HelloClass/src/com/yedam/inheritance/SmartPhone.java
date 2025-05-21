package com.yedam.inheritance;

/*
 * CellPhone을 상속.
 * 
 * */
public class SmartPhone extends CellPhone {// cellphone의 모든것상속
	// 추가속성
	int channel;
	//부모클래스에 기본생성자가없어서 오류
	
	//생성자
	public SmartPhone() {}
	//부모클래스에 기본생성자만든든지,아니면 매개변수받은 생성자를만든던지
	public SmartPhone(String model, String color,int channel) {
		super(model,color);//cellphone에 두개 매개값받는 변수 선언
		this.channel = channel;
	}

	//메소드
	void watch() {
		System.out.println(channel + "을 시청합니다.");
	}

//	double d1 = 10;
	
	
	// 부모클래스의 기능을 자식클래스 재정의 =>(overriding)
//	void powerOn() {
//		System.out.println("😍전원을 켭니다👌");
//	}
	@Override
	void powerOn() {
		System.out.println("😍전원을 켭니다👌");//자식클래스에서 선언되었던 
	}
//	부모클래스 메소드 타입 이름이 맞는지아닌지 체크
	@Override
	void powerOff() {
		System.out.println("😍전원을 끕니다👌");
	}

	@Override
	public String toString() {
		return super.toString() + "channel=" + channel + "]";
	}

//	public void powerOff() {
//		System.out.println("😍전원을 켭니다👌");
//	}
////부모에게도 똑같이 하면됨 더 강한 접근 제한으로 재정의할수 없다.
//	@Override
//	void powerOff() {
//		System.out.println("😍전원을 끕니다👌");
//	}
	
//	@Override //부모클래스가진거자식클래스가재정의
//	//오버라이딩안한경우 object메소드호출,cellphone정의후 cellphone메소드를보여줌,부모에 정의되어있지않더라도 위 상위 타입인 경우가능
//		public String toString() {//celllphone ->(부모)object,super(부모)
//			// TODO Auto-generated method stub
//			return super.toString();
//		}
	
	
}
