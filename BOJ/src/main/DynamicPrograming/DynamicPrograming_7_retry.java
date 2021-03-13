package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_7_retry {
	/*
		N = 계단의 개수 
		stair = 계단의 점수를 담는 배열
		dp = 메모이제이션 배열 
	*/
	static int N;
	static int[] stair;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stair = new int[N+1];
		dp = new int[N+1];
//		시작 계단을 0번째 배열로 설정, 배열 stair에는 계단의 점수, 배열 dp는 -1로 초기화 
		for(int i = 1 ; i <= N ; i++) {
			stair[i] = Integer.parseInt(br.readLine());
			dp[i] = -1;
		}
		
		dp[0] = stair[0];
		dp[1] = stair[1];
		
		/*
		 * 반복되는 조건이 
		 * 1. N-2에서 N으로 가는 경우 
		 * 2. N-3에서 N-1을 거쳐 N으로 가는 경우  
		 * 두 가지 이므로 N=2 일 경우 
		 * -1로 배열 인덱스를 벗어 나게됨
		 */	
		if(N >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		System.out.println(find(N));
	}
	static int find(int N) {
//		방문 하지 않았을 경우
		if(dp[N] == -1) {
			dp[N] = Math.max(find(N-2), find(N-3) + stair[N-1]) + stair[N];
		}
		return dp[N];
	}
}
