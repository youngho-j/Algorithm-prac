package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_7_2579 {
	static int[] stair;
	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stair = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			stair[i] = Integer.parseInt(br.readLine());
			dp[i] = -1;
		}
		dp[0] = stair[0];
		dp[1] = stair[1];
		
		// N�� 2�� ���ų� ū ��� 2���� ���� �ִ� ��
	    // �ش� ������ ���� �� N = 2�� �Ǹ� stairPoint(-1)�� �ǹǷ� ����
		if(N >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		
		System.out.println(stairPoint(N));
	}
	public static int stairPoint(int N) {
		if(dp[N] == -1) {
			// N�� �����ϱ� ���� ����� N-3 -> N-1 -> N / N-2 -> N �ΰ��� ����� �����ϰ�,
			// N-3 -> N-1 -> N ��ο��� N-1 -> N���� ���� ����� �Ѱ��� �̹Ƿ� �迭���� �״�� �����´�. 
			dp[N] = Math.max(stairPoint(N-2), stairPoint(N-3) + stair[N-1]) + stair[N];
		}
		return dp[N];
	}
}
