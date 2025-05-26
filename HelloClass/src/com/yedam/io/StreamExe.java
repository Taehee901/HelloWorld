package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * 보조스트림??
 * 정수 방식..
 * */
public class StreamExe {
	public static void main(String[] args) {
		//original2.PNG(1.5M) -> copy3.PNG
		//original2.PNG(1.79M) -> copy3.PNG
		try {
			InputStream is = new FileInputStream("c:/temp/original2.PNG");
			OutputStream os = new FileOutputStream("c:/temp/copy3.PNG");//최종도착지
			//보조스트림에 연결.
			//보조스트림의 생성자의 매개값으로 기본스트림을 연결한다.
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			//읽고 - 쓰기.
			while(true) {
				int data = bis.read();//버퍼크기만큼읽고
				if(data == -1) {//파일끝부분
					break;
				}
				bos.write(data);
			}
			//스트림 해제
//			bos.close();
//			bis.close();
//			os.close();
//			is.close();
			bos.close();bis.close();
			os.close();is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("end of prog.");
	}//end of main
	//읽고쓰는거 동시에 = copy
	
	
	//복사.
	public static void copy() {
		//입력 -> 출력.(외부파일읽어들임)
		try {
			//한번에읽어올수있는크기를조절할수있다
			//입력스트림(대상 - original.PNG)
			//1MB => 1000,000바이트 =>빨리 처리 write(byte[])
			//자바에서 대소문자구분,파일확장명도 그럼 보기 -파일확장명체크
			//inputstream에서 상속FileInputStream
			InputStream is = new FileInputStream("C:/temp/original2.PNG");
			//출력스트림(대상 - copy.PNG)
			OutputStream os = new FileOutputStream("C:/temp/copy2.PNG");
			//한번에 읽기쓰기 작업을 byte[]크기만큼 한번에 처리.
			//한번에 읽기쓰기 byte[]만큼한번에처리.
			byte[] buf = new byte[10];
			long start = System.currentTimeMillis();//시작시점.
			while(true) {
				//buf없을때 느림..
				//하나씩읽어와서 처리할때....
//				int data = is.read();// 1바이트 읽음,읽기
//				if(data == -1) {//더이상 읽을 파일이 x  == end of file
//					break;
//				}
//				os.write(data);//한바이트 한번 읽고 쓰기,
				int data = is.read(buf);// 1바이트 읽음,읽기
				if(data == -1) {//더이상 읽을 파일이 x  == end of file
					break;
				}
				os.write(buf);//한바이트 buf크기만큼 읽고 쓰기,byte크기를 10으로 해놨기에,한번에 10만큼쓰고읽음
			}
			os.close();
			is.close();
			long end = System.currentTimeMillis();//종료시점
			System.out.println("걸린시간: " + (end-start));
		} catch (IOException e) {//FileNotFoundException로 해결안되서 상위의 IOException로 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of copy
	
	
	//입력스트림.
	public static void read() {
		//입력(파일) = 바이트 기반.
		//예외처리때문에 오류 = try..catch
		try {
			InputStream is = new FileInputStream("C:/temp/os1.db");
			//read() 1바이트씩 읽기,값이 있으면 int반환,없을경우 파일을 끝까지 읽었는지 -1반환
			while(true) {
				int data = is.read();
				//더이상읽을값이없다 = -1
				if(data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();//사용했던 리소스를 끝냄
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//출력스트림
	public static void write() {
		//출력(파일) = 바이트 기반.
		try {
			OutputStream os  = new FileOutputStream("C:/temp/os1.db");
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);
			//출력스트림에 흘러보냄 = os1.db저장
			//입출력사용시 반드시 close(),scanner()마찬가지
			//바이트기반이라 읽지못함..
			os.close();
			
		} catch (IOException e) {//파일이없을경우
			e.printStackTrace();
		}
	}
}
