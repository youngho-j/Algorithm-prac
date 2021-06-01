package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DynamicPrograming_13_2565 {
	
	private static int N;
	
	private static int max = Integer.MIN_VALUE;
	
	private static int[][] wire;
	private static Integer[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		wire = new int[N][2];
		dp = new Integer[N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//A ������ ���� ���� - ���ϱ� ���ϵ���
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(matching(i), max);
		}
		
		System.out.println(N - max);
	}
	// ���� ��Ī 
	public static int matching(int N) {
		// Ž������ ���� ���
		if(dp[N] == null) {
			// �ּ��� ��� ������ ����� �ٸ� �����Ƿ� 1�� �ʱ�ȭ 
			dp[N] = 1;
			// A �������� N��° ������ ���� ������ ���� ��
			for(int i = N + 1 ; i < dp.length ; i++) {
				// B �������� N��° ���� ���� B �������� i��° ������ Ŭ ��� ��ġ�� �����Ƿ� ���� ��ġ ���� 
				if(wire[N][1] < wire[i][1]) {
					// ���� ������ ������ �� �� ���� ū ���� ����
					dp[N] = Math.max(dp[N], matching(i) + 1);
				}
			}
		}
		return dp[N];
	}
}
