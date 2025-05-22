package com.yedam.exception;

/*
 * 1)일반예외 - 컴파일러가 에러부분을 파악.
 * 2)실행예외 - 실행시점에 에러가 발생하는 경우.(신경)
 * */
public class ExceptionExe {
	public static void main(String[] args) {
		String numStr = "a";
		int num = 0;
		try {//자바는 블록레벨의 //
			num = Integer.parseInt(numStr);//에러발생			
		}catch(NumberFormatException e) {
			//catch예외발생시 대체할 코드 필요
			//예외가 발생하면 대체할 코드
			System.out.println("일반예외발생.");
		}
		System.out.println(num);	//바꾼값아닌초기값		
		
		//반드시예외처리필요
		//실행했을때 일반예외는안뜨는이유=정상적인 값을넣어서발생안하고 Class.forName("java.util.Scanner11");일경우 콘솔에예외발생
//		try {//try catch..에러면 원래강제종료인데,catch부분실행
		try {
			Class.forName("java.util.Scanner");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//에러인거알려주는거지(예외 발생 시 예외 메시지와 함께 호출 스택 정보를 출력해주는 메소드)
		}//scanner가 java패키지안에있는지 확인하고 반환,없을경우 에러
//		}catch(ClassNotFoundException e)//CNE포함된 클래스다보여줌
//		{
//			System.out.println("일반예외발생.");
//		}
		System.out.println("end of prog");
	}
}
