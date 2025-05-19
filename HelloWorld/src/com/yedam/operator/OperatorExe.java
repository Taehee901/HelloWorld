package com.yedam.operator;
//
public class OperatorExe {
	public static void main(String[] args) {
		// 메서드호출
//		test();
//		test1();
//		test2();
//		test3();
//		test4();
		test5();
		
	}
	
	//?
	public static void test5() {
		String pass ="";
		int score = (int)(Math.random()*100);//0<=x<99,()없으면 0*0 = 불
//		if(score>=60) {
//			if(score >=80){
//			pass="우수"
//		}else{
//			pass = "합격";
//		}
//		else {
//			if(score<20) {
//				pass ="불불합격";
//			}else {
////			pass="불합격";				
//			}
//		}
		//삼항연산자로 변경
		System.out.println(score);
		//if-else:if-else
		pass = (score>=60)?(score>=80)?"우수":"합격":(score<20)?"불불합격":"불합격";
		System.out.printf("%d점은 %s\n",score,pass);
		System.out.println(pass);
	}
	

//''->char타입,int +,문자열이먼저나오면3,3.0->jdk33.0
	//"월" 정보를 입력하면 "공란" 반환하는 메소드,getSpace()
	//객체안함수 메소드,어떤형태의 데이터타입인지 명시,호출한영역에 int데이터타입을 반환하는지 명시해줘야함,자바스크립트와다르게 데이터타입이o 
	public static int getSpace(int month) {
		int space = 0;
		if(month==3) {//3월달
			space = 6;
		}
		else if(month==4) {//4월달
			space = 2;
		}
		else if(month==5) {//5월달
			space = 4;
		}
		else if(month==7) {//7월달
			space =2;
		}
		return space;
	}//end of getSpace.
	
	//"월" 정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
	public static int getLastDate(int month) {//정수반환
		int lastDate = 31;
		switch(month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30; 
			break;
		}
		return lastDate;
	}//end of getLastDate
	

	// 달력형태
	public static void test4() {
		int mon = 3;//월정보입력...
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		// 빈공간.
//		int space = 2;
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);
//		for(int s = 1;s<=4;s++) 
		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", "");
		}
		// 날짜출력
//		for(int day = 1;day<=31;day++) {
		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day);// n공간=>___공간 필요한만큼차지해서 표시해준다
		// if(day%7 == 3)
		if ((day + space) % 7 == 0) {
			System.out.println();
		}
	}
}//end of test4

	// 토글기능
	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // 두개의 값에서 왔다갔다하는게 토글(on->off,off->on)
			// on->off,off->on => true ->false,false->true
		}
	}

	public static void test2() {
		int num1 = 10;
		int num2 = 20;
		// 증가연산자 앞 먼저 증가 뒤에는 연산 후 증가,result 증가하기전 20일때결과
		int result = ++num1 + num2++;
		System.out.printf("num1 => %d, num2 => %d result => %d", num1, num2, result);

		boolean isTrue = true;
		if (!isTrue) {// false
			System.out.println("참입니다.");
		}

		// == 부정 !=,>부정은 <=,>= 부정은 <.
		result = 30;
		// 논리 true -false,false-true반대값

		// == 논리부정은 !=,>부정은 <=,>= 부정은 < .

		if (!(result != 30)) {// >= x
			System.out.println("\nresult는 30보다 작거나 같다.");
		}

		// !(f|f) ->t
		if (!(--num1 > 10 || num2 < 20)) {// false not true
			System.out.printf("num1 => %d", num1);
		}
	}

	// 연습2. 정수형데이터타입-byte,short,int,long,char
	public static void test1() {
//		byte num1 = 10;
//		byte num2 = 20;
		byte num1 = 127;
		byte num2 = 1;
		// 정수형 기준 int,연산기본이 정수인데 +연산 int기본으로 변경 후 byte 저장
		byte sum = (byte) (num1 + num2);// 정수연산의 기본 int,캐스팅필요
		System.out.println(sum);

		long num3 = 10000000000L;// 리터럴,실제값을변수에담을때,정수형표현을넘어서면 long데이터타입이란표현L
		long num4 = 100L;
		// 레퍼클래스,long 클래스타입(변경,int integer
		System.out.println(Integer.MAX_VALUE);// int 2147483647(최댓값)
	}

	// 연습1
	public static void test() {
		// 증가,감소 연산자 (++,--)
		// byte 담을수있는 값 범위가 적다
		// bit8=1byte,256,8비트 맨앞부호 담을 수 있는게 -128~+127(0포함),양의기호는->0,1은 -의미 부호
		// 반대값보수,보수를취한다+1더한결과값이0이나오면
		// short(2),int(4),long(8)
		byte num1 = -128;
		num1 = 127;
		// max+1 = 다시 작은값으로돌아감
		num1++;
		System.out.println(num1);

		// 유니코드(세계문자값)값,문자값들을 숫자로가지고있음-데이터타입 정수,정수값이문자열에해당됨
		char ch1 = 'A';// 65
		ch1 = 66;// B
		ch1 = '가';
		ch1 = 'A';
		ch1 = 'a';// 97
		ch1 = '가';
		// 16진수 0x
		ch1 = 0x29D7;// 특수문자

//		System.out.println((int)ch1);
		System.out.println((int) ch1);
		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);
		}
	}
}
