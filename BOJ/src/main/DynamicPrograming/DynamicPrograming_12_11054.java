package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_12_11054 {
	
	private static int N;
	private static int[] arr;
	private static int[] dp;
	private static int[] rDp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		rDp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//LIS
		for(int i = 0 ; i < N ; i++) {
			dp[i] = 1;
			for(int j = 0 ; j < i ; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		//LDS
		for(int i = N-1 ; i >= 0 ; i--) {
			rDp[i] = 1;
			for(int j = N-1 ; j > i ; j--) {
				if(arr[j] < arr[i] && rDp[i] < rDp[j] + 1) {
					rDp[i] = rDp[j] + 1;
				}
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			if(max < dp[i] + rDp[i]) {
				max = dp[i] + rDp[i];
			}
		}
		//원소가 하나씩 중복되므로 
		System.out.println(max -1);
	}
}
