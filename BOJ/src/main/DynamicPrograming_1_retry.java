package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_1_retry {
	/*
	 * 테스트 케이스 개수 
	 * 피보나치 수열 구할 때 0과 1이 나온 개수 
	 * 자연수의 범위는 0 ~ 40 
	 * 출력은 공백으로 구분하여 출력
	 */
	public static int[][] fibo = new int[41][2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
//		배열 -1로 초기화(기본값이 0이므로 함수에 0입력시 잘못된 값 나올 수 있음) 
		for(int i = 2 ; i < fibo.length ; i++) {
			for(int j = 0 ; j < fibo[i].length ; j++) {
				fibo[i][j] = -1;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(fibo[N][0] + " " + fibo[N][1] + "\n");
		}
		System.out.println(sb);
	}
	public static int[] fibonacci(int N) {
		if(fibo[N][0] == -1 || fibo[N][1] == -1) {
			fibo[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[0];
			fibo[N][1] = fibonacci(N-1)[1] + fibonacci(N-2)[1];
		}
		return fibo[N];
	}
}
