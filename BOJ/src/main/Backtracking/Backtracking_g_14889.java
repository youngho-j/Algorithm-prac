package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_14889 {
	
	static int N;
	
	static int[][] team;
	
	static boolean[] check;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		team = new int[N][N];
		check = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		back(0, 0);
		System.out.println(min);
	}
	
	static void back(int pick, int index) {
		if(pick == N/2) {
			calcMin();
			return;
		}
		for(int i = index ; i < check.length ; i++) {
			if(!check[i]) {
				check[i] = true;
				back(pick + 1, i+1);
				check[i] = false;
			}
		}
	}
	
	static void calcMin() {
		int start = 0;
		int link = 0;
		int diff = 0;
		for(int i = 0 ; i < N-1 ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				if(check[i] == true && check[j] == true) {
					start += (team[i][j] + team[j][i]);
				} else if(check[i] == false && check[j] == false) {
					link += (team[i][j] + team[j][i]);
				}
			}
		}
		diff = Math.abs(start - link); 
		if(diff == 0) {
			min = diff;
			System.out.println(min);
			System.exit(0);
		}
		
		min = Math.min(min, diff);
		
	}
}
