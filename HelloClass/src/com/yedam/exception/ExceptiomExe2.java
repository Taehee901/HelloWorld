package com.yedam.exception;

import java.util.NoSuchElementException;
//java lang에 있던거라
import java.util.Scanner;

public class ExceptiomExe2 {

	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);//사용자값입력하면그값을엔터시점에가져옴
		boolean run = true;

		while (run) {
			System.out.println("1.메뉴 2.종료");
			System.out.println("선택>>");
			int menu = 0;
			// 예외 검,값잘못넣을경우
			
			while(true) {//적절한 값을 선택할때까지 계속반복한다.
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException | NoSuchElementException e) {
					System.out.println("1.메뉴 2.종료");
					System.out.println("메뉴를 다시 선택...");
//					scn.nextLine();
					continue;//정상적실행위해
				}
//				}catch(NoSuchElementException e) {
//					System.out.println("1.메뉴 2.종료");
//				}
				//정상적인 실행.
				break;//정상적코드넣어 예외발생안하면 정상적인 실행
			}

			switch (menu) {
			case 1:
				백업();
				break;
			case 2:
				run = false;
				break;
			default://다른값들어올경우
				System.out.println("없는 메뉴를 선택해서 종료합니다.");
				run = false;
			}
		}
		System.out.println("end of prog");
//		호출된메소드에서 close하니 영역에서 NoSuchElementException 문제.가발생해서 ?
		scn.close();//전체프로그램끝나고나서함
	}//end of main();

	public static void 백업() {
		// NullPointerException
		// NumberFormatException
		// ClassCastExeception
		// ArrayIndexOutOfBoundsExeception
		// Resource leak: 'scanner' is never closed
		Scanner scanner = new Scanner(System.in);// 외부의연결을하기위한클래스를 리소스,한번선언사용하면환원해줘야함->사용하고나면 close메소드로

		String str = scanner.nextLine();
//		String str = "Hello";
//		String str = null;// 아무값도없는상태인데 값이있는것처럼할경우
		try {
			System.out.println(str.toString());
			int num = Integer.parseInt("a");// a를 맞는 포맷이아닐경우 -- 처리못해줌//리소스환원과상과없음

		} catch (NullPointerException | NumberFormatException e) {// 예외를 맞는걸로 걸어줘야한다,cathch구문은 여러개들어가도상관없음,병렬로한번에가능하고
																	// 2줄로가능
			System.out.println("Null 값을 참조.");
//		} catch (NumberFormatException e) {
//			System.out.println("포맷이 비정상");
//		}
		} finally {//while문 nextline영향미침
			// 정상실행,예외발생 반드시실행해야할코드
			// 리소스를환원.
			// 정상실행,예외발생이든 반드시 실행해야할 코드.
//			scanner.close();// 리소스를 메모리를 관리해주는 프로그램에다 환원,심각한오류는아니지만..메모리누수..닫아주는게 나음
		}
		System.out.println("end of prog");
	}
}
