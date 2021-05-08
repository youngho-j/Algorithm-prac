package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_12_11054_1 {
	
	static int N;
	
	static int[] arr;
	static int[] r_dp;
	static int[] l_dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		r_dp = new int[N];
		l_dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS();
		LDS();
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			if(r_dp[i] + l_dp[i] > max) {
				max = r_dp[i] + l_dp[i];
			}
		}
		System.out.println(max -1);
	}
	
	public static void LIS() {
		for(int i = 0 ; i < N ; i++) {
			r_dp[i] = 1;
			for(int j = 0 ; j < i ; j++) {
				if(arr[j] < arr[i] && r_dp[i] < r_dp[j] + 1) {
					r_dp[i] = r_dp[j] + 1;
				}
			}
		}
	}
	
	public static void LDS() {
		for(int i = N-1 ; i >= 0 ; i--) { 
			l_dp[i] = 1;
			for(int j = N-1; j > i ; j--) {
				if(arr[j] < arr[i] && l_dp[i] < l_dp[j] + 1) {
					l_dp[i] = l_dp[j] + 1;
				}
			}
		}
	}
}
