package project;

import java.util.Scanner;

/*
 * 추가/삭제 등 얻어와서
 * main부분
 * 
*/
public class RpgApp {
	//먼저실행되는 
	public void execute() {
		Scanner scn = new Scanner(System.in);
		//인터페이스
		RpgMemberService svc  = new RpgServiceDAO();
		System.out.println("===============================");
		System.out.println("텍스트 기반 RPG게임 프로그램");
		System.out.println("===============================");
		System.out.println("1.캐릭터 생성 2.게임시작 3.게임종료");
		System.out.print("선택>>");
		
		//메뉴선택
//		boolean run = true;
		int menu = scn.nextInt();scn.nextLine();
//		while(run) {
			switch(menu) {
			case 1:
				//값을 안받아서 오류
				System.out.print("아이디: ");
				String cid = scn.nextLine();
				System.out.print("이름: ");
				String cname = scn.nextLine();
				System.out.print("직업: ");
				String cjob = scn.nextLine();
				System.out.print("나이: ");
				String cage = scn.nextLine();
				System.out.print("exp: ");
				String cexp = scn.nextLine();
				System.out.println("LV:");
				String chLv = scn.nextLine();
				System.out.print("자본: ");
				String cgole = scn.nextLine();
				System.out.print("hp: ");
				String chp = scn.nextLine();
				System.out.print("능력: ");
				String cad = scn.nextLine();
				System.out.print("ack: ");
				String cactk = scn.nextLine();
				System.out.print("def: ");
				String cdef = scn.nextLine();
				System.out.print("무기: ");
				String cwea = scn.nextLine();
				//Integer.parseInt(cage),Integer.parseInt(cexp),Integer.parseInt(chLv),Integer.parseInt(chp),Integer.parseInt(cgole),Integer.parseInt(chp),cad,Integer.parseInt(cactk),Integer.parseInt(cdef),cwea
				RpgMember rpgch = new RpgMember(cid,cname,cjob,Integer.parseInt(cage),Integer.parseInt(cexp),Integer.parseInt(chLv),Integer.parseInt(cgole),Integer.parseInt(chp),cad,Integer.parseInt(cactk),Integer.parseInt(cdef),cwea);
				if(svc.addMember(rpgch)) {
					System.out.println("캐릭터생성완료");
				}
				else {
					System.out.println("캐릭터생성실패");
				}
				break;
			case 2:
			
				System.out.println("===========🏕게임 시작=========");
				System.out.println("마을에 진입하였습니다.무엇을 하시겠습니까?");
				System.out.println("1.훈련 2.알바 3.휴식");
				System.out.print("선택>>");
				//이벤트 발생부분 구현
			case 3:
//				run = false;
				break;
				
			}
			System.out.println("---end of prog-----");
//		}//
	}//end of execute
}
	
