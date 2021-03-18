package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_7_retry2 {
	static int[] point;
	static int[] sum;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		point = new int[N+1];
		sum = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			point[i] = Integer.parseInt(br.readLine());
			sum[i] = -1;
		}
		
		point[0] = 0;
		sum[0] = point[0];
		sum[1] = point[1];
		if(N >= 2) {
			sum[2] = point[1] + point[2];
		}
		System.out.println(find(N));
	}
	
	static int find(int N) {
		if(sum[N] == -1) {
			sum[N] = Math.max(find(N-2),find(N-3) + point[N-1]) + point[N];			
		}
		return sum[N];
	}
}
