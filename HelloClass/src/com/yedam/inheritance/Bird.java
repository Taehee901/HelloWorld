package com.yedam.inheritance;
/*
 * 부모클래스: Animal(추상클래스)
 * 
 * */
public class Bird extends Animal{//상속하겠다는데 에러발생,추상메소드구현하기전까지
//kind선언안해도물러받음
	String kind;
	@Override
	public void sound() {
		//부모클래스의 sound() 재정의 해야함.(반드시)
		System.out.println("짹짹");
	}
	
}
