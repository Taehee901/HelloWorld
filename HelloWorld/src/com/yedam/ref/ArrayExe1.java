package com.yedam.ref;

public class ArrayExe1 {
	// 생성자,메서드,필드 선언
	public static void main(String[] args) {
		//기능메서드 안에 
		//int배열 =>intAry : 10,17,22,31,55,24
		//intAry [0]10~[5]24
		
		//Math.random 활용해서 10~100사이의 점수를 생성,
		//학생 10명의 점수를 생성해서 학생 점수의 평균을 구하고 //최고점수 구하시오
		//scoreAry 변수명
		int[] scoreAry = new int[10];
		int cont = 0;
		int sum =0;
		int score;
		int max =0;
		for(int i = 0;i<scoreAry.length;i++) {
			score = (int)(Math.random()*90)+10;			
			System.out.printf("%d,",score);
			sum += score;
			System.out.printf("%d\n,",sum);
			cont ++;
			if(score > max ) {
				max = score;
			}
		}
		double avg = 1.0*sum/cont;
		System.out.printf("평균은: %.1f,%d\n",avg,max);
			
	}

		
	//}//end of main
		public static void test2() {
		int[] intAry = {10,17,22,31,55,24};
		int temp =0;
		//정렬,뒤에오는 녀석이 크면 위치바꿈
			for(int j=0;j<intAry.length -1;j++) {
				for(int i = 0;i<intAry.length-1;i++) {
					//큰값기준으로 위치변경
					//뒤가 앞보다 클경우
	//				if(intAry[i] < intAry[i+1]) {
	//					temp = intAry[i];
	//					intAry[i] = intAry[i+1];
	//					intAry[i+1] = temp;
	//				}	
					//작읍값 기준으로 오름차순
					if(intAry[i] > intAry[i+1]) {
						temp = intAry[i];
						intAry[i] = intAry[i+1];
						intAry[i+1] = temp;
					}

				}
			}
			//출력
			for(int i = 0;i<intAry.length;i++) {
				System.out.printf("i :%d,값:%d\n",i,intAry[i]);
			}
	}//test2 end
			
}
		
//		
//		//최고값
//		int max = 0;
//		
//			//max와 배열요소를 비교. 큰값을 max에 저장.
//			if(max < intAry[i]) {
//				max = intAry[i];
//			}
//		}
//		System.out.printf("최대값은 %d\n",max);
//		if(max != 0) {
//			return;
//		}
//	

//		// 합
//		//인덱스가 짝수인경우
//		int sum = 0;
//////		for(int i = 0;i<intAry.length;i += 2) {
////		for(int i = 0;i<intAry.length;i++) {
////			if(i%2 == 0) {
////				sum += intAry[i];
////				System.out.printf("sum: %d, i: %d,값: %d\n",sum,i,intAry[i]);	// i += 2,증감을늘리든 			
////			}
//////		for(int i = 0;i<intAry.length;i++) {
////		}
////	}
//		int cnt = 0;//몇번 더해줬는지 횟수 저장
//		//실제 값 짝수인 녀석 나눠 판별
//		for(int i = 0;i<intAry.length;i++) {
//			if(intAry[i]%2 == 0) {
//				sum += intAry[i];
//				cnt ++;
//				System.out.printf("sum: %d, i: %d,값: %d\n",sum,i,intAry[i]);	// i += 2,증감을늘리든 		
//			}
//		}
//		double avg = 1.0* sum/cnt;
//		System.out.printf("평균: %.1f\n",avg);//무조건배열크기만큼나누는게아님
//	}
//}
//		test();
// end of main

//	public static void test() {
//		// 3,4,5,6
//		while (true) {
//			int num1 = (int) (Math.random() * 6) + 1;
//			int num2 = (int) (Math.random() * 6) + 1;
//			System.out.printf("(%d, %d)\n", num1, num2);
//			if (num1 + num2 == 5) {
//				break;
//			}
//		}
//
//		System.out.println("end of prog.");
//		// 4 h
//		for(int x = 0;x<10;x++) {
//			for(int y = 0;y<10;y++) {
//				if((x+y) == 60) {
//					System.out.printf();
//				}
//			}
//		}
//			
//
//		// 5
//		for (int outer = 1; outer <= 4; outer++) {
//			for (int inner = 1; inner <= 4; inner++) {
//				if (outer >= inner) {// 크거나같을동안만 *찍음
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
//
//		// 6
//		for (int outer = 1; outer <= 4; outer++) {
//			for (int inner = 1; inner <= 4; inner++) {
//				if (outer + inner >= 5) {
//					System.out.print("*");
//				} else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();//줄바꿈.
//		}
//
//		// 거꾸로
//		for (int outer = 1; outer <= 4; outer++) {
//			for (int inner = 1; inner <= 4; inner++) {
//				if (outer + inner <= 5) {// 크거나같을동안만 *찍음
//					System.out.print("*");
//				} else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}
//	}// enf of class
//}