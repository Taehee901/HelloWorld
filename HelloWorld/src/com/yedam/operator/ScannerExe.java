package com.yedam.operator;//패키지안에다

import java.util.Scanner;

public class ScannerExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
// 은행-계좌1
//		while (true) {//몇번반복할지안정하면
//			System.out.println("1.메뉴 2.매뉴 3.메뉴 4.종료");
//			int menu = Integer.parseInt(scn.nextLine());// 문자열을 정수로 바꿈 integer.parseInt(30)//입력넣을때까지기다림
//			if (menu == 1) {
//				System.out.println("1번메뉴를 선택했습니다.");
//			} else if (menu == 2) {
//				System.out.println("2번메뉴를 선택했습니다.");
//			} else if (menu == 3) {
//				System.out.println("3번메뉴를 선택했습니다.");
//			} else if (menu == 4) {
//				System.out.println("프로그램을 종료합니다.");
//				break;
//			}
//			else {
//				System.out.println("1 ~ 4번중에 선택하세요.");
//			}
//		}// end of while
		
		//다시해봐야함
		//은행
		int balance = 0;//계좌의 금액.
		int money = 0;
		// 조건추가..10만원을 초과(x),마이너스금액(x)
		while (true) {//몇번반복할지안정하면
		System.out.println("1.입금 2.출금 3.잔액 4.종료");
		int menu = Integer.parseInt(scn.nextLine());// 문자열을 정수로 바꿈 integer.parseInt(30)//입력넣을때까지기다림
	
		if (menu == 1) {
			//입금기능구현
			System.out.print("입금액을 입력>>" );
			money = Integer.parseInt(scn.nextLine());
			if ((balance + money) > 100000) {//10만원 조건문
				System.out.println("10만원초과");
			} else {
//				balance+= Integer.parseInt(scn.nextLine());
				balance += money;
			}
			System.out.println(balance);	

		} else if (menu == 2) {
			System.out.print("출금액을 입력>>" );
			money = Integer.parseInt(scn.nextLine());
			if(balance < money) {
				System.out.println("마이너스금액은 안됩니다.대출을권해드릴까요?");
			}else {
				balance-= money;
			}
			//출금기능구현
		} else if (menu == 3) {
				System.out.println("현잔액>>"+balance);				
			//잔액기능구현
		} else if (menu == 4) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		else {
			System.out.println("1 ~ 4번중에 선택하세요.");
		}
	}// end of while
		System.out.println("end of prog.");
	}
}//end of main
