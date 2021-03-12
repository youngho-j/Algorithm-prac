package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_7_2579 {
	static int[] stair;
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stair = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			stair[i] = Integer.parseInt(br.readLine());
			dp[i] = -1;
		}
		dp[0] = stair[0];
		dp[1] = stair[1];
		
		// N이 2와 같거나 큰 경우 2까지 가는 최대 값
	    // 해당 조건이 없을 때 N = 2가 되면 stairPoint(-1)이 되므로 에러
		if(N >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		
		System.out.println(stairPoint(N));
	}
	public static int stairPoint(int N) {
		if(dp[N] == -1) {
			// N에 도달하기 위한 방법은 N-3 -> N-1 -> N / N-2 -> N 두가지 방법이 존재하고,
			// N-3 -> N-1 -> N 경로에서 N-1 -> N으로 가는 방법은 한가지 이므로 배열값을 그대로 가져온다. 
			dp[N] = Math.max(stairPoint(N-2), stairPoint(N-3) + stair[N-1]) + stair[N];
		}
		return dp[N];
	}
}
