package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BruteForce_g_15686 {
	// 지도 크기, 수익 극대화 치킨집 수, 가장 작은 치킨 거리 값 
	private static int N, M, minimum = Integer.MAX_VALUE;
	
	// 지도 
	private static int[][] map;
	
	// 선정된 치킨집을 확인할 배열
	private static boolean[] check;
	
	// 지도에 표시된 집과 치킨집들을 담아줄 배열
	private static ArrayList<Location> home = new ArrayList<>();
	private static ArrayList<Location> chicken = new ArrayList<>();
	
	// 선정된 치킨집을 담을 배열
	private static ArrayList<Location> selectedChicken = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new Location(i, j));
				} else if(map[i][j] == 2) {
					chicken.add(new Location(i, j));					
				}
			}
		}
		//지도에 생성된 치킨집 만큼 배열 크기 지정
		check = new boolean[chicken.size()];
		
		dfs(0, 0);
		
		System.out.println(minimum);
	}
	
	private static void dfs(int start, int pick) {
		if(pick == M) {
			// 최소거리 계산
			int sum = 0;
			for(int i = 0 ; i < home.size() ; i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0 ; j < selectedChicken.size() ; j++) {
					int distance = Math.abs(home.get(i).x - selectedChicken.get(j).x) + Math.abs(home.get(i).y - selectedChicken.get(j).y);
					if(min > distance) {
						min = distance;
					}
				}
				// 선택된 치킨집들의 최소거리의 합
				sum += min;
			}
			if(sum < minimum) {
				minimum = sum;
			}
		} else {
			// M 만큼 선택되지 않았을 경우(더 선택되어야 하는 경우)
			// 지도 상 나와 있는 치킨집들을 모두 돌면서
			for(int i = start ; i < chicken.size() ; i++) {
				// 선택되지 않았을 경우
				if(!check[i]) {
					// 해당 치킨집을 선택한 뒤 
					check[i] = true;
					// 선택된 치킨집을 배열에 담음
					selectedChicken.add(chicken.get(i));
					dfs(i+1, pick + 1);
					selectedChicken.remove(selectedChicken.size()-1);
					check[i] = false;
				}
			}
		}
	}
	// 좌표를 담아주기 위한 클래스
	public static class Location {
		//좌표
		int x, y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
