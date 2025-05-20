package com.yedam;

import com.yedam.member.Member;

/*
 * 메소드 연습
 * 1)메소드의 선언.
 * 2)매개변수.
 * 3)반환유형.
 * */
public class Calculator {
	//필드.
	
	//생성자.
	
	//메소드. printStar()이름
	//printStar는 class가 가지고 있는 멤버
	//void 아무것도리턴값안함리턴값없다.
	//어떤값이올지모르지만 times에저장해서 printStar에만 사용
	//String 매개유형
	String printStar(int times,String shape){//(times) 매개변수 선언
		String str = "";
		for(int i = 1;i<=times;i++) {
			//+ "\n"줄바꿈
//			System.out.println(shape);//매개값이뭔지매개값들어오는거 다 출력,"*"였는데	
			str += shape + "\n";//누적,times갯수만큼반복
		}
		return str;
	}//end of printStar
	
	//더하기
	//리턴타입이 없으경우에러
	//메소드이름은 다른데 여러번 중복가능한데 매갯값 갯수나 유형이 달라야지 가능.
	//같은타입이 오는거로는 의미가 없다
	//메소드 오버로딩(반환되는타입은포함되지않는다),타입만테크
	int add(int num1,int num2){
		return num1 + num2;
	}
	//java+oracle = jdbc
	//매개변수타입이 다르거나 갯수가 다를 경우에는 똑같은 메소드이름을사용해서정의가능하다
//	double add(int str1,int str2,int str3){
//		return str1 + str2+str3;
//	}
	double add(double num1,double num2) {
		return num1+num2;
	}
	//정수배열을 매개값으로 받는 add.반환타입은 double
	double add(int[] ary) {
		int sum = 0;
		for(int i = 0;i<ary.length;i++) {
			sum += ary[i];
		}
		//int -> double타입으로 자동형번환
		return sum;
	}
	//ArrayExe3 if(max <stdAry[i].height
	//배열에서 point가 제일 큰 사람을 찾아서 반환
	Member getMaxPoint(Member[] memberArray) {
		//결과값.
		Member max = null;
		int maxPoint = 0;
		int sum = 0;
		for(int i = 0;i<memberArray.length;i++) {
//			Member temp = memberArray[i];//변수선언해서첫번째값가져옴
//			if(maxPoint<temp.getPoint()) {
//				maxPoint = temp.getPoint();//비교용도
//				max = temp;//타입이같아서할당가능
			//최대포인트를 가진 회원의 정보 max저장.
//			}
			if(maxPoint<memberArray[i].getPoint()) {
				maxPoint = memberArray[i].getPoint();
				sum += maxPoint;
				max = memberArray[i];
			}
			
		}
		double avg = 1.0*sum/memberArray.length;
		return max;
	}//end of getMaxPoint,
}
