package com.yedam;

import java.util.Scanner;

public class ObjectExe {
	public static void main(String[] args) {
		//호출.
	    
//		Calendar.showMonth();
		int year =18;
		String msg;
		Calendar.isLeapYear(year);
		//"2010년은 평년입니다."
		//"2000년은 윤년입니다."
		Scanner scn = new Scanner(System.in);
	    while(true) {	
	    	System.out.println("년도를 입력하세요.>>");
	    	msg = scn.nextLine();
	    	try {
	    		year = Integer.parseInt(msg);
	    	} catch(NumberFormatException e) {
//	    		System.out.println("잘못입력");
	    		if(msg.equals("q")) {
	    			break;	    			
	    		}
	    	}
	    	if(Calendar.isLeapYear(year)) {
	    		System.out.println(year+"윤년입니다");
	    	}
	    	else {
	    		System.out.println(year+"평년입니다");	    		
	    	}

	    }//end of while
    	System.out.println("윤년계산 끝");
    	scn.close();
	}
}
