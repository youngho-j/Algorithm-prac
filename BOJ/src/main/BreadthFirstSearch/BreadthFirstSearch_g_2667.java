package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BreadthFirstSearch_g_2667 {
	
	private static int N;
	private static int cnt;
	
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int[] topBottom = {-1, 0, 1, 0};
	private static int[] rightLeft = {0, 1, 0, -1};
	
	private static List<Integer> count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = temp.charAt(i)-'0';
			}
		}
		
		cnt = 0;
		
		count = new ArrayList<Integer>();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1) {
					cnt = 1;
					bfs(i, j);
					count.add(cnt);
				}
			}
		}
		
		Collections.sort(count);
		sb.append(count.size()).append("\n");
		for(int i : count) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int calX = x + topBottom[i];
			int calY = x + rightLeft[i];
			// map 범위안에서 
			if(calX >= 0 && calY >= 0 && calX < N && calY < N) {
				if(map[calX][calY] == 1 && !visited[calX][calY]) {
					bfs(calX, calY);
					cnt++;
				}
			}
		}
	}
}
