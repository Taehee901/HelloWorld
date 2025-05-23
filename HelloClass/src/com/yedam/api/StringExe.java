package com.yedam.api;

import java.nio.charset.Charset;

public class StringExe {
	public static void main(String[] args) {
		String str1 = new String("Hello");// == String str1 = "Hello";
		//new 클래스(),생성자
		
		//바이트배열을 선언(아스키값 72 == H)
		//0~2자름
		
		//몇번째글자..
		System.out.println(str1.charAt(0));//"",''
		
		//문자위치반환
		System.out.println(str1.indexOf("s"));//값이 없으면 -1,값이 있으면 해당 위치
		
		
//		str1 = new String(new byte[] {72,101,108,108,111},0,2);//윗 방식이랑 같다		String str1 = new String("Hello");
		System.out.println(str1);
		
//		String st1 = new String("가");
//		String st2 = "신민철";
//		String st3 = "신민철";
//		System.out.println(st2 == st3);

		
		
	}
}
