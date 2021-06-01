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
		
		//A 전봇대 기준 정렬 - 비교하기 편하도록
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
	// 전선 매칭 
	public static int matching(int N) {
		// 탐색하지 않은 경우
		if(dp[N] == null) {
			// 최소일 경우 본인이 연결된 줄만 있으므로 1로 초기화 
			dp[N] = 1;
			// A 전봇대의 N번째 전선과 이후 전봇대 전선 비교
			for(int i = N + 1 ; i < dp.length ; i++) {
				// B 전봇대의 N번째 전선 보다 B 전봇대의 i번째 전선이 클 경우 겹치지 않으므로 전선 설치 가능 
				if(wire[N][1] < wire[i][1]) {
					// 연결 가능한 전선의 수 중 가장 큰 값을 저장
					dp[N] = Math.max(dp[N], matching(i) + 1);
				}
			}
		}
		return dp[N];
	}
}
