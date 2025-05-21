package com.yedam;

import java.util.Scanner;

public class Calendar {
	static void showMonth() {
		// Sun Mon Tue Wed Thu Fri Sat
		// ============================
		// 1 2 3
		// 4 5 6 7 8 9 10
		int mon = 5;
		int lastDate = 31;
		Scanner scn = new Scanner(System.in);
		System.out.println("입력>>");
		int str = Integer.parseInt(scn.nextLine());
		System.out.printf("           <%d월>           ", mon);
		System.out.println("\n==================================");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("==================================");
	}
}