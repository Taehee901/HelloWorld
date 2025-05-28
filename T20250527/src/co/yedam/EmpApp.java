package co.yedam;
//main메소드
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		// 앱을 실행하는 클래스.
		EmpDAO dao = new EmpDAO();

		// 사용자의 입력을 처리하도록 작성하세요.
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			// 이곳에 메뉴작성.
			// 1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(입사일자) 6.종료
			System.out.println("----------------------");
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:
				dao.empIn();
				break;
			case 2:
				dao.empView();
				break;
			case 3:
				dao.empModify();
				break;
			case 4:
				dao.empRemove();
				break;
			case 5:
				dao.empCheck();
				break;
			case 6:
				run = false;
				break;
			}
		}
		System.out.println("end of prog.");
	} // end of main.
}
