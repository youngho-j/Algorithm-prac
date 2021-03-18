package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_8_1463 {
	
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1]; 
		
//		배열 초기화
		for(int i = 1 ; i <= N ; i++) {
			dp[i] = -1;
		}
		
		dp[0] = 0;
		dp[1] = 0;
		
		System.out.println(find(N));
	}
	
	static int find(int N) {
		// 탐색하지 않았을 경우 
		if(dp[N] == -1) {
			if(N % 6 == 0) {
				dp[N] = Math.min(find(N-1), Math.min(find(N/3), find(N/2))) + 1;
			} else if(N % 3 == 0) {
				dp[N] = Math.min(find(N/3), find(N-1)) + 1;
		    } else if(N % 2 == 0) {
		    	dp[N] = Math.min(find(N/2), find(N-1)) + 1;
			} else {
				dp[N] = find(N-1) + 1;
			}			
		}		
		return dp[N];
	}
	
}
