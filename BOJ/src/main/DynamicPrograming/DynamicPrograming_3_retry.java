package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_3_retry {
//	배열 값을 받은만큼만 짜는게 더 효율적인가? 고민좀 해볼것.. 
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		초기 값 설정
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(count(N));
	}
	public static int count(int a) {
		if(a >= 1 && a <= 2) {
			return dp[a];
		}
		for(int i = 3 ; i <= a ; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
		return dp[a];
	}
}
