package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backtracking_6_9663 {
	
	public static int[] arr;
	
	public static int N, count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		/*
		 * 체스판 - 배열의 인덱스 번호는 열, 인덱스 번호에 해당하는 값은 행으로 생각 
		 * Ex) arr[1] = 2; -> 1열의 3번째 행
		 */
		arr = new int[N];
//		N × N 체스판에 서로 공격하지 않도록 N개의 퀸 놓기(퀸은 상하좌우, 대각선 거리 제한 x)
		nQueen(0);
		
		System.out.println(count);
	}
	
	public static void nQueen(int depth) {
//		퀸이 N개가 되었을때
		if(depth == N) {
			count++;
			return;
		}
//		행 결정 
		for(int i = 0 ; i < N ; i++) {
			arr[depth] = i;
//			다음 퀸을 둘 자리 찾기
			if(doubleCheck(depth)) {
//				재귀를 통해 다음 열에 놓기
				nQueen(depth + 1);
			}
		}
	}
	
	public static boolean doubleCheck(int col) {
		for(int i = 0 ; i < col ; i++) {
//			같은 행과 열에 위치할 경우
			if(arr[col] == arr[i]) {
				return false;
//			대각선에 위치할 경우
			} else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
