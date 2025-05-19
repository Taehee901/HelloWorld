package com.yedam.ref;
/*
 * 2차원 배열.
 * intAry[2][3],
 * 2 ->배열의 크기
 * 3->칼럼크기
 * 
 */
public class ArrayExe2 {
	public static void main(String[] args) {
		int [][] intAry = {{17,22,31,55},{28,38,12}};//변수는 int int형타입 배열
//		intAry[0] => {17,22,31};//[]위치의 배열 => intAry[0][0]
//		intAry[1] => {28,38,12}; //38위치 ->intAry[1][1]
		//outer 행 ,inner 컬럼요소값
		intAry[0][2] = 44;
		for(int outer = 0;outer<intAry.length;outer++) {
			for(int inner = 0;inner<intAry[outer].length;inner++) {
				System.out.printf("intAry[%d][%d]=>%d\n",outer,inner,intAry[outer][inner]);
			}
		}
		//정방행렬(같은수의 행과 열가지는)
		//배열크기지정 
		//[3][4],배열 1 ->new int[5]
		int [][] ary2 = new int [3][4];
		
		
		//(int)(Math.random()* 100)+1
		int sum = 0;
		for(int o = 0;o<ary2.length;o++) {
			for(int i = 0;i<ary2[o].length;i++) {
				ary2[o][i] = (int)(Math.random()* 100)+1;
				//ary2[1]인 경우에만 합.
				if(o == 1) {
					sum += ary2[o][i];
				}
				System.out.printf("ary2[%d][%d]=>%d\n",o,i,ary2[o][i]);
			}
		}
		System.out.printf("ary[1]요소의 합: %d\n",sum);
	}
}
