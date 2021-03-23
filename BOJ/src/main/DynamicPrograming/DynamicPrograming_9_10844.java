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
//		dp[N��° �ڸ���][����];
		dp = new Long[N+1][10];
		
		long result = 0L;
		
//		�� �ڸ����� �̷���� ��ܼ��� �� 1���� �ۿ� �����Ƿ� 1�� �ʱ�ȭ  
//      ���ڸ� �� �� 2��° �ڸ����� 1�� ����� ���� 10 12 �̹Ƿ� ù��°�ڸ��� 0�� 1�� �ʱ�ȭ �ʿ�!
		for(int i = 0 ; i < 10 ; i++) {
			dp[1][i] = 1L;
		}
		
		for(int i = 1 ; i < 10 ; i++) {
			result += find(N, i);
		}
		
		System.out.println(result % MOD);
	}
	
	public static long find(int digit, int val) {
//		ù° �ڸ��� ��, ���� �ڸ��� ���� �� �ʱ�ȭ�� ���� ����
		if(digit == 1) {
			return dp[digit][val];
		}
//		Ž������ ���� ���
		if(dp[digit][val] == null) {
//			N��° �ڸ��� ���ڰ� 0�� ��� �� �� �ִ� ����� ���ڴ� 1�ۿ� ����
			if(val == 0) {
				dp[digit][val] = find(digit-1, 1);
//			N��° �ڸ��� ���ڰ� 9�� ��� �� �� �ִ� ����� ���ڴ� 8�ۿ� ����
			} else if(val == 9) {
				dp[digit][val] = find(digit-1, 8);
//			�� ���� ���� �ش� val ���� -1, +1�� �� �� ����
			} else {
				dp[digit][val] = find(digit-1, val-1) + find(digit-1, val+1);				
			}
		}
		
		return dp[digit][val] % MOD;
	}
}
