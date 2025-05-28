package com.yedam.app;

import java.util.Scanner;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceDAO;
import com.yedam.vo.Member;

/*
 * 추가/삭제 등 얻어와서
 * 사용자의 입력값을 등록,수정,삭제,목록 기능을 실행.
 * 
*/
public class MemberApp {
	//먼저실행되는 
	public void execute() {
		Scanner scn = new Scanner(System.in);
		//인터페이스
		MemberService svc  = new MemberServiceDAO();
		System.out.println("-----------------------");
		System.out.println("1.회원등록 2.정보수정 3.회원삭제 4.목록보기 5.종료");
		System.out.println("선택>>");
		//메뉴선택
		int menu = scn.nextInt();scn.nextLine();//엔터키 처리 x
		switch(menu) {
		case 1: //등록
//			while(true) {
				String mid = scn.nextLine();//nextInt처리
				System.out.print("회원이름>> ");
				String name = scn.nextLine();
				System.out.print("연락처>> ");
				String phone = scn.nextLine();
				System.out.print("포인트>> ");
				String point = scn.nextLine();
				//set 가능
				//parameter(Member)
				//연락처랑 포인트 넣어주고 반복되게 변경
				Member member = new Member(mid,name,phone,Integer.parseInt(point));
				if(svc.addMember(member)) {
				/*if(svc.addMember(new Member(mid,name,phone,Integer.parseInt(point)))) */
						
					System.out.println("등록완료.");
				}else {
					System.out.println("등록실패.");
				}	
//			}
			break;
			//회원수정
			//반복 == q누르면 종료
		case 2:
			System.out.println("수정할 회원번호>>");
			mid = scn.nextLine();//nextInt처리
			System.out.print("수정할 회원이름>> ");
			name = scn.nextLine();
			System.out.print("연락처>> ");
			phone = scn.nextLine();
			System.out.print("포인트>> ");
			point = scn.nextLine();
			member = new Member(mid,name,phone,Integer.parseInt(point));
			if(svc.modifyMember(member)) {
			/*if(svc.addMember(new Member(mid,name,phone,Integer.parseInt(point)))) */
				System.out.println("수정완료.");
			}else {
				System.out.println("수정실패.");
			}
			break;
		case 3:
			//삭제
			System.out.print("삭제할 아이디>> ");
			mid = scn.nextLine();
			if(svc.removeMember(mid)) {
				System.out.println("삭제완료.");
			}else {
				System.out.println("삭제실패.");
			}	
			break;
		case 4:
			
			
			
			
			break;
		}//end of switch
	}//end of execute
}
