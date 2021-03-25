package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_10_retry {
	
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		dp = new int[n+1];
		
		for(int i = 1 ; i < n + 1 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = -1;
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		if(n > 1) {
			dp[2] = arr[1] + arr[2];
		}
		//테스트.. 안올라가는데;;
		System.out.println(find(n));
		br.close();
	}
	
	static int find(int n) {
		if(dp[n] == -1) {
			dp[n] = Math.max(Math.max(find(n-2), find(n-3) + arr[n-1]) + arr[n], find(n-1));
		}
		return dp[n];
	}
}
