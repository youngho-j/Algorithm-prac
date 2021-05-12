 package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BreadthFirstSearch_g_2667_1 {
	
	private static int N, count;
	
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int[] moveUD = {-1, 1, 0, 0};
	private static int[] moveLR = {0, 0, -1, 1};
	private static List<Integer> apt;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		count = 0;
		apt = new ArrayList<Integer>();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					count = 1;
					bfs(i, j);
					apt.add(count);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(apt);
		sb.append(apt.size()).append("\n");
		for(int i : apt) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0 ; i < moveLR.length ; i++) {
			int CalX = x + moveUD[i];
			int CalY = y + moveLR[i];
			
			if(CalX >= 0 && CalY >= 0 && CalX < N & CalY < N) {
				if(map[CalX][CalY] == 1 && !visited[CalX][CalY]) {
					bfs(CalX, CalY);
					count++;
				}
			}
		}
	}
}
