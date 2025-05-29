package project;

import java.util.List;
import java.util.Scanner;

//import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

/*
 * 추가/삭제 등 얻어와서
 * main부분
 * 
*/
public class RpgApp {
	public void execute() {
		// 인터페이스

		// 메뉴
		System.out.println("==============🎡🎆🎇⚔🎡🎆🎇⚔===============");
		System.out.println("	  텍스트 기반 RPG게임 프로그램");
		System.out.println("=============================================");
		System.out.println("	1.캐릭터   2.불러오기  3.게임종료");
		System.out.print("선택>>");
		// 메뉴 읽어와야하넨
		RpgMemberService svc  = new RpgServiceDAO();
		Scanner scn = new Scanner(System.in);
		int menu = scn.nextInt();
		scn.nextLine();
		switch (menu) {
		case 1:
			ePgo();
			break;
		case 2:
			//내가입력한 id가 같으면 가지고와서 이벤트진행

//			}
			break;
		case 3:
			System.out.println("게임을 종료하시겠습니까?");
			System.out.println("1.y 2.n");
			System.out.println(">>");
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("게임을 종료합니다.");
			}
			break;
		}
		System.out.println("---end of prog-----");
	}// end of execute

	public static void ePgo() {
		RpgMemberService svc  = new RpgServiceDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		List <RpgMember> list = svc.memberList();
		List <GameEvent> glist = svc.addGame();
		while(run) {
		System.out.println("================👩캐릭터 목록👨=================");
		System.out.println("      1.캐릭터 생성  2.캐릭터 목록  3.캐릭터 삭제");
//		System.out.println(" 4.초기화면");
		System.out.print(">>");
		int selectnum = scn.nextInt();scn.nextLine();
		//값을 안받아서 오류
			switch(selectnum) {
			case 1:
				System.out.println("▪ 캐릭터를 만드시겠습니까?");
				System.out.println("1.y 2.n");
				System.out.print(">>");
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
				System.out.print("LV:");
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
				//테이블 ->
				//char생성
				//이벤트발생부분(rpg_Event)
				//보상부분(rpg_reworld)
				//캐릭터목록보여주는부분
			case 2:
				//캐릭터 목록
				System.out.println("================👩캐릭터 목록👨=================");
				System.out.println("아이디   이름   직업  나이");
				System.out.println("=============================================");
				for(RpgMember rlist : list) {
					System.out.printf("%s %s %s %d %d %d %d %d %s %d %d %s\n",rlist.getChId(),rlist.getChName(),rlist.getChJob(),rlist.getChAge(),rlist.getChExp(),rlist.getChLv(),rlist.getChGold(),rlist.getChHp(),rlist.getChAb(),rlist.getChAtck(),rlist.getChDef(),rlist.getChWeapon());
					//이름이나와..
					//몬스터 id 숫자 
				}
				System.out.println("==============================================");
				System.out.print("선택>>");
				String sen = scn.nextLine();
				for(int i = 0;i<list.size();i++) {
					for(int j = 0;j<glist.size();j++) {
						if(list.get(i).getChId().equals(sen)) {
							System.out.println("게임을 시작하시겠습니까?");
							System.out.println("1.y 2.n");
							System.out.print(">>");
							int selt = Integer.parseInt(scn.nextLine());
							
							switch(selt) {
							case 1:
								System.out.println("===================🏕게임 시작🏕========================");
								System.out.println("Q." +list.get(i).getChName()+glist.get(j).geteId());																									
							}

						}
//						System.out.println(list.get(i).getChName() );
					}

				}
				
			
				break;
			case 3:
				System.out.print("삭제할 아이디 선택>>");
				cid = scn.nextLine();
				if(svc.removeMember(cid)) {
					System.out.println("삭제되었습니다.");
				}else {
					System.out.println("삭제에 실패하였습니다.");
				}
				break;
			}
			run = false;
		}//end of while
	}// end of ePgo()
}// end of RpgApp
