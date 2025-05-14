package com.yedam;

public class JSExe {
	//반드시 main메소드만있어야하는건아니다
	public static void main(String[] args) {
		//임의의 수를 생성,1~10사이의 임의의 값 생성.
		//1<=x<11,데이터타입변환 프로모션
		int sum = 0;
		for(int i=1;i<=5;i++)
		{
			int result=(int)(Math.random()*10)+1;	//0<=x<1 ->0<=x<10 실수타입	
			sum += result;
		}
		System.out.println("결과: " +sum);
	}


public static void test() {
	int sum = 0;
	for(int i = 1;i<=10;i++) {
		if(i%2 == 1)//홀수
		{
			sum += i;
		}
	}//end of test
	
}//end of class

