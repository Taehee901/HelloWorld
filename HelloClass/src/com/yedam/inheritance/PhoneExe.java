package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {
		//부모클래스.
		CellPhone phone1 = new CellPhone();
		phone1.model = "IT203";
		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		
		//자식클래스.
		SmartPhone phone2 = new SmartPhone();//cellphone부모에게상속받아 smartphone 정의안해도사용가능
		phone2.model = "S21";
		phone2.color = "white";
		phone2.powerOn();
		phone2.powerOff();
		phone2.channel = 3;
		phone2.watch();
	}
}
