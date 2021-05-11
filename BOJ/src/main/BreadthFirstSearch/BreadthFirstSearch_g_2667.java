package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BreadthFirstSearch_g_2667 {
	// 배열 크기, 단지내 세대수
	private static int N;
	private static int cnt;
	// 지도로 사용할 배열, 방문 여부 체크용 배열
	private static int[][] map;
	private static boolean[][] visited;
	
	// 상하 이동 배열, 좌우 이동 배열
	private static int[] topBottom = {-1, 1, 0, 0};
	private static int[] rightLeft = {0, 0, -1, 1};
	
	// 단지 수, 단지 내 세대 수 출력을 위한 배열
	private static List<Integer> count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		// 주의할 점은 띄어 쓰기가 없으모로, charAt 메소드 사용 후 -'0'을 통해 int형으로 형변환
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		cnt = 0;
		
		count = new ArrayList<Integer>();
		
		// 전체 탐색
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				// map 배열의 값이 1이고, visited 배열의 값이 true일 경우(! 사용하여 false가 true) 
				if(map[i][j] == 1 && !visited[i][j]) {
					// 단지의 첫 시작이므로 +1 후 탐색
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
	// 해당 세대의 상하좌우 탐색
	public static void bfs(int x, int y) {
		// 방문시 해당 값을 false에서 true로 변경, 조건에서 걸러지게됨
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int calX = x + topBottom[i];
			int calY = y + rightLeft[i];
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
