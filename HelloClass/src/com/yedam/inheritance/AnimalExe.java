package com.yedam.inheritance;
/*
 * main
 * */
public class AnimalExe {
	public static void main(String[] args) {
		//추상클래스는 인스턴스 생성이 불가능.
//		Animal animal = new Animal(); ==> Animal타입은 추상클래스라 인스턴스 생성못하는 규칙존재
		
		Animal a1 = new Bird();//자식클래스의 인스턴스를 부모가 받아줄수는 있음(자식-부모 자동형변환발생)
		a1.breathe();
		a1.sound();
		
		//새로운 인스턴스
		//다형성-어떤 인스턴스가 할당되었냐에 따라 soun()결과가 다름,메소드가 같은데 결과가 다르면 메소드 다형성
		a1 = new Fish();
		a1.breathe();
		a1.sound();
	}
}
