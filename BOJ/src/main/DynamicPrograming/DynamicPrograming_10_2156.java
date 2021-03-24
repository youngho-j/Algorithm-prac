package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DynamicPrograming_10_2156 {
	
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1 ; i < N + 1 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = -1;
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
//		N = 2 �ΰ�� �ִ밪�� arr[1] + arr[2]; ��, ���� ��� ������
		if(N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		
		System.out.println(find(N));
	}
	
	static int find(int N) {
//		�� ���� ���� N��° �� + N-2��° �� / N��° �� + N-1��° �� + N-3��° �� / N-1 ��° ��
		if(dp[N] == -1) {
			dp[N] = Math.max(Math.max(find(N-2), find(N-3) + arr[N-1]) + arr[N], find(N-1));
		}
		return dp[N];
	}
}
