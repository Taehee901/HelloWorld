package com.yedam;

import java.util.Scanner;

public class Calendar {
	static boolean isLeapYear(int year) {
		// 윤년이면 true 평년이면 false
		if ((year % 4 == 0 && year % 100 != 0) && year % 400 == 0) {
			return true;
		} 
		else {
			return false;
		}
	}
//		if(year % 4 == 0) {
//			if(year % 100 == 0) {
//				if(year % 400 == 0)
//				{
//					return true;
//				}
//			}
//			else {
//				return true;
//			}
//		}
//		return false;
//		boolean leapYear =true;
//		if(year %4 != 0) {
//			leapYear =false;
//		}
//		if(leapYear && year %100 == 0) {
//			leapYear = false;
//		}
//		if(!leapYear && year %400 != 0) {
//			leapYear = true;
//		}
//		return leapYear;
//	}
	static void showMonth() {
		// Sun Mon Tue Wed Thu Fri Sat
		// ============================
		// 1 2 3
		// 4 5 6 7 8 9 10
//		int mon = 5;
//		int lastDate = 31;
//		Scanner scn = new Scanner(System.in);
//		System.out.println("입력>>");
//		int str = Integer.parseInt(scn.nextLine());
//		System.out.printf("           <%d월>           ", mon);
//		System.out.println("\n==================================");
//		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
//		System.out.println("==================================");
		

	}
}