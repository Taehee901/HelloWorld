package com.yedam.api;

public class StringTest {
	// 실행메소드(main)
	public static void main(String[] args) {
		// 1)성별을 반환(남성/ 여성)
		String[] samples = { "9503061234567"//
				, "990603 2345678"//
				, "030502-3456789" };
		for (int i = 0; i < samples.length; i++) {
			//static 메소드\..문자반환하는기능
			String gender = StringUtil.getGender(samples[i]);//문자열 매개변수 타입
			System.out.printf("%s는 %s입니다.\n", samples[i], gender);
		}

		// 2)파일명의 확장자정보를 반환(파일확장자)
		// /위치
		String[] files = { "c:/temp/orange.jpg"//.위치반환
				, "d:/storage/test/grape.jpeg"//
				, "d:/img/melon.png" };
		// 배열에 저장된 파일명에 해당하는 확장자(jpg, jpeg, png) 구하기.
		for (int i = 0; i < files.length; i++) {
			System.out.printf("파일의 확장자는 %s입니다.\n ", StringUtil.getExtName(files[i]));
		}
	} // end of main.
}
