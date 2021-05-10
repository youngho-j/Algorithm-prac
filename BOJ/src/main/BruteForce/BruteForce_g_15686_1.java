package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BruteForce_g_15686_1 {
	
	private static int N, M, result = Integer.MAX_VALUE;
	
	private static int[][] map;
	
	private static List<Point> house;
	
	private static List<Point> chicken;
	
	private static List<Point> selectedChicken;
	
	private static boolean[] open;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		house = new ArrayList<Point>();
		chicken = new ArrayList<Point>();
		selectedChicken = new ArrayList<Point>();
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new Point(i, j));
				} else if(map[i][j] == 2) {
					chicken.add(new Point(i, j));					
				}
			}
		}
		br.close();
		open = new boolean[chicken.size()];
		
		dfs(0, 0);
		
		System.out.println(result);
	}
	// 좌표 관리해줄 클래스
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// 거리 계산 메소드
	public static int getDis(int h1, int c1, int h2, int c2) {
		return Math.abs(h1 - c1) + Math.abs(h2 - c2);
	}
	
	public static void dfs(int start, int pick) {
		if(pick == M) {
			int sum = 0;
			for(int i = 0 ; i < house.size() ; i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0 ; j < selectedChicken.size() ; j++) {
					int dis = getDis(house.get(i).x, selectedChicken.get(j).x, house.get(i).y, selectedChicken.get(j).y);
					if(min > dis) {
						min = dis;
					}
				}
				sum += min;
			}
			if(result > sum) {
				result = sum;
			}
		} else {
			for(int i = start ; i < chicken.size() ; i++) {
				if(!open[i]) {
					open[i] = true;
					selectedChicken.add(chicken.get(i));
					dfs(i+1, pick + 1);
					selectedChicken.remove(selectedChicken.size() - 1);					
					open[i] = false;
				}
			}
		}
	}
}

