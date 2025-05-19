package com.yedam.ref;

//객체방식-c++,java(로직은어려워..)

/*
 * 배열 + 기본타입: 정수,실수
 * 배열 + 참조타입(클래스) = data 지금은 이렇게 생각
 * :학생이름,점수
 * */
public class ArrayExe3 { //class시작부분
	
	//class 변수 선언
	static Student[] stdAry;//class범위선언되어있어서 어디든지 사용가능
	//
	public static void main(String[] args) {
		//init 제일 먼전 선언 값을 가져옴
		init();
		int sum = 0;
		double max = 0;
		Student maxStd = new Student();//인스턴스 생성.빈공간 하나 생성,많은정보를다담을수있음,변수선언보다나음
		//배열의 값을 출력.
		for(int i = 0;i<stdAry.length;i++) {
			System.out.printf("이름:%s 점수:%d \n",stdAry[i].studentName,stdAry[i].score);
			sum += stdAry[i].score;//합계구하는방식
			if(max <  stdAry[i].height) {//가장큰키,키큰학생
				max = stdAry[i].height;//max로해도됨 max안쓰고 maxStd.score로 해도됨
				
				
				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height= stdAry[i].height;
				maxStd.gender=stdAry[i].gender;
				
//				maxName = stdAry[i].studentName;//최고점수를받은사람이름가져오는방식
			}
		}
		double avg = 1.0 * sum /stdAry.length;
//		System.out.printf("최고점수: %d ,평균: %.2f,최고점학생: %s",max,avg,maxName);
		String strFmt = "키가큰학생: %s, 점수: %d,키:%.1f,평균: %.2f";
		System.out.printf(strFmt,maxStd.studentName,maxStd.score,maxStd.height,avg);
		
		
		
		
		
//		int max = 0;
////		String maxName = "";
//		Student maxStd = new Student();//인스턴스 생성.빈공간 하나 생성,많은정보를다담을수있음,변수선언보다나음
//		//배열의 값을 출력.
//		for(int i = 0;i<stdAry.length;i++) {
//			System.out.printf("이름:%s 점수:%d \n",stdAry[i].studentName,stdAry[i].score);
//			sum += stdAry[i].score;//합계구하는방식
//			if(max <  stdAry[i].score) {//최고점수,최고점학생
////				max = stdAry[i].score;//max로해도됨 max안쓰고 maxStd.score로 해도됨
//				maxStd.studentName = stdAry[i].studentName;
//				maxStd.score = stdAry[i].score;
////				maxName = stdAry[i].studentName;//최고점수를받은사람이름가져오는방식
//			}
//		}
//		double avg = 1.0 * sum /stdAry.length;
////		System.out.printf("최고점수: %d ,평균: %.2f,최고점학생: %s",max,avg,maxName);
//		String strFmt = "최고점수학생: %s, 최고점수: %d,평균: %.2f";
//		System.out.printf(strFmt,maxStd.studentName,maxStd.score,avg);
		
	}//블록 단위로 선언된 녀석들은 그 안에서만 사용가능함
	
	//student 데이터 담아둠
	public static void init() {
		Student s1 = new Student();//인스턴스를 생성해야 값담음
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;//"남자","Men",문자타입아니라 열겨형이라 "남자"->Gender.MALE
		
		Student s2 = new Student();//인스턴스 생성.
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE;
		
		Student s3 = new Student();//인스턴스 생성.
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 180.3;
		s3.gender = Gender.MALE;
		
		stdAry = new Student[] {s1,s2,s3};//변수선언동시에 값할당할때는없어도되는데,stdAry = {s1,s2,s3};, 배열에 s1~s3값을 담아 할당
	}
	

	
	public static void test() {
		//테스트 매소드안에서만사용할수있다.,테스트안에서만 의미있는값
		//클래스는 s1 인스턴스의주소값
		//홍길동,80
		//int(데이터타입) num1 = 90;
		//바로값담는게 아닌인스턴스만드는작업필요
		//생성자호출
		int num1 = 90;
		Student s1 = new Student();//물리적공간만듦 - 인스턴스 생성,클래스는 new 값을 담을 수 있는 공간을 만들어야함,바로 못담음
		s1.studentName = "홍길동";//s1.참조하는주소값을 변경한거,값이 바뀐게 아니라
		s1.score = 80;
//		System.out.printf("s1[%s][%d]\n",s1.studentName,s1.score);
		
		//김민규,85 =>s2 변수에 담음
		Student s2 = new Student();//new 클래스이름()-값담을 저장공간만듦
		s2.studentName = "김민규";
		s2.score = 85;
//		System.out.printf("s2[%s][%d]",s2.studentName,s2.score);
		
		
		//홍길동담고있는 
		//홍길동의 점수를 90 변경ㅡㅜ                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		s1.score = 90;
		
		//학생정보를 배열에 저장
		Student [] students = {s1,s2};
		students[0].studentName = "홍길도";//s1 = students[0] 주소값이같음
//		System.out.println(s1.studentName);
		System.out.printf("이름: %s, 점수: %d\n",s1.studentName,s1.score);
	}
	
}
