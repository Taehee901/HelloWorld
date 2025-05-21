package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {
		//부모클래스.
		//필드값채우던지,기본생성자만드던지
		CellPhone phone1 = new CellPhone();
		phone1.model = "IT203";
		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		
		//자식클래스.
//		SmartPhone phone2 = new SmartPhone();//cellphone부모에게상속받아 smartphone 정의안해도사용가능
		
		CellPhone phone2 = new SmartPhone();//자식클래스에 정의된것은 부모 클래스가 사용할 수 없다,부모클래스에가진것만사용가능
		phone2.model = "S21";
		phone2.color = "white";
		phone2.powerOn();
		phone2.powerOff();
		System.out.println(phone1.toString());
		SmartPhone phone3 = null;
		
		
		//상상??창의략
		//자동형변환
		if(phone2 instanceof SmartPhone) {
		    phone3 = (SmartPhone)phone2;//부모클래스를 자식클래스로 형변환 캐스팅
			
			phone3.channel = 2;
			phone3.watch();
			System.out.println(phone3.toString());
		}
		//문법상오류x - 실행에러
		//instanceof 메소드를 변환가능한지 체크.
		if(phone1 instanceof SmartPhone) {//참조변스의 값의 유형이 smartphone 인스턴스가맞는지확인후 캐스팅 및 실행
			phone3 = (SmartPhone)phone1;
			phone3.channel = 3;
			phone3.watch();	
		}
	}
}
