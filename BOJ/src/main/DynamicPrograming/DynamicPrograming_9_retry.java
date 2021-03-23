package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_9_retry {
	
	static final long MOD = 1000000000;
	static Long[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long result = 0L;
		int n = Integer.parseInt(br.readLine());
		
		arr = new Long[n+1][10];
		
		for(int i = 0 ; i < 10 ; i++) {
			arr[1][i] = 1L;
		}
		
		for(int i = 1 ; i <= 9 ; i++) {
			result += find(n, i);
		}
		
		System.out.println(result % MOD);
	}
	
	public static long find(int digit, int val) {
		if(digit == 1) {
			return arr[digit][val] % MOD;
		}
		if(arr[digit][val] == null) {
			if(val == 0) {
				arr[digit][val] = find(digit-1, 1);
			} else if (val == 9) {
				arr[digit][val] = find(digit-1, 8);				
			} else {
				arr[digit][val] = find(digit-1, val-1) + find(digit-1, val+1);				
			}
		}
		return arr[digit][val] % MOD;
	}
}
