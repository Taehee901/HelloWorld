package com.yedam.ref;
//
public class NullExe {
	// 널값참조
	public static void main(String[] args) {
		String str1 = "홍길동";//new String("홍길동")new String("홍길동");
		//문자열(객체)주소값-힙영역에서 문자열 값가지고있는거 할당,"홍길동"편의를 위해 가능하도록
		String str2 = null;//참조값없음,NullPointerException(예외)://널값참조오류
		//toString->
		//실행예외
	//can not  null 객체정보없는상황에서값의실행메소드보겠다.(잘못적은듯)
		//System.out.println(str2.toString());
		//배열
		//데이터타입이정해지면동일한데이터타입만담는다,정-정,for사용편함
		//자바스크립트는 let ary = [10,"string",11.2]가능
		
		//자바배열선언방식 =>클랙션?
		int num1 = 10;
		int[] ary = {10,20,30};//변수선언과 초기화.
		System.out.printf("ary배열의 크기 %d\n",ary.length);
		int[] intAry;//변수선언
		//값추가시 변수에 새로선언-값할당
		intAry = new int[] {40,50,60};//new 데이터타입만듦(객체 만듦),값 할당.
		//값변경
		//첫번째 위치의 40 =>400변경
		intAry[0] = 400;
		
		//index잘못작성오류핸들링오류
		//인덱스 3 =>4번째 위치
		//자바스크립트는 값 추가하면 증가가능,가능자바는배열크기고정 변경불가
		//ArrayIndexOutOfBoundsException:->배열크기벗어난 값 입력시 발생하는 오류
//		intAry[3] = 10;
		intAry[2] = 10;
		
		
//		intAry = {40,50,60}//(x);
		//{10,20,30};//정수담는배열,int[] 데이터타입,ary정수담는배열타입,
		//int[] ary = 10;(er),= int ary[] ={...} 같음
		
		
		//반복문(for)
		for(int i = 0;i<3;i++) {//0,1,2
//			intAry[i];
			System.out.printf("[%d]번째의 값: %d\n",i,intAry[i]);
		}
		
		//배열은 선언하면 크기가 고정.
		//크기가 변경하려면 새로 선언.
		intAry = new int[5];
		intAry[0] = 40;
		intAry[1] = 50;
		intAry[2] = 60;
		intAry[3] = 10;

//		for(int i = 0;i<5;i++) {//0,1,2
		for(int i = 0; i<intAry.length; i++) {
//			intAry[i];
			//배열초기값 = 0
			System.out.printf("intAry[%d]번째의 값: %d\n",i,intAry[i]);
		}

		//배열선언:datatype-double로해봄
		//배열선언:double 값을 담는 배열 dblAry
		//10.2,23.2,34.5
		//실수초기값은 0.0
		double[] dblAry = {10.2,23.2,34.5};
		for(int i = 0 ;i < dblAry.length; i++) {
			System.out.printf("dblAry[%d]번째의 값: %.1f\n",i,dblAry[i]);
		}
		
		//참조데이터타입
		//문자열 초기값은 null
		String[] strAry = new String[10];//{"Hello","World"};
		for(int i = 0;i<strAry.length;i++) {
			System.out.printf("strAry[%d]번째의 값: %s\n",i,strAry[i]);
		}
		
		
	}
	
}
