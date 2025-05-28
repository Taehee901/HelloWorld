package co.yedam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 등록,수정,삭제,목록 기능을 구현.
 * 저장은 storage에 반영하도록 함.
 */
public class EmpDAO {
	// 사원정보를 저장하는 컬렉션.
	//정보저장
	List<Employee> storage = new ArrayList<Employee>();
	Scanner scn = new Scanner(System.in);
	String id = null;
	String name = null;
	String tel = null;
	String date = null;
	int num = 0;

	//등록
	public void empIn() {
		System.out.print("사번입력>>");
		id = scn.nextLine();
		System.out.print("이름입력>>");
		name = scn.nextLine();
		System.out.print("전화번호입력>>");
	    tel = scn.nextLine();
		System.out.print("입사일입력>>");
	    date = scn.nextLine();
		System.out.print("급여입력>>");
		num = scn.nextInt();scn.nextLine();		
		Employee emp = new Employee(id,name,tel,date,num);
		if(storage.add(emp)) {
			System.out.println("등록완료");	
		}
	}
	//목록
	public void empView() {
		System.out.printf("%-5s %-5s %-10s\n", "사번","이름","전화번호");
		for(int i = 0;i<storage.size();i++) {
			if(storage.get(i) != null) {
				System.out.printf("%-5s %-5s %-10s\n",storage.get(i).getEmpId(),storage.get(i).getEmpName(),storage.get(i).getEmpPhone());
			}
		}
		
	}
	//수정
	public void empModify() {
		System.out.print("사번 급여>>");
		id = scn.nextLine();
		num = scn.nextInt();scn.nextLine();
		for(int i = 0;i<storage.size();i++) {
			if(storage.get(i).getEmpId().equals(id)) {
				storage.get(i).setEmpPoint(num);
			}
		}
	}
	//삭제
	public void empRemove() {
		System.out.print("사번>>");
		id = scn.nextLine();
		for(int i=0;i<storage.size();i++) {
			if(storage.get(i).getEmpId().equals(id)) {
				storage.remove(i);
				System.out.println("삭제완료.");
			}
			else {
				System.out.println("삭제실패.");
			}
		}
	}
	
	//조회
	public void empCheck() {
//		System.out.print();
		System.out.print("입사일자>>");
		date = scn.nextLine();
		System.out.printf("%-5s %-5s %-10s\n", "사번","이름","입사일자");
		for(int i = 0;i<storage.size();i++) {
			if(storage.get(i)!= null &&(date.equals("")|| date.equals(storage.get(i).getEmpHiredate()))) {
				System.out.printf("%-5s %-5s %-10s\n",storage.get(i).getEmpId(),storage.get(i).getEmpName(),storage.get(i).getEmpHiredate());
			}
		}
	}

}
