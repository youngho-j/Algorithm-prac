package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_11_11053 {
	
	static int n;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 현재 원소를 이전원소와 비교하여 수열 길이 찾기
		for(int i = 0 ; i < n ; i++) {
			dp[i] = 1;
			// 이전 원소 탐색
			for(int j = 0 ; j < i ; j++) {
				// 배열의 j번째 원소(i원소보다 이전)가 i번째 원소(현재 원소) 보다 작고
				// i번째 dp(현재 원소)가 j번째 dp+1 값보다 작은 경우 
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j]  + 1;
				}
			}
		}
		
		//최대값 구하기
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < dp.length ; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
