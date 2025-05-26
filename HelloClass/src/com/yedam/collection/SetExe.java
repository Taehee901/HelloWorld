package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Set컬렉션
 * 
 * 
 * */
public class SetExe {
	public static void main(String[] args) {
		//Set컬렉션.
		Set<String> set = new HashSet<String>();
		//추가
		set.add("홍길동");
		set.add("월요일");
		set.add("금요일");
		
		//삭제.
		if(set.contains("홍길동")) {
			System.out.println(set.remove("홍길동"));//false(없는경우)	System.out.println(set.remove("11홍길동"));
		}		
//		set.remove("홍길동") == true
		
		//순번붙여서가져올요소있는지없는지 체크하고
		//반복.hasNext()가져올요소있는지
		Iterator<String> iter = set.iterator();//반복자 획득.(순번요소를하나씩꺼집어내는지체크해서있으면 빼오겠음)
		//반복요소의 여부체크
		while(iter.hasNext()) {//가져올요소가몇개인지알수없으니까..
			String result = iter.next();//끄집어냄(있으면 한건)
			System.out.println(result);//더이상반복되는게없으면리턴
		}
	}
}
