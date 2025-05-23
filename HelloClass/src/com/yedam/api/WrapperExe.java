package com.yedam.api;

public class WrapperExe {
	public static void main(String[] args) {
		int num = 10;
//		num.->기본데이터타입 메소드(x)
//		Integer num2 = new Integer(20);//참조데이터타입
		Integer num2 = 20;
		num = num2.intValue();
		
		String str = "10";
		num = Integer.parseInt(str);//정수타입으로변환
		//8byte
		double num3 = Double.parseDouble(str);
//		System.out.println(num3);
		//4byte,자동형변환 발생
		num3 = Float.parseFloat(str);
		//박싱처리,기본데이터타입을 integer타입으로 변경
		// 기본타입 -> 참조타입(박싱)
		//주소값 = false
//		Integer num5 = new Integer(10);
//		Integer num4 = new Integer(10);//기본타입 -> 참조타입(레퍼타입)(박싱)
		//참조타입 -> 기본타입(언박싱)
		Integer num4 = 10;
		Integer num5 = 10;
		//레퍼타입을기본타입으로변경후비교
//		System.out.println(num4 == num5);
		//intValue기본타입변경
		System.out.println(num4.intValue() == num5.intValue());
		
	}
}
