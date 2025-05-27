package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출략 스트림.
 * 기본타입 - 참조타입
 * int num = 10,실제 num변수에실제값이담겨짐
 * Member member = new Member();//멤버의 주소값을가지고,실체는 힙영역에있고,객체가만들어진위치의주소값을가지고있다.
 * 참조    주소
 * byte로 쓰고싶으면 객체를 기본타입으로 변환
 * = 직렬화(Serialization):객체 -> 기본
 * = 아무객(개?)체x, Serialization 인터페이스 구현하는 클래스들만 가능(역직렬화,직렬화가능)
 * 
 * 역직렬화(Deserialization):기본 -> 객체
 * 
 * */
//Serializable구현하는클래스로 선언해줌
class Product implements Serializable{
	String prodCode;//필드
//	String prodName;
	//생성자
	public Product(String prodCode) {
		this.prodCode = prodCode;
	}
	
}

public class StreamExe4 {
	public static void main(String[] args) {
		try {
			//stream저장타입은 기본타입,객체도처리하도록하겠습니다.가능한클래스만가능,
			//기본 ->객체.
			InputStream is = new FileInputStream("c:/temp/object.db");
			ObjectInputStream ois = new ObjectInputStream(is);
			//List객체
			List<Product> list =  (List<Product>) ois.readObject();//ClassNotFoundException,readObject =>object 최상위부모라 모든 데이터타입반환가능
			for(Product product : list) {
				System.out.println("상품코드: " + product.prodCode);
			}
			
		} catch (Exception e) {//최상위예외처리
			e.printStackTrace();
		}
		
		System.out.println("end of prog");
		
	}
	
	static void serial() {//객체 ->출력스트림(기본타입으로 변환 후 저장해서),Object->byte(주소값,실제값x)
		
//		List<String> list = new ArrayList<>();//클래스 = 객체
		List<Product> list = new ArrayList<>();
		list.add(new Product("P001"));//객체담음
		list.add(new Product("P002"));
		
		try {
			//기본스트림.
			OutputStream os = new FileOutputStream("c:/temp/object.db");
			//객체 입출력 보조 스트림.
			//클래스가 Serializable를 구현하는 클래스여야지만 ObjectOutputStream가능
			ObjectOutputStream oos = new ObjectOutputStream(os);
			//알아서바로스트림에저장됨list
			oos.writeObject(list);//객체 ,writeObject객체를 출력스트림에 전달 보조 스트림
			oos.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
