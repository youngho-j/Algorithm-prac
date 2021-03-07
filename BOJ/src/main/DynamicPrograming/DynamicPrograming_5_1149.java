package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_5_1149 {
	static int[][] painting;
	
	static int[][] memo;
	
	final static int RED = 0;
	final static int GREEN = 1;
	final static int BLUE = 2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		painting = new int[N][3];
		memo = new int[N][3];
		
//		1번집이 배열의 0번
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			painting[i][RED] = Integer.parseInt(st.nextToken());
			painting[i][GREEN] = Integer.parseInt(st.nextToken());
			painting[i][BLUE] = Integer.parseInt(st.nextToken());
		}
		
		setMemo();
//		가장 작은 값을 출력, 1번집이 0번이므로 -1해서 배열범위안에 위치하도록함
		System.out.println(Math.min(estimate(N-1, RED), Math.min(estimate(N-1, GREEN), estimate(N-1, BLUE))));
	}
	public static int estimate(int N, int color) {
		if(memo[N][color] == 0) {
			if(color == RED) {
				memo[N][RED] = Math.min(estimate(N-1, GREEN), estimate(N-1, BLUE)) + painting[N][RED];				
			} else if(color == GREEN){
				memo[N][GREEN] = Math.min(estimate(N-1, RED), estimate(N-1, BLUE)) + painting[N][GREEN];				
			} else {
				memo[N][BLUE] = Math.min(estimate(N-1, RED), estimate(N-1, GREEN)) + painting[N][BLUE];				
			}
		}
		return memo[N][color];
	}
	
	public static void setMemo(){
		memo[0][RED] = painting[0][RED];
		memo[0][GREEN] = painting[0][GREEN];
		memo[0][BLUE] = painting[0][BLUE];
	}
}
