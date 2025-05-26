package com.yedam.collection;

//Gson라이브러리를 다운(외부라이브러리) --> maven repository
//maven프로젝트 아니라 jar 다운..
//프로젝트마다따로지정가능

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
//import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * Map 컬렉션
 * {키 : 값} 추가
 * 
 * 
 * */

//학생(이름,점수)클래스 선언
//파일이 달라도 이미 선언되어있어 변경
class Student2{
	private String studentName;
	private int score;
	
	//생성자 선언.
	public Student2(String studentName,int score) {
		this.studentName = studentName;
		this.score = score;
		
	}
	//hashCode,equals => 이름,점수 같으면 동등객체.오버라이딩(서로다른객체주소값이지만 이걸 통해 논리적으로 동등한값으로 처리해줌)
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return score;//리턴타입이 int라
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student2)//obj가 student2가 맞는지
		{
			//캐스팅 = 형변환
			//object에는 student2가 없기에..
			Student2 std = (Student2)obj;
			//이름과 점수 다같으면 true
			return this.studentName.equals(std.getStudentName())//
					&&this.score == std.getScore();
				
		}
		return false;	
	}
	//getter
	public String getStudentName() {
		return studentName;
	}
	public int getScore() {
		return score;
	}
}



public class MapExe {
	//ctrl +shift+o
//(키-문자열,값-integer타입일경우라면아래와같이)
	public static void main(String[] args) {
		// 학생,반 =>반복x
		Map<Student2,String> map;
		map = new HashMap<Student2, String>();
		
		//추가
		//기본생성자x,매개값2개
		map.put(new Student2("홍길동",70), "1반");
//		map.put(new Student2("홍길동",80), "2반");
		map.put(new Student2("김민규",80), "2반");
		//객체는항상주소값이기준 => 값이 늘 다름(생성위치를가리키기에 새로만들면값이늘다름)
		map.put(new Student2("박철승",75), "1반");
		map.put(new Student2("최성철",85), "2반");
		
		//반복문.
		//set hascode결과값과 equals결과값이 같아야지 논리적으로 동등하다..
		String keyworld = "홍길동";
		int score = 70;
		
		
		//⭐객체를 비교연산자(==)로 비교할 경우 false;
		//student2의 주소값이 항상다름
		//인스턴스의값이달라도 이름과 점수부분이같아서,논리적으로같다고해줌
		System.out.println(new Student2(keyworld,score)== new Student2(keyworld,score));
		
		//두개 필드값을 알고있음..
		//중복된값을받지못함..기존값을 오버라이딩해버림,해시코드와.equlas를 어떻게 정의하냐에따라 다름
		//객체는 만들어질때마다다름,new Student2(keyworld,score))
		//map key =>Student2,해시코드 .equlas 동등값정의해두었음
		//map.containsKey(keyworld)방식
		if(map.containsKey(new Student2(keyworld,score))) { //=>아래와 주소값이다름
			System.out.println("반: " //
					+ map.get(new Student2(keyworld,score)));
		}
		
		
		
		
//		Set<Student2>set = map.keySet();
//		for(Student2 std : set) {//set갯수만큼반복 =>잘안씀,반복자를통해요소를가져옴,기능은되지만..
//			
//		}
		//반복자
//		Iterator<Student2> iter = set.iterator();
//		while(iter.hasNext()) {
//			Student2 std = iter.next();//한건획득,순번은없음..
//			//한건가지고온녀석 student2 std에 저장
//			if(std.getStudentName().equals(keyworld)){//이름이 키워드랑 같은지 물음
////				System.out.println("점수: " + std.getScore());
//				
//				//이름과,점수기준으로 어느반인지알고싶다..
//				//비교기준,key 동등한객체인지아닌지어떻게체크?논리적인비교,(주소)값은다르지만 반환해주는 값이 같아야..
//				//이름,score
//				String cls = map.get(std);//반정보
//				//std 객체를 map찾아옴
////				System.out.println("반: "+cls);
//				System.out.printf("이름: %s, 점수: %d, 반: %s\n",std.getStudentName(),std.getScore(),cls);
//				
//			
//			}
//		}//end of while.
	}//end of main.
	public static void exe2() {
		//Map<String,String> ==> map구조의 key,value가 문자열일 경우
		Map<String,String> map;
		map = new HashMap<String, String>();
		map.put("user01", "1111");//또다른 객체도 있을 수 있음
		map.put("user02", "2222");
		map.put("user03", "3333");
		
		//값이있는지 체크
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			//아이디와 비번입력
			System.out.println("아이디를 입력>> ");
			String id = scanner.nextLine();
			System.out.println("비밀번호를 입력하세요>> ");
			String pw = scanner.nextLine();
			
			//map객체에서 입력한 아이디에서만 키값들 중에 이 값이 있는지 확인하는거
			//containsKey ==> 맵에서 키나 값이 있는지 확인하는..=>Map에 파라미터로 입력받은 값과 같은 값이 있으면 true를 리턴
			if(map.containsKey(id)) {
				//키가 존재 => 비밀번호 체크.
				if(map.get(id).equals(pw)) {//사용자패스워드비교
					System.out.println("로그인되었습니다.");
					break;//반복문종료 아랫코드사용안함
//				}else {//else가없어도 break;로 반복문 종료,아닐경우 아랫쪽코드 실행
				}
				System.out.println("비밀번호가 일치하지않습니다.");
//				}
			}else {
				System.out.println("입력하신 아이디가 없습니다.");
			}
		}//end of while
		
				
			//자바객체(map) -> JSON 문자열 출력.
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(map); //문자열 형식.
			System.out.println(json);
		}

	public static void exe() {
		
		Map<String,Integer>map = new HashMap<String,Integer>();//객체선언
		//추가
		map.put("홍길동", 80);//map객체
		map.put("김민수",70);
		map.put("홍길동", 85);//중복키가있을경우 어떤거 반환할지 정해야함,나중에등록된값이 과거값을 덮어쓰는 오버라이딩?로딩?발생해서 나중값으로 나옴
		map.put("박철민", 90);
		
		//자바객체(map) -> JSON 문자열로 출력.
		//구글에서 제공
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map); //문자열 형식.
		System.out.println(json);
		

		//삭제..
//		map.remove("홍길동");//홍길동.80이 85로 변경되서,삭제하면 김민수만 남는다.
		
		
		//조회(키->값)
		//조회(키값을넣어주면 값을 반환해주는 메소드사용하면됨)
		Integer score = map.get("홍길동");//키에해당되는 값을 넣어주면 스코어에 담긴 값이 반환
		System.out.println(score);//새로추가된값으로변경(85)
		
		
		//키 반환메소드제공..키를알면 value를 알수 있음
		//반복 
		//set컬렉션은 string타입
		Set<String> keyset = map.keySet();//키에해당되는부분을 반환,set컬렉션
		//반복자획득.
		//Iterator<String>반환타입
		//마우스올리면 Iterator<String> java.util.Set.iterator()
		
		//키값만들고옴
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {//반복된요소가있는지확인
			String key = iter.next(); //반복요소를 하나 가져오겠다. //반복요소 획득,있 t 없 f
			Integer value = map.get(key);//value해당되는 값
			System.out.printf("키: %s, 값: %d\n",key,value);
		}
		
		//{키: 값}반환(엔트리타입),키와값동시에가진거 == Map.Entry타입.
		//{키: 값}반환.Map.Entry타입.
		 
		Set<Entry<String,Integer>> entryset = map.entrySet();
		//요소를 하나씩선택하려면 반복자필요
		Iterator<Entry<String,Integer>> iter2 =  entryset.iterator();
		//요소체크
		while(iter2.hasNext()) {
			Entry<String,Integer> entry = iter2.next();//호출될때마다 요소하나씩가져옴
			//getKey메소드(해당키리턴),getValue(값)반환
			System.out.printf("키: %s, 값: %d\n",entry.getKey(),entry.getValue());			
		}
		
	}
}
