package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class DynamicPrograming_13_2565_1 {
	/*
		1. 입력
		2. 전봇대 a 기준 정렬
		3. 연결 가능 전봇대 찾기(재귀)
		4. 출력
	*/
	
	private static int N;
	private static int max = Integer.MIN_VALUE;
	
	private static int[][] wire;
	private static Integer[] count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		wire = new int[N][N];
		count = new Integer[N];
		
		StringTokenizer st;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(max, recur(i));
		}
		System.out.println(N - max);
	}
	
	public static int recur(int N) {
		if(count[N] == null) {
			// 해당 좌표(N,0 / N,1)의 줄만 연결하고 다음줄들을 연결 못하는 경우가 최소 연결 값이므로 1로 초기화
			count[N] = 1;
			for(int i = N + 1 ; i < count.length ; i++) {
				if(wire[N][1] < wire[i][1]) {
					//  해당 좌표(N,0 / N,1)의 줄만 연결된 경우와 해당 좌표의 줄 + 다음 좌표가 연결될 수 있는 경우의 수를 비교
					count[N] = Math.max(count[N], recur(i) + 1);
				}
			}
		}
		return count[N];
	}
}
