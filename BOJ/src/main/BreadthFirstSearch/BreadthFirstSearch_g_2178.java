package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreadthFirstSearch_g_2178 {
	
	private static int N;
	private static int M;
	
	private static int[][] map;
	private static int[][] visited;
	
	private static int[] moveX = {-1, 1, 0, 0};
	private static int[] moveY = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		String str = "";
		for(int i = 0 ; i < N ; i++) {
			str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs();
		System.out.println(visited[N-1][M-1]);
	}
	
	public static void bfs() {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(0, 0));
		// 큐에 추가한 좌표 방문처리(조건에 출발과 도착 모두 카운팅하라는 조건이 있므로)
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Location location = queue.poll();
			int x = location.x;
			int y = location.y;
			
			//해당 좌표 기준 상하좌우로 이동가능한 곳 파악
			for(int i = 0 ; i < 4 ; i++) {
				int xx = x + moveX[i];
				int yy = y + moveY[i];
				
				// 이동이 가능한지 확인
				if(checkLocation(xx, yy)) {
					queue.add(new Location(xx, yy));
					//추가된 좌표의 거리 = 이전 좌표 + 1
					visited[xx][yy] = visited[x][y] + 1;
				}
			}
		}
	}


	public static boolean checkLocation(int x, int y) {
		// 해당 미로의 범위에서 벗어나지 않고,
		if(x >= 0 && y >= 0 && x < N && y < M) {
			// 방문한적이 없고, 이동가능한 좌표일 경우
			if(map[x][y] == 1 && visited[x][y] == 0) {
				return true;
			}
		}
		return false;
	}
}

//좌표를 저장하는 클래스
class Location {
	int x, y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
