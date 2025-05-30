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
	RpgMemberService svc  = new RpgServiceDAO();
	List <RpgMember> list = svc.memberList();
	List <GameEvent> glist = svc.addGame();
	List <RpgFoe> rlist = svc.rpgfoe();
	Scanner scn = new Scanner(System.in);
	int selectnum;

	public void execute() {
		// 인터페이스
		//구조 변경 필요(while문 밖)

		boolean run = true;
		while(run) {
		gamehome();
		System.out.print("선택>>");
		int menu = scn.nextInt();
		scn.nextLine();
		switch(menu) {
		case 1:
			eCharc();
		break;

		case 2:
			gameOver();
		break;
		}
		run = false;
	}
}
	
	public void gamehome() {
		
		System.out.println("==============🎡🎆🎇⚔🎡🎆🎇⚔===============");
		System.out.println("	  텍스트 기반 RPG게임 프로그램");
		System.out.println("=============================================");
		System.out.println("	1.게임시작 2.게임종료");

	}
	public void gameOver() {
		System.out.println("게임을 종료하시겠습니까?");
		System.out.println("1.y 2.n");
		System.out.println(">>");
		selectnum = scn.nextInt();
		scn.nextLine();
		if (selectnum == 1) {
			System.out.println("게임을 종료합니다.");
		}
		else if(selectnum == 2) {
			execute();
		}
	}
//		System.out.println("---end of prog-----");


	public void eCharc() {
		System.out.println("================👩캐릭터 목록👨=================");
		System.out.println("      1.캐릭터 생성  2.캐릭터 목록  3.캐릭터 삭제");
		System.out.print(">>");
		int chmenu = scn.nextInt();scn.nextLine();
		switch(chmenu) {
		case 1:
			System.out.println("▪ 캐릭터를 만드시겠습니까?");
			System.out.println("1.y 2.n");
			System.out.print(">>");
			selectnum = scn.nextInt();scn.nextLine();
			if(selectnum == 1) {
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
				RpgMember rpgch = new RpgMember(cid,cname,cjob,Integer.parseInt(cage),Integer.parseInt(cexp),Integer.parseInt(chLv),Integer.parseInt(cgole),Integer.parseInt(chp),cad,Integer.parseInt(cactk),Integer.parseInt(cdef),cwea);
				if(svc.addMember(rpgch)) {
					System.out.println("캐릭터생성완료");
				}
				else {
					System.out.println("캐릭터생성실패");
				}
			}
			else if(selectnum == 2){
				execute();
			}
			break;
		case 2:
			CharList();
		break;
		case 3:
			CharDelete();
		break;
		}
	}
	
	
	
public void CharList() {
//		boolean runs = true;
		System.out.println("================👩캐릭터 목록👨=================");
		System.out.println("아이디   이름   직업  나이");
		System.out.println("=============================================");
		for(RpgMember rlist : list) {
			System.out.printf("%s %s %s %d %d %d %d %d %s %d %d %s\n",rlist.getChId(),rlist.getChName(),rlist.getChJob(),rlist.getChAge(),rlist.getChExp(),rlist.getChLv(),rlist.getChGold(),rlist.getChHp(),rlist.getChAb(),rlist.getChAtck(),rlist.getChDef(),rlist.getChWeapon());
		}
		System.out.println("==============================================");
		System.out.print("선택>>");
		String sen = scn.nextLine();
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).getChId().equals(sen)) {
				System.out.println("게임을 시작하시겠습니까?");
				System.out.println("1.y 2.n");
				System.out.print(">>");
				selectnum = Integer.parseInt(scn.nextLine());
				switch(selectnum) {
				case 1:
					
					int events = (int)(Math.random() * glist.size());
					GameEvent gs = glist.get(events);
						int foes = (int)(Math.random() * rlist.size());
						RpgFoe rf = rlist.get(foes);
//						System.out.println(foes);
//						for(int j = 0;j<rlist.size();i++) {
//							if(gs.geteName().equals(rlist.get(j).getMonName())) {
								System.out.println("===================🏕게임 시작🏕========================");
								System.out.printf("%s님의 현재 상태 => exp[%d] hp[%d]\n",list.get(i).getChName(),list.get(i).getChExp(),list.get(i).getChHp());
								System.out.printf("적 hp: [%d]\n",rf.monHp);
								System.out.printf("Q. %s는 %s(을/를) %s\n",list.get(i).getChName(),gs.geteName(),gs.geteAction());	
								System.out.println("1.싸운다.");
								System.out.println("2.도망간다.");	
								System.out.print(">>");
								int selectnums = scn.nextInt(); scn.nextLine();
								if(selectnums == 1) {
									System.out.printf("====================⚔ %s와 전투를 시작합니다.⚔========================\n",gs.geteName());
//											if(list.get(i).getChHp() == 0){
//												System.out.println("사망하였습니다.");									
//											}
									System.out.printf("%s님의 현재 상태 => exp[%d] hp[%d]\n",list.get(i).getChName(),list.get(i).getChExp(),(list.get(i).getChHp()-rf.monAtk));
//											if(rf.setMonName().equals())
									System.out.printf("적 hp: [%d]\n",rf.monHp);
									System.out.println("Q."+gs.geteName()+"(은/는)공격합니다");
									System.out.println("1.도망친다 2.피한다 3.공격한다");
									System.out.print(">>");
									int warmenu = scn.nextInt();scn.nextLine();
									switch(warmenu) {
											case 1:
												System.out.println("집가고싶다");
												break;
											case 2:
												System.out.println("피한다");
												break;
											case 3:
												System.out.println("공격한다.");
												break;	
										}
//										else {
//																
//											}
//										runs = false; 
									}
							}
						}
						break;
						}
				}
//			}
//		}
	//list에다가 퀘스트내용을 저장하게만들어주고,random으로 돌려서 출력
//}//end eCharList	
	public void CharDelete() {
		System.out.println("캐릭터를 삭제하시겠습니까?");
		System.out.print("삭제할 아이디 선택>>");
		String cid = scn.nextLine();
		System.out.println("1.y 2.n");
		System.out.print(">>");
		selectnum = Integer.parseInt(scn.nextLine());
		switch(selectnum) {
		case 1:
			if(svc.removeMember(cid)) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("삭제에 실패하였습니다.");
			}
			break;
		case 2:
			eCharc();
		}
	}
		
				//테이블 ->
				//char생성
				//이벤트발생부분(rpg_Event)
				//보상부분(rpg_reworld)
				//캐릭터목록보여주는부분
				//캐릭터 목록

}// end of RpgApp
