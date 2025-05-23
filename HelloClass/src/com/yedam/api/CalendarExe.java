package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * 시간관련 클래스
 * Calendar : 날짜,시간 관련.
 * Date : 날짜,시간
 * 
 * */

//operatorExe
public class CalendarExe {
	public static void main(String[] args) {
		
		
		
	}
	//달력.	//입력하는 년도의 요일 만듦
	public static void makeCalendar(int year, int month) {
		//들어간값 달력이 나오도록
//		makeCalendar(2025, 05);
		//입력부분
		Scanner scn = new Scanner(System.in);
		System.out.println("년도 입력:");
		year = Integer.parseInt(scn.nextLine());
		System.out.println("월 입력:");
		month = Integer.parseInt(scn.nextLine());
		
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_WEEK, year);
		now.set(Calendar.DATE, month);
		
//		int fw = now.get(Calendar.DAY_OF_WEEK, year)
		
		
		
		
		
//		month = Integer.parseInt(scn.nextLine());
//		
//		for(int i = 1;i<month;i++)
//		{
//			System.out.printf("    %d년  %02d월 \n",year,month);
//			return;
//		}
//		
		
		
		
		//공락,해당되는날짜요일day_of_week
//		Scanner scn = new Scanner(System.in);
//		System.out.print("년 입력>>");
//		year = Integer.parseInt(scn.nextLine());
//		System.out.print("월 입력>>");
//		year = Integer.parseInt(scn.nextLine());

		
		
		
			System.out.printf("     %d년  %02d월 \n",year,month);
			System.out.println("============================");
			System.out.println("Sun Mon Tue Wed Thu Fri Sat");
			System.out.println("============================");
			System.out.println("-----------------------------");

	}
	
	

	public static void date() {
		Date today = new Date();//import util
		System.out.println(today.toGMTString());//취소선--이 메소드 사라질 수 있으니 주의해라
		System.out.println(today.toLocaleString());
		System.out.println(today.toString());
		
		//데이터포맷간단하게설정,//생성자의 매개값으로 포맷지정.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//생성자의 매개값으로 포맷지정.
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String timeStr = sdf.format(today); //Date타입 -> String(date타입을 String)
		System.out.println(timeStr);
		
		try {
			//String => Date
			today = sdf.parse("2025-08-01 09:00:00");//parse문자열을 date타입으로
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(today);
		
		//원하는타입값지정
		//2025년 05월 12일 13:22:38
	}
	public static void cal() {
	//Calendar 클래스
	Calendar now = Calendar.getInstance();//현재시스템시간을기준으로 calendar객체만듦
//		System.out.printf("년도 %d \n",now.get(1));//0 -> 1
		

		//시간변경
		now.set(2025, 0, 1);//0 = 1월,년월일
		now.set(Calendar.YEAR, 2024);//필드이름,변경값(상수)
		
		//요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		switch(dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:System.out.println("월요일");break;
		case 3:System.out.println("화요일");break;
		case 4:System.out.println("수요일");break;
		case 5:System.out.println("목요일");break;
		case 6:System.out.println("금요일");break;
		case 7:System.out.println("토요일");break;
		}
		
		
		System.out.printf("년도 %d\n,월:%d\n,날짜 %d\n,요일:%d\n 말일: %d\n",
				now.get(Calendar.YEAR),//년
				now.get(Calendar.MONTH),//월
//				now.get(1),
				now.get(Calendar.DATE),//일
				now.get(Calendar.DAY_OF_WEEK),//주
				now.getActualMaximum(Calendar.DATE)//마지막날
				);
	}
}
