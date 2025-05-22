package com.yedam.inheritance;
/*
 * 추상클래스(Animal) abstract붙여주면
 * 추상클래스(Animal):인스턴스 생성x
 * 				   추상메소드
 * 
 *자식클래스 :Bird,Fish.
 *                 
 *                 
 * */
public abstract class Animal {//클래스의 특징 다가지지만 Animal이라는 인스턴스는 만들 수 없음
	String kind;
	
	//재정의안해도상관없음
	public void breathe() {
		System.out.println("숨을 쉽니다.");//구현
	}
	
	
	
	//일일히 찾아서 고쳐야하는 문제가됨-유지보수 좋음 public void add(x),odao.add();,oracle or = new ORacleDao;,dao dao = new mysql();
	//규칙사용하는 경우
	//회사-여러기능만듦(메소드)-mysql(싼거씀..)-oracle데이터베이스써서 새로만들었어.. - 전 코드 찾아서 다 바꿔줘야함.. - 상속받는 클래스가운데두면 -이름을 바꿀수 x(insert - addx)
	//추상메소드: 자식클래스에 반드시 재정의 ,부모 기능이 없음(제공하지 않음)
	//재정의는 부모것울 자식클래스가 동일한 임과 파라미터로 정의하는것
	//자식클래스에서 기능을구현해줘야하는 규칙이생김,메소드방식같아야함(sound()),자식 여러 결과나오게 하려면(제각각만들려고하면)..?
	public abstract void sound();//기능을 싥행하겠다는 부분이 빠짐
	

}
