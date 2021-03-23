package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_9_10844 {
	
	static Long[][] dp;
	static final long MOD = 1000000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
//		dp[N번째 자리수][숫자];
		dp = new Long[N+1][10];
		
		long result = 0L;
		
//		한 자리수로 이루어진 계단수는 각 1개씩 밖에 없으므로 1로 초기화  
//      두자리 수 중 2번째 자리수가 1인 경우의 수는 10 12 이므로 첫번째자리인 0도 1로 초기화 필요!
		for(int i = 0 ; i < 10 ; i++) {
			dp[1][i] = 1L;
		}
		
		for(int i = 1 ; i < 10 ; i++) {
			result += find(N, i);
		}
		
		System.out.println(result % MOD);
	}
	
	public static long find(int digit, int val) {
//		첫째 자리수 즉, 일의 자리에 도달 시 초기화된 값을 리턴
		if(digit == 1) {
			return dp[digit][val];
		}
//		탐색하지 않은 경우
		if(dp[digit][val] == null) {
//			N번째 자리의 숫자가 0인 경우 올 수 있는 경우의 숫자는 1밖에 없음
			if(val == 0) {
				dp[digit][val] = find(digit-1, 1);
//			N번째 자리의 숫자가 9인 경우 올 수 있는 경우의 숫자는 8밖에 없음
			} else if(val == 9) {
				dp[digit][val] = find(digit-1, 8);
//			그 외의 경우는 해당 val 값의 -1, +1이 올 수 있음
			} else {
				dp[digit][val] = find(digit-1, val-1) + find(digit-1, val+1);				
			}
		}
		
		return dp[digit][val] % MOD;
	}
}
