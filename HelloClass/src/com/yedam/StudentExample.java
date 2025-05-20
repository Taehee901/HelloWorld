package com.yedam;
/*
 * 실행클래스.,6-2
 * */
//public 다른 클래스에서도 사용가능하게함 void 리턴타입이 없다,
public class StudentExample {
	public static void main(String[] args) {
		//Student클래스의 실체를 생성한다,인스턴스
		//student 데이터타입을 지정하는 클래스
		//클래스   변수           인스턴스 생성.(라이브러리클래스의생성자의미)
		Student student = new Student();//1.인스턴스 생성
		//주소값만담음 -> 기능실행안해
//		student.studentNo = 1091;
//		student.studentName = "홍길동";(필드에 값을 지정할 수 없음=>private때문)
//		student.engScore =80;
//		student.mathScore = 85;
		student.setStudentNo(1091);
		student.setStudentName("홍길동");
//		student.engScore =80;//속성값에 대입.
		student.setEngScore(80);//메소드의 매개값으로 점수를 넣음
//		student.mathScore = 85;
		student.setMathScore(85);//setmathScore에 메소드의 매개값을 넣음
		//기능실행함
		student.study();
		student.introduce();
		//값을불러올수있는 메소드를 생성해야함
//		System.out.println("이름: " + student.studentName+"영어:"+student.engScore+"수학:"+student.mathScore);
		System.out.println("이름: " + student.getStudentName()+",영어:"+student.getEngScore()+",수학:"+student.getMathScore());

		//생성자가 정의되어있어 사용가능
		Student student2 = new Student(1002,"김민규");
//		student2.studentNo = 1002;
//		student2.studentName = "김민규";
		
		//없는 값 넣을 경우 
		student2.setEngScore(-50);
		student2.setMathScore(-80);
		student2.study();
		student2.introduce();
		System.out.println("이름: " + student2.getStudentName()+",영어:"+student2.getEngScore()+",수학:"+student2.getMathScore());
		
		//값이바뀐거로 실행
//		student2.studentName = "박민규";//= "박민규";
		student2.setStudentName("박민규"); 
		student2.introduce();
		

	}
}
