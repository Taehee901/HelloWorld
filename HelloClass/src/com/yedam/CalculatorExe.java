package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
	public static void main(String[] args) {
		// 메모리상에 실체를 생성하겠다.
		Calculator cal = new Calculator();// 인스턴스 생성,Calculator참조변수
		// 매개값으로몇개전달?
		int num1 = 10;
		String str = "😊";
//		cal.printStar(num1,str);//실제호출할때는 매개변수 times 매개값이 저장 선언들어가면 구문오류
//		cal.printStar();//x
		String result = cal.printStar(num1, str);// 값 반환해줘서 오류사라짐
//		System.out.println(result);

		// add,작은타입큰타입자동변환
		// Type mismatch: cannot convert from double to int
		double sum = cal.add(num1, 10.5);

		int[] numAry = { 10, 20, 30 };
		sum = cal.add(numAry);// 매개값 정수배열

		// Member[] 중에서 point가 큰 회원을 반환하는 메소드를 만듦.
		// 패키지 임포트
		Member[] members = { new Member("user01", "홍길동", "1111", 1000)//
				, new Member("user02", "김민규", "2222", 2200)//
				, new Member("user03", "황선홍", "3333", 2900)//
				, new Member("user04", "홍명보", "4444", 2700)//
		};

		// 반환유형(Member) int,double같은 데이터타입으로 생각, 매개변수(Member[])
		Member member = cal.getMaxPoint(members);

//		System.out.println(sum);
		//접근수준이낮아서안보임,패키지가 다르면 public을 줘야함,다른페이지 권한얻어야하기에 
		member.showInfo();
//		System.out.println("10");// 다양하게 전달가능한 이유는- println 메소드가 String,int,boolean 다양하게 정의되어있어 사용가능
//		System.out.println(10);
//		System.out.println(true);
//		System.out.println(sum);
	}
}
