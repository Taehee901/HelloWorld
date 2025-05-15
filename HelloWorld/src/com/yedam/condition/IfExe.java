package com.yedam.condition;

import java.util.Scanner;

public class IfExe {
	
	public static void main(String[] args) {
//		test();
		//1~1000사이의 임의의 값을 생성.randomValue = 567
		//사용자가 500입력하면 입력값보다 큽니다(scanner),"입력값보다 작습니다"
		//정답맞추면 "정답입니다" 프로그램종료,while
		//시도한 횟수,5보다 적으면 똑똑합니다.
		Scanner scn = new Scanner(System.in);
		int randomValue = (int)(Math.random()* 1001)+1;
		System.out.println(randomValue);
		int count =0;
		while(true) {
			System.out.println("입력>>");
			int menu = Integer.parseInt(scn.nextLine());
			if(randomValue < menu) {
				System.out.println("입력값보다 큽니다");
				count ++;
			}
			else if(randomValue > menu) {
				System.out.println("입력값보다 작습니다");
				count ++;
			}
			else {
				System.out.println("정답입니다.");
				break;
			}	
		}
//		System.out.println("시도한 횟수"+count);
		if(count < 5) {
			System.out.println("임의의 값은 "+randomValue+" ,시도한 횟수: "+count+" ,아주 똑똑합니다");
		}
		else {
//			System.out.println("좀 더 노력하세요");
			System.out.println("임의의 값은 "+randomValue+"시도한 횟수: "+count+" ,좀 더 노력하세요");
		}
	}
	
	
	
	
	
	
	
	public static void test() {
		int score = 85;
		
		//if 먼저나온거체크 >= 70보다 다 크니 c
//		if(score >= 90) {
//			System.out.println("A학점");
//		}else if (score >= 80) {
//			System.out.println("B학점");
//		}else if (score >= 70) {
//			System.out.println("C학점");
//		}else {
//			System.out.println("불합격");
//		}
		//ABC
//		if(score >= 90) {
//			System.out.println("A학점");
//		} if (score >= 80) {
//			System.out.println("B학점");
//		} if (score >= 70) {
//			System.out.println("C학점");
//		}else {
//			System.out.println("불합격");
//		}
		score = score/10;//9.5소수점버림
		switch(score) {
			case 10:
			case 9:	
				System.out.println("A학점");
				break;
			case 8:	
				System.out.println("B학점");
				break;
			case 7:	
				System.out.println("C학점");
				break;
			default://else
				System.out.println("불합격");
		}//end of switch
	}
}

