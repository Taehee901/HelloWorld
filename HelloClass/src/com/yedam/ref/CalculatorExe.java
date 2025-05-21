package com.yedam.ref;

import javax.print.attribute.standard.PrinterStateReason;

/*
 * main 가진 실행 클래스.
 * */
public class CalculatorExe {
	public static void main(String[] args) {
		int a = 20,b = 30;
		
		//sum의 기능 활용.
		//하드웨어 불러들이는거생각
		//인스턴스 생성,실체를 메모리에 올려놓아야지 사용가능한데
		Calculator c1 = new Calculator();
		//인스턴스를생성해야불러올수있는걸 
		c1.sum(a, b); //정적메소드기에 방식대로사용해라라는의미
		
		//정적메소드
		Calculator.sum(a, b);//인스턴스를 안만들어도 메모리에 사용할 준비를해두어서 사용가능
		printStar();
		
//		Calculator ce = new Calculator();
//		//인스턴스를 만들어야지만 사용 가능
//		ce.printStar();
	
	}
	//없을경우 인스턴스를생성먼저하고 호출해야함
	//클래스가읽어들이는 시점에서 바로사용가능하면 정적메소드없는타입,메모리상 호출 준비 안되어있음
	 static void printStar() {
		System.out.println("*");
		//인스턴스만들어줘야함
	}
}
