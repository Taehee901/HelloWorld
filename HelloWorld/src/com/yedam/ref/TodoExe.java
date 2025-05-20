package com.yedam.ref;
//
import java.util.Scanner;

//혼공자 223페이지 연습문제6
public class TodoExe {
	static Student[] scores = null;// 학생점수저장배열변수,클래스어느위치든사용가능
	public static void main(String[] args) {
			int[][] numAry = new int[3][5];

			// 임의의 숫자 생성

			for (int outer = 0; outer < numAry.length; outer++) {

				int sum = 0;

				for (int inner = 0; inner < numAry[outer].length; inner++) {

					numAry[outer][inner] = (int) (Math.random() * 100);

					sum += numAry[outer][inner];

					System.out.printf("numAry[%d]:%d",outer,numAry[outer][inner]);

				}

				double avg = 1.0 * sum / numAry[outer].length;

				System.out.printf("numAry[%d]: %.2f\n",outer,avg);

			}

	}
//		init();//초기데이터 생성.
//		boolean run = true;// 반복문 실행/종료
//		int studentNum = 0;// 학생수입력변수
//		int[] scores = null;// 학생점수저장배열변수
//		Scanner scanner = new Scanner(System.in);//사용자 입력받는것
//
//		while (run) {
//			System.out.println("------------");
//			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
//			System.out.println("------------");
//			System.out.println("선택> ");
//
//			int selectNo = Integer.parseInt(scanner.nextLine());//문자타입->숫자타입
//			//배열의 선언없이 메뉴를 선택할 경우에는 NullPointer예외
//			if(selectNo == 2 || selectNo == 3 || selectNo == 4)
//				if(scores == null) {//배열먼전선언되어야함
//					System.out.println("학생수를 지정하세요.");
//				continue;//아랫부분코드(진행)실행x
//			}
//			if (selectNo == 1) {//학생수지정
//				System.out.println("학생수> ");
//				studentNum = Integer.parseInt(scanner.nextLine());
//				scores = new int [studentNum];//배열의 크기지정
//			}
//			else if(selectNo == 2) {//점수입력
//				//length배열크기가르키는속성
////				if(scores == null) {
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				for(int i = 0;i<scores.length;i++) {
//					System.out.printf("scores[%d]> ",i);
//					scores[i] = Integer.parseInt(scanner.nextLine());//사용자입력값 정수변환
////					System.out.println();//줄바꿈용도;//줄바꿈은 필요없음
//				}
//			}
//			else if(selectNo == 3) {//목록
////				if(scores == null) {
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				//배열의 합이 0이면 점수를 입력하세요.
//				int sum = 0;
//				for(int i = 0;i<scores.length;i++) {
//					sum += scores[i];//점수누적
//					
//				}
//				//점수입력하도록 메시지 보여주기.
//				if(sum == 0) {
//					System.out.println("점수를 입력하세요.");
//					continue;//아래코드진행x
//				}
//				for(int i = 0;i<scores.length;i++) {
//					System.out.printf("scores[%d]> %d\n",i,scores[i]);
//				}
//			}
//			else if(selectNo == 4) {//분석(최고점수,평균)
////				if(scores == null) {//배열먼전선언되어야함
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				int max = 0,sum = 0;//최고점수, 합계 변수선언
//				double avg = 0;//평균 변수 선언
//				for(int i = 0;i<scores.length;i++) {
//					sum += scores[i];//점수누적
//					if(max <scores[i]) {//max보다 scores값 클 경우
//						max  = scores[i];
//					}
//				}
//				avg = 1.0 * sum/scores.length;//1.0 * 실수
//				System.out.printf("최고점수: %d\n 평균점수:%.2f\n",max,avg);
//			}
//			else if(selectNo == 5) {//종료
//				run = false;//while반복문조건이 true ->false 종료
//			}
//		} // end of while
//		System.out.println("프로그램 종료");
		
//		boolean run = true;// 반복문 실행/종료
//		int studentNum = 0;// 학생수입력변수,배열크기
//		Scanner scanner = new Scanner(System.in);//사용자 입력받는것
//
//		while (run) {
//			System.out.println("------------");
//			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
//			System.out.println("------------");
//			System.out.println("선택> ");
//
//			int selectNo = Integer.parseInt(scanner.nextLine());//문자타입->숫자타입
//			//배열의 선언없이 메뉴를 선택할 경우에는 NullPointer예외
//			if(selectNo == 2 || selectNo == 3 || selectNo == 4)
//				if(scores == null) {//배열먼전선언되어야함
//					System.out.println("학생수를 지정하세요.");
//				continue;//아랫부분코드(진행)실행x
//			}
//			if (selectNo == 1) {//학생수지정
//				System.out.println("학생수> ");
//				studentNum = Integer.parseInt(scanner.nextLine());
//				scores = new Student [studentNum];//배열의 크기지정,new 객체의 주소값을반환하는 기능
//			}
//			else if(selectNo == 2) {//점수입력
//				//length배열크기가르키는속성
////				if(scores == null) {
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				for(int i = 0;i<scores.length;i++) {
//					System.out.printf("scores[%d] 이름>> ",i);
//					String name = scanner.nextLine();//이름저장.
//					System.out.printf("scores[%d] 점수>> ",i);
//					int score = Integer.parseInt(scanner.nextLine());//사용자입력값 정수변환
//					System.out.printf("scores[%d] 키>> ",i);
//					double height = Double.parseDouble(scanner.nextLine());
//					System.out.printf("scores[%d] 성별>> ",i);
//					Gender gen = Gender.MALE;//초기값
//					String gender = scanner.nextLine();
//					if(gender.equals("남") || gender.equals("남자")) {
//						gen = Gender.MALE;
//					}
//					else if(gender.equals("여") ||gender.equals("여자")) {
//						gen = Gender.FEMALE;
//					}
//					//인스턴스 생성.
//					Student student = new Student();
//					student.studentName = name;
//					student.score = score;
//					student.height = height;
//					student.gender = gen;
//					scores[i] = student;//배열에 저장.
////					System.out.println();//줄바꿈용도;//줄바꿈은 필요없음
//					//Double,parseDouble
//					//실수변환
////					Double.parseDouble("175.6")
//				}
//			}
//			else if(selectNo == 3) {//목록
////				if(scores == null) {
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				//배열의 합이 0이면 점수를 입력하세요.
//				int sum = 0;
//				for(int i = 0;i<scores.length;i++) {
//					sum += scores[i].score;//점수누적,배열데이터구조중socre만
//					
//				}
//				//점수입력하도록 메시지 보여주기.
//				if(sum == 0) {
//					System.out.println("점수를 입력하세요.");
//					continue;//아래코드진행x
//				}
//				System.out.println("검색조건 ex)남 또는 여>> ");
//				String keyword = scanner.nextLine();//남,여,엔터(공백)
//				Gender gen  = Gender.MALE;//초기화gen == scores[i].gender
//				//||keyword.equals("남자")
//				if(keyword.equals("남") ||keyword.equals("남자")||keyword.equals("Men") ||keyword.equals("M") ) {
//					gen = Gender.MALE;
//				}else if(keyword.equals("여") ||keyword.equals("여자")|| keyword.equals("Women") ||keyword.equals("W")) {
//					gen = Gender.FEMALE;
//				}
//				
//				//이름,점수출력
//				for(int i = 0;i<scores.length;i++) {
//					if(keyword.equals("") || gen == scores[i].gender) {
//						System.out.printf("scores[%d]> %s %d\n",i,scores[i].studentName,scores[i].score);						
//					}
//				}
//			}
//			else if(selectNo == 4) {//분석(최고큰 키,평균)키큰사람점수
////				if(scores == null) {//배열먼전선언되어야함
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				double max = 0;
//				int sum = 0;//최고점수, 합계 변수선언
//				double avg = 0;//평균 변수 선언
//				Student maxStd = new Student(); //최고점수를 받은 학생의 정보를 저장
////				double heights = Double.parseDouble();
//				for(int i = 0;i<scores.length;i++) {
//					sum += scores[i].score;//점수누적
//					if(max <scores[i].height) {//max보다 scores값 클 경우
////						max  = scores[i].height;
//						maxStd.score = scores[i].score;
//						maxStd.studentName = scores[i].studentName;
//						maxStd.height = scores[i].height;
//						maxStd.gender = scores[i].gender;
//					}
//				}
//				
//				avg = 1.0 * sum/scores.length;//1.0 * 실수
//				System.out.printf("학생이름: %s,키: %d\n,평균점수:%.2f\n",maxStd.studentName,maxStd.score,avg);
//			}
//			else if(selectNo == 5) {//종료
//				run = false;//while반복문조건이 true ->false 종료
//			}
//		} // end of while
//		System.out.println("프로그램 종료");
//	}
//		public static void init() {
//			Student s1 = new Student();//인스턴스를 생성해야 값담음
//			s1.studentName = "홍길동";
//			s1.score = 80;
//			s1.height = 170.8;
//			s1.gender = Gender.MALE;//"남자","Men"
//			
//			Student s2 = new Student();//인스턴스 생성.
//			s2.studentName = "김민선";
//			s2.score = 85;
//			s2.height = 165.7;
//			s2.gender = Gender.FEMALE;;
//			
//			Student s3 = new Student();//인스턴스 생성.
//			s3.studentName = "박철민";
//			s3.score = 90;
//			s3.height = 180.3;
//			s3.gender = Gender.MALE;;
//			
//			//초기데이터
//			scores = new Student[] {s1,s2,s3};
// 			
////			stdAry = new Student[] {s1,s2,s3};//변수선언동시에 값할당할때는없어도되는데,stdAry = {s1,s2,s3};, 배열에 s1~s3값을 담아 할당
//		}

		
		
//		boolean run = true;// 반복문 실행/종료
//		int studentNum = 0;// 학생수입력변수,배열크기
//		Student[] scores = null;// 학생점수저장배열변수
//		Scanner scanner = new Scanner(System.in);//사용자 입력받는것
//
//		while (run) {
//			System.out.println("------------");
//			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
//			System.out.println("------------");
//			System.out.println("선택> ");
//
//			int selectNo = Integer.parseInt(scanner.nextLine());//문자타입->숫자타입
//			//배열의 선언없이 메뉴를 선택할 경우에는 NullPointer예외
//			if(selectNo == 2 || selectNo == 3 || selectNo == 4)
//				if(scores == null) {//배열먼전선언되어야함
//					System.out.println("학생수를 지정하세요.");
//				continue;//아랫부분코드(진행)실행x
//			}
//			if (selectNo == 1) {//학생수지정
//				System.out.println("학생수> ");
//				studentNum = Integer.parseInt(scanner.nextLine());
//				scores = new Student [studentNum];//배열의 크기지정,new 객체의 주소값을반환하는 기능
//			}
//			else if(selectNo == 2) {//점수입력
//				//length배열크기가르키는속성
////				if(scores == null) {
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				for(int i = 0;i<scores.length;i++) {
//					System.out.printf("scores[%d] 이름>> ",i);
//					String name = scanner.nextLine();//이름저장.
//					System.out.printf("scores[%d] 점수>> ",i);
//					int score = Integer.parseInt(scanner.nextLine());//사용자입력값 정수변환
//					//인스턴스 생성.
//					Student student = new Student();
//					student.studentName = name;
//					student.score = score;
//					scores[i] = student;//배열에 저장.
////					System.out.println();//줄바꿈용도;//줄바꿈은 필요없음
//				}
//			}
//			else if(selectNo == 3) {//목록
////				if(scores == null) {
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				//배열의 합이 0이면 점수를 입력하세요.
//				int sum = 0;
//				for(int i = 0;i<scores.length;i++) {
//					sum += scores[i].score;//점수누적,배열데이터구조중socre만
//					
//				}
//				//점수입력하도록 메시지 보여주기.
//				if(sum == 0) {
//					System.out.println("점수를 입력하세요.");
//					continue;//아래코드진행x
//				}
//				//이름,점수출력
//				for(int i = 0;i<scores.length;i++) {
//					System.out.printf("scores[%d]> %s %d\n",i,scores[i].studentName,scores[i].score);
//				}
//			}
//			else if(selectNo == 4) {//분석(최고점수,평균)
////				if(scores == null) {//배열먼전선언되어야함
////					System.out.println("학생수를 지정하세요.");
////					continue;//아랫부분실행x
////				}
//				int max = 0,sum = 0;//최고점수, 합계 변수선언
//				double avg = 0;//평균 변수 선언
//				Student maxStd = new Student(); //최고점수를 받은 학생의 정보를 저장
//				for(int i = 0;i<scores.length;i++) {
//					sum += scores[i].score;//점수누적
//					if(max <scores[i].score) {//max보다 scores값 클 경우
//						max  = scores[i].score;
//						maxStd.score = scores[i].score;
//						maxStd.studentName = scores[i].studentName;
//					}
//				}
//				
//				avg = 1.0 * sum/scores.length;//1.0 * 실수
//				System.out.printf("학생이름: %s,최고점수: %d\n,평균점수:%.2f\n",maxStd.studentName,maxStd.score,avg);
//			}
//			else if(selectNo == 5) {//종료
//				run = false;//while반복문조건이 true ->false 종료
//			}
//		} // end of while
//		System.out.println("프로그램 종료");
	}//end of main
//전체코드비교는 교수님 git
