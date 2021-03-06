package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_7_14888 {
	
	public static int[] cals = new int[4];
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static int[] arr;
	public static int num;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Integer.parseInt(br.readLine());

		arr = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < num ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < 4 ; i++) {
			cals[i] = Integer.parseInt(st.nextToken());
		}
		
		insertOperator(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void insertOperator(int number, int idx) {
//		모든 연산자 삽입을 완료했을경우 
		if(idx == num) {
			max = Math.max(max, number);
			min = Math.min(min, number);
			return;
		}
		
		for(int i = 0; i < 4 ; i++) {
//			연산자 개수가 존재하는 경우
			if(cals[i] > 0) {
//				해당 연산자에서 1 감소
				cals[i]--;
//				해당 연산자에 맞는 계산을 실행 후 재귀
				switch (i) {
				case 0:
					insertOperator(number + arr[idx], idx + 1);
					break;
				case 1:
					insertOperator(number - arr[idx], idx + 1);
					break;
				case 2:
					insertOperator(number * arr[idx], idx + 1);
					break;
				case 3:
					insertOperator(number / arr[idx], idx + 1);
					break;
				}
//				재귀 종료 후 해당 연산자 개수 복구
				cals[i]++;
			}
		}
	}
}
