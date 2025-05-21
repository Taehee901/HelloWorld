package com.yedam.ref;

import java.util.Scanner;
//
public class ArrayExe {
	public static void main(String[] args) {
//		strAry();
//		deleteAry();
		friendApp();
	}
//public외부클래스접근바로가능 privite 내부에서접근가능static클래스가 메모리읽어들이는시점사용가능 void는 리턴되는값이없다,반환안하고실행끝
	public static void friendApp() {
		Scanner scn = new Scanner(System.in);
		String[] friendAry = new String[10];
		// ui도가능한데공부해야함,dos방식
		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.println("선택>>");

			// 메뉴선택.
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:// 친구추가.
					// 동일한 이름이 있는 지 확이하고
					// "추가하겠습니까?"확인 후 추가(1)/취소(2)
				System.out.println("이름입력>>");
				String name = scn.nextLine();
				// 배열에 추가.
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] == null) {
						friendAry[i] = name;
						System.out.println("친구이름 입력완료");
						break;//이름배열이 n개일 경우 같은이름존재하면 n만큼돌아야하는데 앞의거 보면 되니
					}
//						else {
//						System.out.println("추가하겠습니까?1.입력 2.취소");
//						menu = Integer.parseInt(scn.nextLine());
//					}

				}
				break;
			case 2:// 목록
				System.out.println("목록>>");
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.printf("친구목록: %s\n", friendAry[i]);
					}
				}
				break;
			case 3:// 삭제
					// 찾는 이름이 없을 경우 "찾는 이름이 없습니다."
				System.out.println("삭제이름>>");
				name = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i].equals(name)) {
						friendAry[i] = null;
				}
				if(friendAry[i] != null) {							
					System.out.printf("친구목록: %s\n", friendAry[i]);
				}
				else if(friendAry[i]!= null&& !friendAry[i].equals(name)) {
					System.out.println("찾는이름이 없습니다.");
				}
			}
				break;
			case 4:
				run = false;
				break;
			}// end of switch
		} // end of while
		System.out.println("end of prog.");
		// end of friendApp
	}

	// 배열삭제
	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		// 배열선언.
		String[] stringAry = new String[10];
		stringAry[0] = "홍길동";// 홍길동을 삭제하고 싶다 ->null을 넣어주면 지우는의미
		stringAry[1] = "김친구";
		stringAry[2] = "김태완";
		stringAry[3] = "김태희";

		System.out.println("삭제할 친구 이름>>");
		String name = scn.nextLine();
		// 삭제할 친구이름을검색
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {// null.equlas에러강제종료,stringAry[i] != null
				stringAry[i] = null;// 삭제
			}
		}
		// 입력값 출력
		for (int i = 0; i < stringAry.length; i++) {
			// 널이아니면출력
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog.");// while문 종료조건이 있어야 오류사라짐

	}

	// 문자열배열.
	public static void strAry() {
		Scanner scn = new Scanner(System.in);
		// 배열선언.
		String[] stringAry = new String[10];// 입력값을 저장.

		while (true) {
			System.out.println("이름을입력>> ");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break;// while문 종료
			}

			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간(null) 이 있는지 확인 후 추가
				if (stringAry[i] == null) {
					stringAry[i] = name;// 한건추가
					System.out.println("입력성공.");
					break;// for문 종료
				}

			} // end of for
		} // end of while
			// 입력값 출력.
		for (int i = 0; i < stringAry.length; i++) {
			// 널이아니면출력
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog.");// while문 종료조건이 있어야 오류사라짐
	}// end of main.
}// end of class.
