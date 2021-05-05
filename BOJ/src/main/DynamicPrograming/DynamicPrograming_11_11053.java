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
		
		// ���� ���Ҹ� �������ҿ� ���Ͽ� ���� ���� ã��
		for(int i = 0 ; i < n ; i++) {
			dp[i] = 1;
			// ���� ���� Ž��
			for(int j = 0 ; j < i ; j++) {
				// �迭�� j��° ����(i���Һ��� ����)�� i��° ����(���� ����) ���� �۰�
				// i��° dp(���� ����)�� j��° dp+1 ������ ���� ��� 
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j]  + 1;
				}
			}
		}
		
		//�ִ밪 ���ϱ�
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < dp.length ; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
