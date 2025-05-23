package com.yedam.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		try {
			//클래스 정보,cls
			Class cls = Class.forName("com.yedam.api.Member");
			//실 클래스의 인스턴스이름.getclass()
			Member member = new Member();
			cls = member.getClass();
			System.err.println(cls.getName());
			//선언된 필드.
			//필드타입을 같은타입으로해야 반환
			Field[] fieldAry= cls.getDeclaredFields();//메소드 필드를 배열로 보여줌
			for(Field field : fieldAry) {
				System.out.println(field.getName());//필드명.
			}
			
			//메소드
			Method[] methodAry =  cls.getDeclaredMethods(); //메소드.
			for(Method method : methodAry) {
				System.out.println(method.getName());
			}
			
;		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
