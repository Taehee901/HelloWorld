package com.yedam.ref;
/*
 * 라이브러리역할 클래스
 * 
 * */
public class Calculator {
	//인스턴스 안만들어도 클래스가 메모리를읽어들이는 시점에 sum 메모리상에 준비되어있어 바로사용가능(static)
	static int sum(int num1,int num2) {
		return num1+num2;
	}
}
