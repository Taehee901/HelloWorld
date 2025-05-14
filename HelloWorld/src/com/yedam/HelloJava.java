package com.yedam;

// ctrl+shift+f(맞춤)
public class HelloJava {
	public static void main(String[] args) {
		//int(정수)long,short,double(실수,소수점),boolean(참거짓)
		//자바스크립트는 옵션이지만 자바는 ;필수
		//변수초기화
		//obj=class
		
		int num1 = 10;//초기화
//		int num1 = 10.0;//불가,double 데이터타입,같은데이터타입끼리만연산가능
		double num2 = 20;//정수타입인데되는이유값의범위,자동형변환(promotion)-작은데이터유형을큰데이터유형에담는건가능,반대
		
		num1 = (int)num2;//반대일경우작은값을큰값에넣는,강제형변환(casting)_명시적으로 데이터의타입을 지정
		
		int num3 = 100;
		double num4 = 200;
		double result = (double)num3+num4;//정수타입과더블타입-num3를 double타입으로 자동형변환
		System.out.println("결과는 "+ result);//뮨자열+두문장연결,result 문자열로 변환후 
		
		//20+30 =>50
		System.out.println(20+30);
		System.out.println("결과는 "+20+30);//앞문자열-뒤 문자열로인식
		System.out.println("결과는 "+(20+30));//string+int(+) => str +(20+30)=>str + 50
		
	}
}
