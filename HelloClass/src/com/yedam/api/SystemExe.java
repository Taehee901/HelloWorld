package com.yedam.api;

public class SystemExe {
//
	public static void main(String[] args) {
		
		
		long now = System.currentTimeMillis();//현재시간을 1/1000초 단위.
//		System.out.println(now);
		//1747964906 => 60초 1분 3006초 1일 총 몇일 인지 계산하고 싶음
		//"초" =>몇일,몇시간,몇분,몇초
		//365 몇년
		// 60 *60 == 1시간
		//60 * 60 * 24 = > 1일
		//남는값 60*60 => 1시간
		//60 => 1분 
		//나머지가 초.
		//계산
		long time = 1747964906;
////		int times = (int)time;
//		long day = time/(60*60*24);
//		System.out.println(day);
//		long hour = time%(60*60);
//		System.out.println(hour);
//		long min = hour/3600;
//		System.out.println(min);
//		
//		//if
		
		long years = time /(60*60*24*365);
		long days = time %(60*60*24*365);
		days = days/(60*60*24);
		long hours = time %(60*60*24*365);
		hours = hours/(60*60);

	}
		public static void exe() {
		
		//초

		//
		long start = System.nanoTime();//System.currentTimeMillis()
		int sum = 0;
		for(int i = 0;i<100000000;i++) {
			sum += i;
		}
		//1초 10억분의 1 nanoTime
		long end = System.nanoTime();//System.currentTimeMillis() 1000/2
		System.out.printf("합계 %d 걸린시간 %d\n",sum,(end-start));
//		System.out.println(start);//현재시스템시간 long타입으로보여줌		
		
		
		//메타데이타 
	}
}
