package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

//외부파일로만들어서 임포트
import com.yedam.collection.Student;

/*
 * 학생정보(추가,수정,삭제,목록) -> studentList.txt(c:/temp/)
 * add(추가:이름,점수 입력)
 * modify(수정:이름,점수수정)
 * remove(삭제:이름)
 * list(목록)
 * 종료 시 저장.
 * 
 * */
public class StreamExe3 {
	static Scanner scanner = new Scanner(System.in);//키보드 입력,//필드
	static List<Student> studentList = new ArrayList<>();//컬렉션.,공간확보
	public static void main(String[] args) {//정적메소드 안에서 사용되어야하니 static으로 선언
		//init()예외처리를 호출하는곳에서 떠넘기겠다고해서
		try {
			init();//누적추가?
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NoSuchElementException e) {
			//파일의 끝부분에서 더 이상 읽을 값이 없음. NoSuchElementException예외
			//파일의 끝부분에서 더 이상 읽을 값이 없음.
		}
		boolean run = true;
		while(run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택>>");
			int menu = Integer.parseInt(scanner.nextLine());//사용자값읽어드림
			switch (menu) {
			case 1://추가
				add();
			case 2://수정
				modify();
				break;
			case 5://종료 , 엎어쓰기
				run = false;
				//save();
				save();
				
				break;
		}//end of while.
	}//end of main.
		System.out.println("end of prog");
}
	//추가.
	//main만 사용
	static void add() {
		System.out.println("학생번호: ");
		String sno = scanner.nextLine();
		System.out.println("점수: ");
		String score = scanner.nextLine();
		Student student = new Student(Integer.parseInt(sno),Integer.parseInt(score));
		if(studentList.add(student)) {
			System.out.println("저장완료");
		}
	}//end of add.
	
	
	//2수정
	static void modify() {
		//학새으점수입력받아서비교 수정
		System.out.println("학생번호: ");
//		String sno = scanner.nextLine();
		//50엔터 => 50처리
		int sno = scanner.nextInt(); //사용자가 점수를 넣고 엔터를치면,값을 넢어주고는 엔터에대한 처리는 안해줌,다음nextline이 호출될때 처리가 된다,canner.nextLine()엔터를넣어서 오류제거
		System.out.println("점수: ");
		int score = scanner.nextInt();
		scanner.nextLine();//엔터처리
		//nextLine말고 다른것들도 많음,int sno = scn.nextInt();
		//컬렉션에서 검색.
		for(int i = 0;i<studentList.size();i++) {
			//한건한건받는게 get
			if(studentList.get(i).getStudentNo() == sno) {
				//set메소드가 없으면 못넣어주니 만들업줌
				studentList.get(i).setScore(score);
				System.out.println("수정완료.");
			}
		}
	}//end of modify.
	
	//3삭제
	
	
	
	
//	//저장
//	//외부파일저장 문자기반
//	//문자기반의 출력스트림
//	try {
//
//		//1001 70
//	}
	//저장
	static void save() {
		//문자기반의 출력스트림.
		try {
			Writer writer = new FileWriter("c:/temp/studentList.txt");
			//1001 70
			for(Student student : studentList) {//studentList갯수만큼만 반복,반복횟수정해짐
				String txt = student.getStudentNo() + " " + student.getScore() + "\n";
				writer.write(txt);//데이터내보냄
			}
			writer.close();//메소들들 한번씩?
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of save.
	
	// 초기화.
	//init안에서 예외가 발생하면 init호출하는 곳에서 예외처리하게 던지는거
	//처리를다르게해주려고
	static void init() throws IOException, NoSuchElementException {
		//파일읽어오고 스트림
		//add throw ~
		Scanner scan = new Scanner(new File("c:/temp/studentList.txt"));
		while(true) {
			String txt = scan.nextLine();//한줄읽어옴
			String[] strAry = txt.split(" ");// 1001 70, 나누어서1,2번째 배열에 각각 저장
			//studentList컬렉션에 추가.
			//
			studentList.add(new Student(Integer.parseInt(strAry[0]),////1001
										Integer.parseInt(strAry[1]))//70							
			);
		}
//		scan.close();
	}
}
