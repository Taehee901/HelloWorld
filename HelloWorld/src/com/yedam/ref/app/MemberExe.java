package com.yedam.ref.app;

import java.util.Scanner;

import com.yedam.ref.Student;

/*
 *회원 추가,수정,삭제,조회 기능.
 *1)추가
 *- 아이디,이름,전화번호,포인트
 *
 * 2)수정
 * -아이디 물어보고(조회),전화번호 바꿈(바뀔항목)
 * 
 * 3)삭제
 *  - 아이디
 *  -없을경우 찾는 아이디 없습니다 출력
 *  
 *  4)조회
 *  -이름(조회)
 * */
public class MemberExe {
	static Member [] member; 
	public static void main(String[] args) {
		boolean run = true;
		Member [] bas = new Member[20];
		Scanner scanner = new Scanner(System.in);
		while(run) {
			System.out.println("------------");
			System.out.println("1.회원 추가 | 2.수정 | 3.삭제 | 4.조회 | 5.종료");
			System.out.println("------------");
			System.out.println("입력>>");
			int selectNo = Integer.parseInt(scanner.nextLine());
			if (selectNo == 2 || selectNo == 3 ||  selectNo == 4) {
				continue;
			}
			if(selectNo == 1) {
				System.out.println("회원 아이디 입력>");
				String id = scanner.nextLine();
				System.out.println("회원 이름 입력>");
				String name = scanner.nextLine();
				System.out.println("전화번호 입력>");
				String phone = scanner.nextLine();
				System.out.println("포인트 입력>");
				int point = Integer.parseInt(scanner.nextLine());
				
				Member members = new Member();
				members.id = id;
				members.name = name;
				members.phone = phone;
				members.point = point;
				
				//배열저장
//				for(int i = 0)
			}
			else if(selectNo == 2) {
			}
			else if(selectNo == 3) {
				
			}
			else if(selectNo == 4) {

			}
		}System.out.println("프로그램 종료");
	}
}
