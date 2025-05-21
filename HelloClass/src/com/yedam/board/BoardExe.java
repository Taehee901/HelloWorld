package com.yedam.board;

import java.util.Scanner;

/*
 *추가(addBoard)/수정-글번호기준 제목 내용 수정/삭제-배열초기값이 null이라삭제처럼보이게가능 /
 *목록(boardList) ->상세화면 조회
 *조회기능(글번호->글반환)getBoard(메서드)
 * 수정(modifyBoard) - 글번호(찾는용도),바뀔내용,바뀔제목
 * 삭제 (removeBoard) - 글번호null,삭제x ->없다는 메시지보여줌
 * 순번부여(nextSequence()) - 현재글번호 + 1
 */
public class BoardExe {
	// 필드 선언.=>메서드에 다 접근가능하게
//	private Board[] boards = new Board[100];//데이터 저장(boards)//null상태,필드이름선언할때 초기값 넣어도 됨
	private Board[] boards;
	private Scanner scn = new Scanner(System.in);// execute에 선언하면 execute내에
//	private int bno = 0;
	private int bno = 2;// 배열인덱스를 0,1위치는 아래에서 가지고 있으니 3번째부터 추가하면 들어감
	// 생성자.

	public BoardExe() {
		boards = new Board[100];
//		boards = new Board[100];//필드의 null값인 100개담을수있는공간을 boards 할당,//넉넉하게 공간 지정해주려고,초기값이나 생성자가 반드시 실행되어야지
		// 한건찾고
		boards[0] = new Board(10, "날씨가 좋습니다.","오늘 기온이 30도가 넘습니다", "홍길동");
		boards[1] = new Board(11, "자바가[11] 힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[2] = new Board(12, "자바가[12] 힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[3] = new Board(13, "자바가[13]힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[4] = new Board(14, "자바가[14] 힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[5] = new Board(15, "자바가[15] 힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[6] = new Board(16, "자바가[16] 힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[7] = new Board(17, "자바가[17] 힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[8] = new Board(18, "자바가[18] 힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[9] = new Board(19, "자바가[19] 힘들어요","자바는 힘들지 않아요...", "김민규");
		boards[10] = new Board(20, "자바가[20] 힘들어요","자바는 힘들지 않아요...", "김민규");
		
	}
//아이디와 비밀번호틀릴경우
	//3번까지 기회주는데..셋다틀릴경우 종료,2025년 05월 21일
	// 메소드.
	void execute() {
//		for(int i =1;i<=3;i++) {
//			String uid = userMessage("아이디를 입력하세요");
//			String upwd = userMessage("비밀번호를 입력하세요");
//			if(!UserExe.login(uid, upwd)) {
//				System.out.println("아이디와 비밀번호를 확인하세요.");
//				return;
//			}
//		}
		String uid = userMessage("아이디를 입력하세요");
		String upwd = userMessage("비밀번호를 입력하세요");
		if(!UserExe.login(uid, upwd)) {
			System.out.println("아이디와 비밀번호를 확인하세요.");
			return;
		}
		System.out.println("환영합니다!!!");
		boolean run = true;
		//아이디 입력.
		//비밀번호 입력.
		UserExe.login(null, null);
		while (run) {
			System.out.println("---------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.목록 6.종료");
			System.out.println("---------------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(scn.nextLine());
//			if(selectNo == 1)
			switch (selectNo) {
			case 1:// 추가
				addBoard();
				break;
			case 2:// 수정
				modifyBoard();
				break;
			case 3:// 삭제.
				removeBoard();
				break;
			case 4:// 목록.
				boardList();
				break;
			case 5:// 종료
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}// end of switch

		} // end of while
	}// end of execute

	// 기능.
	// "글번호를 입력하세요>> " 1
	// "제목을 입력하세요>> " 오늘은 덥네요.
	// "내용을 입력하세요>> " 오늘 기온이 30도가 넘습니다....
	// "작성자를 입력하세요>> " 홍길동
	// "추가성공"/"추가실패" 메세지출력.
	
	void addBoard() {
//		System.out.print("글번호를 입력하세요>> ");
//		int no = Integer.parseInt(scn.nextLine());//문자나 문자열에서 공백 전까지의 단어
//		System.out.print("제목을 입력하세요>> ");
//		String title = scn.nextLine();
//		System.out.print("내용을 입력하세요>> ");
//		String content = scn.nextLine();
//		System.out.print("작성자를 입력하세요>> ");
//		String writer = scn.nextLine();
//		System.out.print("글번호를 입력하세요>> ");

		// userMessagea메소드만들어서 변경한부분
//		int no = Integer.parseInt(userMessage("글번호를 입력하세요."));// 문자나 문자열에서 공백 전까지의 단어입력받지말고
		int no = nextSequence();//글번호중가
//		System.out.print("제목을 입력하세요>> ");
//		System.out.println("아이디를 입력하세요>>");

		String title = userMessage("제목을 입력하세요");
//		System.out.print("내용을 입력하세요>> ");
		String content = userMessage("내용을 입력하세요");
//		System.out.print("작성자를 입력하세요>> ");
		String writer = userMessage("작성자를 입력하세요");
		// Board인스턴스 선언하고 값을 지정.
		// 매개값 메시지,사용자값반환
		Board board = new Board(no, title, content, writer);
		// 배열에 저장.
		boards[bno++] = board;// 생성자 없으면 null null
		System.out.println("추가성공");
	}
	//1.큰번호위정렬2.글번호등록마다 제일큰값+1 정렬
	/*
	 * 기능 글번호 제목 작성자 ======================== 1 날씨가 좋아요 홍길동 2 클래스 멋짐! 김민규 3 자바어려움
	 * 박석민 4 그래도 열심히!! 김민규 ------------------------- 상세보기: 글번호입력,메뉴로이동(q) ** 등록된 글이
	 * 없습니다 **
	 */
	

	
	//새글만들때 배열큰값+1한값을 순번으로 매기는방식
	void boardList() {
//		sort();
		int page = 1;
		//while반복q입력전까지 목록보여주기위해
		while(true) {
			int start = (page-1)*5;//페이지건수
			int end = page*5;
			System.out.println("글번호      제목       작성자");
			System.out.println("========================");
			
			//5개보여줌
			for(int i = start;i<end;i++) {
//			for (int i = 0; i < boards.length; i++) {
				if (boards[i] != null) {// null이 아닐때만 출력//null에러
					boards[i].showInfo();
				}
			}
			// 상세보기.
			System.out.println("-------------------------");
			System.out.println("상세보기: 글번호입력,(이전:p)/ (다음:n)메뉴로이동(q)");
			System.out.println("-------------------------");// q 번호 이동,아닐경우 글번호입력
			System.out.println("선택>>");
			String str = scn.nextLine();
			// 메뉴,상세
			if (str.equals("q")) {
				break;//return; boardList 종료
			}else if(str.equals("n")) {
				page++;//+1
			}else if(str.equals("p")) {
				page--;//+1
			}else {// 1,2,3값이 들어올경우
					// continue;
				int no = Integer.parseInt(str);// no 글번호
				// 배열에서 조회.,null값이 있다는 거 주의
				// 반환된타입 Board
				Board sboard = getBoard(no);
				if (sboard == null) {
					System.out.println("조회결과 없습니다.");
					return;
				}
//				sboard.showInfo();// 상세보기..바보짓했다.
				sboard.showToAllInfo();// 상세보기.
//		sboard선언전에 했던거		for(int i = 0;i<boards.length;i++) {
//					if(boards[i]!= null && boards[i].getBoardNo() == no) {
//						boards[i].showToAllInfo();//한건보여줌
//						
//					}//end of if
//				}//end of for
//				
			} // end of while
	
		System.out.println();
	}// end of boardList
}
	// 수정.
	void modifyBoard() {
		// 코드 순서대로 출력
		int bno = userMenu("수정할 글번호 입력");// 문자열 오류
		Board result = getBoard(bno);// 보드타입의 getBoard(bno)주소값을 result가 반환
		if (result == null) {// 조회값이 null초기화했었고
			System.out.println("조회한 결과가 없습니다.");
			return;// 메소드 종료,아랫코드 사용x
		}
		String title = userMessage("수정할 제목 입력");
		String content = userMessage("수정할 내용 입력");

		// 조회결과를
		result.setContent(content);
		result.setTitle(title);
		System.out.println("수정 완료.");
	}

	// 참조결과값 null 삭제
//	void removeBoard() {
//		int bno = userMenu("삭제할 글번호 입력");
//		Board result = getBoard(bno);
//		if (result != null) {
//			System.out.println("삭제완료");
//		}
//		result = null;
//		return;
//	}

	//1page : 0,1,2,3,4 =>(page-1)*5 ~(page*5)
	//2page : 5,6,7,8,9 => 5<= x <10
	//3page : 10,11,12,13,14
	
	
	
	
	//삭제
	void removeBoard() {
		int bno = userMenu("삭제할 글번호 입력");//사용자가 값입력
		for(int i = 0; i<boards.length;i++) {//배열의 크기만큼 반복
			if (boards[i] != null && boards[i].getBoardNo() == bno) {//배열의 요소가 null이 아니고 getBordNo == 사용자값입력이랑 같을 경우
				boards[i] = null;//배열요소 null로 만듦
				System.out.println("삭제완료.");
			}
		}
	}//end of removeBoard()
	
	
	// 글번호 들어오면 한건조회되는
	// 단건조회(getBoard)
	// 매개변수애 들어오는 글번호를 활용해서 배열에서 조회하고 Board 반환.
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {// boards[i] != null -널이아니라는게 있으면 null에러덜들고옴,배열요소에
																		// 가서 getB
				// 매개값으로들어온글번호찾는게목적
				return boards[i];
			} // end of if
		} // end of for
		return null; // 조건에 맞는 글번호 없으면 null 반환.,Board을반환하거나 null반환이가능,0(x)
	}

	// 사용자의 입력값을 문자열로 반환.
	String userMessage(String msg) {
		System.out.print(msg + ">>");// 사용자입력값에+">>"
		return scn.nextLine();// 사용자입력값반환
	}

	// 문자열을 정수로 반환
	int userMenu(String msg) {
		System.out.print(msg + ">>");// 사용자입력값에+">>"
		return Integer.parseInt(scn.nextLine());// 사용자입력값반환
	}
	
	//순번 -> sort안써도됨
	int nextSequence() {
		int max = 0;
		for(int i = 0;i<boards.length;i++) {
			if(boards[i] != null && max <boards[i].getBoardNo()) {//max 보다 현재 boards글번호보다 클경우
				max = boards[i].getBoardNo();
			}
		}
		//최고큰값에 1더해서 반환
		return max+1;
	}
//역순정렬
	//앞뒤중 1개가 널일경우..
	//정렬할때 비교값이 넣이면.. i+1 다음순번으로넘어감
//	void sort() {
//		Board temp = null;
//		for (int j = 0; j < boards.length - 1; j++) {
//			for (int i = 0; i < boards.length - 1; i++) {
	//b3,null
//				if (boards[i + 1] == null) {
//					continue;
//				}
	//null,b3
//				if (boards[i] == null) {
//					temp = boards[i];
//					boards[i] = boards[i + 1];
//					boards[i + 1] = temp;
//					continue;
//				}
	//b1,b2
//				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
//					temp = boards[i];
//					boards[i] = boards[i + 1];
//					boards[i + 1] = temp;
//				}
//			}
//		}
//	} // end of sort.
}// end of class
