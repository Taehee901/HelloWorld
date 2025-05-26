//package com.yedam.collection;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.yedam.api.Member;
//
///* 
// * 인덱스를 사용해서 객체를 관리.
// * 순서를 가지고 중복된 값 가능.
// * */
//public class ListExe {
//
//	class Student {
//		private int studentNo; // 1001,1002,1003 ... 1010;
//		private int score;
//
//		public Student(int studentNo, int score) {
//			this.studentNo = studentNo;
//			this.score = score;
//		}
//
//		public int getScore() {
//			return score;
//		}
//	}
//
//	public static void main(String[] args) {
//
//		List<Student> numbers = new ArrayList<>();
//		for (int i = 0; i <= 10; i++) {
//				int score = (int) (Math.random() * 91) + 10;
//				numbers.add(new Student(1000 + i, score));
//	//			int sco = (int)(Math.random()* 91) +10;
//	//			numbers.add(sco);
//		}
//		int sum = 0;
//		double avg = 0;
//		for (int i = 0; i < numbers.size(); i++) {
//			sum += numbers.get(i).getScore();
//		}
//		avg = 1.0 * sum / numbers.size();
//		System.out.printf("점수의 합: %d ,평균: %.1f\n", sum, avg);
//	}
//
//	// 10 ~ 100 점 점수를 임의의 값으로 생성.
//	// 정수 10개 생성
////		int num = 0;
////		///바보짓..
////		List <Integer> numbers = new ArrayList<>((int)(Math.random()*90)+10);
////		for(int i=0;i<10;i++) {
////			numbers.add(i);
//////			 num = numbers.get(i);
////		}
////		System.out.println(numbers);
////		//10개의 점수의 합,평균 출력.
////		
//	
//
//	// 저장2
//	public static void exe2() {
//		List<Member> members = new ArrayList<>();
//		// 객체못넣음-참조변수에넣고,index로는 지울수o,주소값을몰라서x
//		Member member = new Member("김홍동", 20);// 주소값알수o
//		members.add(new Member("홍길동", 10));
//		members.add(member);
//		members.add(new Member("김홍도", 30));
//
//		// 삭제.
////		members.remove(member);
//
//		// 삭제
//		String search = "김홍동";
//		for (int i = 0; i < members.size(); i++) {
//			if (members.get(i).memberName.equals(search)) {
//				members.remove(i);
//			}
//		}
//		// 목록출력.
//		for (int i = 0; i < members.size(); i++) {
//			System.out.println(members.get(i).toString());
//		}
//
//	}
//
//	public static void exe1() {
//		// 인터페이스 -구현클래스
////		ArrayList list = new ArrayList;
//
////		int[]ary = {10,20,30.4};
//		// 오브젝트를 상속받기에 사용가능
//		// 인터페이스 -구현클래스
//		// 타입지정
//		// 여러개데이터타입을 지정-미리,널값생각x,계속추가가능
//		List<String> list = new ArrayList<String>();
////		list.add(new Integer(10));
//		list.add("10");
//		list.add(new String("Hello"));
//		// 위치지정
//		list.add(1, "20");
//
//		// 삭제.
//		list.remove(0);
//
////		for(Object item : list) {
////			String result = (String)item;
////			System.out.println(result);
////		}
//		// length아닌이유 클랙션
//
//		// 변경
//		list.set(1, "World");
//		// 문자열만이아닌 모든객체타입을 담을수있다.
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
////		for(String item : list) {
////			System.out.println(item);
////		}
//	}
//}

//------------에러찾아야함
package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

/*
 * 인덱스를 사용해서 객체를 관리.
 * 순서를 가지고 중복된 값 가능.
 */
//class Student {
//	private int studentNo; // 1001, 1002, 1003...1010;
//	private int score;
//
//	public Student(int studentNo, int score) {
//		this.studentNo = studentNo;
//		this.score = score;
//	}
//
//	public int getScore() {
//		return score;
//	}
//}

public class ListExe {
	public static void main(String[] args) {
		// 10 ~ 100 점 점수를 임의의 값으로 생성. 정수10개 생성.
		List<Student> numbers = new ArrayList<>();
		for (int i = 1; i <= 10; i++) { // 10번 생성.
			int score = (int) (Math.random() * 91) + 10;
			numbers.add(new Student(1000 + i, score));
		}
		// 10개의 점수의 합, 평균 출력.
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i).getScore(); // Student(no,score)
		}
		avg = 1.0 * sum / numbers.size();
		System.out.printf("점수의 합: %d, 평균: %.1f\n", sum, avg);

	}

	// 저장2.
	public static void exe2() {
		List<Member> members = new ArrayList<>();
		Member member = new Member("김홍동", 20);

		members.add(new Member("홍길동", 10));
		members.add(member);
		members.add(new Member("김홍도", 30));

		// 삭제.
//		members.remove(member);

		String search = "김홍동";
		// 삭제.
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}
		// 목록 출력.
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString());
		}

	}

	// 저장1.
	public static void exe1() {
//		int[] ary = {10, 20, 30.4};
		// 인터페이스 - 구현클래스
		List<String> list = new ArrayList<String>();
		list.add("10");
		list.add(new String("Hello"));

		list.add(1, "20"); // 위치지정.

		// 삭제.
		list.remove(0);

		// 변경.
		list.set(1, "World");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

//		for (String item : list) {
//			System.out.println(item);
//		}

	}
}
