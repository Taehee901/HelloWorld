package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {
	public static void main(String[] args) {
		//배열[여러건]데이터저장해왔었음 ->컬렉션(1.List(리스트),2.Set(값만저장)3.Map)
		//set 아무값이나다받지만 중복값은안받음
		//Set 클래스 이름<Integer>타입
		int [] ary = new int[5];
		//Set인터페이스 - 클래스가 아니라 인스턴스가못만듦,자식클래스를통해 존재,()생성자호출
		//인터페이스 HashSet
		
		//확장된 for.
		//배열갯수만큼만 반복
		//num반복변수
		for(int num : ary) {
			System.out.println(num);
		}
		
		
		Set<Integer> set = new HashSet<Integer>();//정수처리하는클래스integer
		//추가
		
		//Set컬렉션은 저장되는 순서가 없다.(저장순서X)
		//중복된값은 허용하지않는다(중복된값x)
		
		//인덱스관리가 아니라 순서는 딱히 상관없다
		//중복된값을 안받아들인다
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(10);
		
		//직접선언하는 클래스. Member
		Set<Member> members =  new HashSet<Member>(); //같은 타입을받을 수 있는 참조변수
		members.add(new Member("홍길동",10));
		members.add(new Member("김민석",12));
		members.add(new Member("홍길동",10));
		
		//set은 중복저장하지 않지만 동등하다고 판별하지 않아서 3건
		//why?toSring생략,재정의되지않으면 object가 가지고 있는 표현방식으로 출력
		//여기서는 객체의 주소값 리턴하도록 만들어줌
		//toString 주소값이보여지면 사용..?다시보기
		for(Member num : members) {
		System.out.println(num.toString());
	}
	

//		for(Integer num : set) {
//			System.out.println(num);
//		}
	}
		

	//object equlas()
	public static void exe1() {
		int num1 = 10, num2 = 10;
		System.out.println(num1 == num2);
		
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		//문자열비교
		//equals->String 재정의,두개의문자열비교
		System.out.println(str1.equals(str2));//문자에비교연산자 false->new 스트링객체만들고주소값을참조하게해줌
		
		
		Member mem1 = new Member();//인스턴스
		//인스턴스만들어진위치의주소값을참조
		mem1.memberName = "홍길동";
		mem1.age = 10;
		
//		Member mem2 = new Member();//주소비교
//		mem2.memberName = "홍길동";
//		mem2.age = 20; //=>flase
		//논리적으로 동등한 객체 정의하고 싶을때 equlas
		Member mem2 = new Member();//주소비교
		mem2.memberName = "홍길동";
		mem2.age = 10; 
		//equlas object최상위에서 상속받음 Member가 재정의 
		//주소비교
		System.out.println(mem1.equals(mem2));//false
	}
}
