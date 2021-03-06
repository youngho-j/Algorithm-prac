package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_4_9461 {
	static long[] dp = new long[101];
	
	public static void main(String[] args) throws IOException{
		setDp();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(result(a)).append("\n");
		}
		System.out.println(sb);
	}
	public static long result(int a) {
		if(dp[a] == -1) {
			dp[a] = result(a-3) + result(a-2);
		}
		return dp[a];
	}
	public static void setDp() {
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
//		배열을 생성시 빈값이 무슨 값이 들어있는지 모르므로 초기화를 해주는게 좋음
		for(int i = 4 ; i < 101 ; i++) {
			dp[i] = -1;
		}
	}
}
