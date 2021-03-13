package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_7_retry {
	/*
		N = ����� ���� 
		stair = ����� ������ ��� �迭
		dp = �޸������̼� �迭 
	*/
	static int N;
	static int[] stair;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stair = new int[N+1];
		dp = new int[N+1];
//		���� ����� 0��° �迭�� ����, �迭 stair���� ����� ����, �迭 dp�� -1�� �ʱ�ȭ 
		for(int i = 1 ; i <= N ; i++) {
			stair[i] = Integer.parseInt(br.readLine());
			dp[i] = -1;
		}
		
		dp[0] = stair[0];
		dp[1] = stair[1];
		
		/*
		 * �ݺ��Ǵ� ������ 
		 * 1. N-2���� N���� ���� ��� 
		 * 2. N-3���� N-1�� ���� N���� ���� ���  
		 * �� ���� �̹Ƿ� N=2 �� ��� 
		 * -1�� �迭 �ε����� ���� ���Ե�
		 */	
		if(N >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		System.out.println(find(N));
	}
	static int find(int N) {
//		�湮 ���� �ʾ��� ���
		if(dp[N] == -1) {
			dp[N] = Math.max(find(N-2), find(N-3) + stair[N-1]) + stair[N];
		}
		return dp[N];
	}
}
