package com.yedam;

/*
 * 라이브러리 클래스
 * */
//student 외부클래스에서는 필드에 값을 넣지못하도록막고,정상적인값을넣을수있도록 메서드제공
public class Student {
//private클래스 접근 제어,외부에서는 접근 못하게 막음
	//필드선언 -객체 데이터가 저장되는
	//필드(속성을 담아놓는 용도)
	private int studentNo;//학생번호
	private String studentName;//학생이름
	private double height;
	private int engScore;
	private int mathScore;
	
	
	//생성자(객체:instance의 초기화),생성자는 반드시 존재
	//필드의 값을 초기화
	//정의 안하면 컴파일러가기본생성자를만들어줌
	//Student클래스 이름과 같고 기능실행하는의미로 ()(매개값)붙음
	public Student() {
		//매개값이 없는 생성자 => 기본생성자
		//아무것도 없을 경우컴파일러가 생성.
		//필요한만큼 여러개 생성 가능
	} //->개발자가 기본생성자대신 내가만든생성자사용하겠다. 생성자를 정의하면 -기본생성자를 안만들어줌
//	

	//필드값을 채우는 역할,생성자로 선언된 매개값이 이름이 같을 경우 우선순위가 높아 변수로 생각함
	public Student(int studentNo,String studentName) {
		this.studentNo = studentNo;//첫번째 매개값은 학생번호할당
		this.studentName = studentName;// 두번째 매개값은 학생이름 할당
	}
	//매개변수 유형 갯수에 따라 영향미침,필요한만큼
	//만약 int 학번,int 2개 선언 후 아래 2개 선언할 경우 에러발생하는 이유
	//
	public Student(int studentNo,int engScore,int mathScore) {
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	//void:함수 메소드 리턴타입 나타냄
	//exe3 메인메소드안에서 init()호출해서 사용하고 있다 - static붙여야함,main메소드안에서 인스턴스 생성할 경우 
	//메소드(기능)
	//static 없는 이유 - 인스턴스를 반드시 선언해야 사용가능하다
	void study() {
		System.out.println("공부를 합니다.");
	}
	void introduce() {
		System.out.printf("학번은 %d이고 이름은 %s입니다.\n",studentNo,studentName);
	}
	//영어,수학점수 저장하는 기능
	//값지정할때는 set붙임
	//필드의 값?
	//유효값
	//set메서드?
	void setEngScore(int engScore) {
		if(engScore < 0 || engScore >100) {
			return;
		}
		this.engScore = engScore;
	}
	void setMathScore (int mathScore) {
		if(mathScore < 0 || mathScore >100) {
			return;
		}
		this.mathScore = mathScore;
	}
	int getEngScore() {//Example클래스 private 외부에서 접근못하니 직접사용을 못하기 때문
		return engScore;
	}
	int getMathScore() {
		return mathScore;
	}
	
	//학번,학생명 지정 메소드
	//set+필드명(앞글자만 대문자)
	//(setter,getter)
	
	//값지정하고 끝 반환x
	void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	//void 반환해주는게 없다(결과값을 돌려주지않는다)
	//get+필드명(앞글자 대문자),가져오는
	//default public보다 덜 노출 public private중간 사이며,둘다 아님
	int getStudentNo() {
		return studentNo;
	}
	//메소드 호출한곳에 반환
	String getStudentName() {
		return studentName;
	}
}
