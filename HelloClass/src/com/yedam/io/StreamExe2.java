package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * 문자기반..char 2byte씩처리,16bit
 * char기반의 출력스트립
 * Writer
 * */

public class StreamExe2 {
	public static void main(String[] args) {
		//Scanner 파일 읽어오는..
		//예외처리필요
		//그동안은 키보드를 읽어왔으면 new File()로 파일을 들고옴
		Scanner scanner  = null;
		try {
			scanner = new Scanner(new File("c:/temp/writer.txt"));//외부파일을읽어옴
//			try {
				while (true) {
					String data = scanner.nextLine();// 한라인을 읽어옴 == 홍길동 70
//					if(data == null) {
//						break;
//					}
					//데이터가 문자열타입
					//홍길동 70,앞 뒤를 나누어(=잘라서) 새로운 배열에 담아줌
					//구분자를 기준으로 배열.
					String[] strAry = data.split(" ");//공백이라는 구분자의 기준으로 나눈다,split 구분자를기준으로 나누어 새로운 배열에 넣어준다
					System.out.println(strAry[0] + ", " +strAry[1]);
				}
			} catch (Exception e) {
					e.printStackTrace();
			}finally {
				scanner.close();				
			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("end of prog.");
	}// end of main

	// 입력
	public static void read() {
		// Char기반의 입력스트림.
		try {
			Reader reader = new FileReader("c:/temp/writer.txt");
			while (true) {// 파일이어느정도큰지모르니까 반복문써서 data가 -1(파일의끝)break
				int data = reader.read();// 한문자씩읽어옴
				if (data == -1) {
					break;
				}
				System.out.print((char) data); // 아스키코드 6~ 캐스팅
			}
			reader.close();
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 출력
	public static void write() {
		try {
			// char기반의 출력스트림. == 값을 볼수있다.
			// Writer
			Writer wr = new FileWriter("c:/temp/writer.txt");
			wr.write('A');
			wr.write('B');
			wr.write('C');
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}