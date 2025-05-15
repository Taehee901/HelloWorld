package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {
	
	
	//"가위(1)","바위(2)","보(3)"
	//컴퓨터가 만든 값 내가만든 값,math.random 123 <==>가위(1),바위(2),보(3)
	//누가 이겼는지 보여줌,같으면 비김
	//게임종료.4 break
	
	
	public static void main(String[] args) {
		// while vs do.. while
//		test();
		//컴 이기면"You lost","You win","Same"
	
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("가위(1),바위(2),보(3),4종료: ");
			int num = (int)(Math.random()*3)+1;
			System.out.println(num);
			int inp = Integer.parseInt(scn.nextLine());
			if(num == inp)
			{
				System.out.println("Same");
			}
	}
}
	
	
	
	
	
	
	
	
	public static void test() {
		boolean run = false;
//1실행
//		while(run = !run) {
//			System.out.println("while문");
//		}//end of while 
		
//		while(run) {//true일때 while문실행->n
//			System.out.println("while문");
//			run = !run;
//		}
		//System.out.println("end of porg.");

		//do 먼저(한번은 반드시) 실행 후 조건 체크
		//조건에따라 종료,break안해도
		do {
			System.out.println("while문");
			run = !run;
		} while (run = !run);//대입은 오른쪽부터,true이면 반복 아니면 패스
		System.out.println("end of porg.");
	}
}
