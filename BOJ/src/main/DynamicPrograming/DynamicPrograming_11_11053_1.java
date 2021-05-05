package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_11_11053_1 {
	
	private static int N;
	
	private static int maxLength = Integer.MIN_VALUE;
	
	private static int[] arr;
	private static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			dp[i] = 1;
			for(int j = 0 ; j < i ; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j]  + 1;
				}
			}
			if(dp[i] > maxLength) {
				maxLength = dp[i];
			}
		}
		System.out.println(maxLength);
	}
}
