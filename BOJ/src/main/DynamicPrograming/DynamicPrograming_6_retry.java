package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_6_retry {
	static int[][] arr;
	static int[][] total;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		total = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j <= i ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				total[i][j] = -1;
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			total[N-1][i] = arr[N-1][i];
		}
		
		System.out.println(path(0, 0));
	}
	public static int path(int x, int y) {
		if(x == N-1) {
			return total[x][y];
		}
		if(total[x][y] == -1) {
			total[x][y] =Math.max(path(x+1, y), path(x+1, y+1)) + arr[x][y];
		}
		return total[x][y];
	}
}
