package com.yedam;

import java.util.Scanner;
//
public class JSExe {
	// 반드시 main메소드만있어야하는건아고main순자척진행
	public static void main(String[] args) {
//		test2();//평균

		int num1 = 30;
		int num2 = 30;
		// 기본데이터유형
//		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
//		System.out.println(str1);
//		System.out.println(str2);

		// "30" vs .30
		// 데이터타입이 다르면 둘 중 하나를 같은 데이터타입으로 변경
		String str3 = "30";
		int num3 = 30;
		// ""아무값없다 문자열로 바꾼다는 의미
		// "one" 문자열이라 안되는데 숫자를 문자열로가지고있는건 가능
//		System.out.println(str3.equals("" + num3));
		// integer
		// parseInt는 문자열을 숫자타입(int)변환
		int num4 = Integer.parseInt(str3);// 문자열을 숫자로 변환
//		System.out.println(num3 == num4);// 30vs . "30" ->30(문자열30이 숫자30으로 바꿔줌)
		// 객체주소가지고있으면 참조변수
		// 문자열을 비교할 경우에는 메소드 equals를(비교할매개값) 사용해야한다,==일 경우 false(비교연산자사용할경우)
//		System.out.println(str1.equals(str2));
//		String str1 = "Hello";

//		test2();//평균을 구하기,테스트2메서드호출
//		test3();//스캐너 사용.
//		test4();
		test5();
		// 변경된 부분.
		// https://hgko1207.github.io/2020/05/18/eclipse-git-clone/
		// 충돌연습(원격,로컬)-로컬 team - commit

		// 임의의 수를 생성,1~100사이의 임의의 값 생성.
		// 1<=x<11,데이터타입변환 프로모션
//		//int sum = 0;
//		//1~10까지의 값을 누적하는 반복문
//		for(int i = 1;i<=5;i++) {
//			sum += i;
//		}
//		for(int i = 1;i<=10;i++) {
//			if(i%2 == 1)//홀수
//			{
//				sum += i;
//			}
//		}
//		System.out.println("결과: " +sum);
		// test();
		// }//end of main.
//		int sum = 0;
//		for(int i=1;i<=5;i++)
//		{
//			int result=(int)(Math.random()*100)+1;	//0<=x<1 ->0<=x<10 실수타입	
//			sum += result;
//		}
//		System.out.println("결과: " +sum);

	}// end main
//java.lang.System =>기본패키지라 생략가능

//	<소 >대
	
	
	public static void test5() {
		//printf("형식문자열",값1,값2...)
		//print옆으로 출력,println ->줄바꿈포함출력
		//printf ex) "%s","문자",뒤에오는문자값을 받아옴,\n
		//d-인수값받아옴,s-문자
		System.out.printf("%s %d\n %.2f\t","문자",30,30.3);
		System.out.println("문자");
		
		//첫번째매개값 "홍길동",100,23.9
		System.out.printf("%s\n %d\n %.1f\n","홍길동",100,23.9);
		//안녕하세요. 이름은 이창호입니다.
//		System.out.printf("%s\n %s %d %s\n %s %.1f %s",
//				           "안녕하세요. 이름은 이창호입니다.",
//				           "나이는",20,"세 입니다.",
//				           "몸무게는",67.8,"입니다.");
		//------
		String formatStr ="안녕하세요.%s입니다.\n";
		formatStr += "나이는 %d세입니다.\n";
		formatStr += "몸무게는 %.1f입니다\n";
		System.out.printf(formatStr,"이창호",20,67.8);
//		System.out.printf("%s\n","안녕하세요. 이름은 김태희입니다.");
//		//나이는 20세 입니다.
//		System.out.printf("%s %d %s\n","나이는",20,"세 입니다.");
//		//몸무게는 67.8입니다.
//		System.out.printf("%s %d/n","");
	}
	
	
	public static void test4() {
		// 몇번반복할지모르겠지만사용자가입력한값까지
		Scanner scn = new Scanner(System.in);
		String str = "친구목록은 ";
		// 값이첫번째조건일때실행
		boolean isfirst = true;
		while (true) {
			System.out.println("친구이름 입력,종료하려면 quit>>");
			String msg = scn.nextLine();
			// equals로 비교
			if (msg.equals("quit")) {
				str += " 입니다";
				break;
			}
//			System.out.println("입력한값은"+msg);
			// if조건문 이용해서 콤마삭제
			if (isfirst) {
				str += msg;
				isfirst = false;
			} else {
				str += ", " + msg;
			}
			//commit 안하면 pull
		}
			// 홍길동,김민규,최석영
			// 친구목록은 홍길동,김민규,최석영(입력한이름갯수만큼나오게하는게) 입니다.
			System.out.println(str);
			System.out.println("end of prog.");
		 // end test4
	}

	public static void test3() {
		// 사용자의 입력값을 읽어들이기
		// import,풀네임,ctrl+shfit+o
//		java.util.Scanner scn;
		// system = 자바프로그램,system.in = 키보드.입력한값,system.out=모니터라고생각하면됨
		Scanner scn = new Scanner(System.in);
		// 앞 두개는 패키지이름
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
//		System.out.println("친구의 이름을 입력>>"); = console.log
			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine();// 입력값을 문자열형태로 반환.(커서의시작부터엔터전까지입력한것들)
			int score = Integer.parseInt(value);// 102030-안쓸경우는
			sum += score;

		} //
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계 :" + sum + ", 평균: " + avg);

//		System.out.println("입력값은 " + value);

	}// end of test3

	public static void test2() {
		// 임의의 수를 생성,1~100사이의 임의의 값 생성.
		// 1<=x<11,데이터타입변환 프로모션
//	//int sum = 0;
//	//1~10까지의 값을 누적하는 반복문
//	for(int i = 1;i<=5;i++) {
//		sum += i;
//	}
//	for(int i = 1;i<=10;i++) {
//		if(i%2 == 1)//홀수
//		{
//			sum += i;
//		}
//		public static void test() {
//			int sum = 0;
//			for (int i = 1; i <= 10; i++) {
//				if (i % 2 == 1)// 홀수
//				{
//					sum += i;
//				}
//			} // end of test
//	}
//	System.out.println("결과: " +sum);
		// test();
//}//end of main.

	//	// math random = 0* 100<=x<1* 100
		// 임의의 수를 생성. 30~100사이의 임의의값 생성.
		// 평균:173/5=>34.6
//		int sum = 0;
//		for (int i = 1; i <= 5; i++) {
//			int result = (int) (Math.random() * 100) + 1; // 0<=x<1 ->1<=x<11 실수타입
//			sum += result;
//		}
		// System.out.println("결과: " + sum);
		// 디버깅상태,더블클릭여기서멈춤
		// 평균:173.0*1.0/5.0 =>34.654
		// 정수/정수-정
//		int sum = 0;
//		
//		for (int i = 1; i <= 7; i++) {
//			int result = (int)(Math.random() * 71) + 30; // 0<=x<1 ->1<=x<11 실수타입
//			System.out.println(result);
//			sum += result;
//		}
//		double fsum = sum/7.0;
//		//round소수점자릿수반올
//		fsum = Math.round(fsum * 100)/100.0;
////		System.out.println(sum);
//		System.out.println("합계 :"+sum+", 평균: " + fsum);

		// 평균값 2자리 소수점(100.0실수로) round 반올림 100 자릿수 10.0한자리
//		System.out.println(Math.round(fsum * 100)/100.0);
	}// end of test2.
}// end of class
//	}//end of test
//  }
//}//end of class
