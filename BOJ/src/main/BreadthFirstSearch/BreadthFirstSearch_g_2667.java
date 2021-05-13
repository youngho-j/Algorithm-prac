package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch_g_2667 {
	// 배열 크기, 단지내 세대수
	private static int N;
	private static int cnt;
	// 지도로 사용할 배열, 방문 여부 체크용 배열
	private static int[][] map;
	private static boolean[][] visited;

	// 상하 이동 배열, 좌우 이동 배열
	private static int[] topBottom = { -1, 1, 0, 0 };
	private static int[] rightLeft = { 0, 0, -1, 1 };

	// 단지 수, 단지 내 세대 수 출력을 위한 배열
	private static List<Integer> count;

	// 단지를 찾아내기 위한 배열
	private static Queue<Point> q = new LinkedList<Point>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		// 주의할 점은 띄어 쓰기가 없으모로, charAt 메소드 사용 후 -'0'을 통해 int형으로 형변환
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		// 초기화
		cnt = 0;

		count = new ArrayList<Integer>();

		// 전체 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// map 배열의 값이 1이고, 방문하지 않았을 경우 즉, visited 배열의 값이 true일 경우(! 사용하여 false가 true) 
				if (map[i][j] == 1 && !visited[i][j]) {
					// 단지의 첫 시작이므로 +1 후 탐색
					cnt = 1;
					visited[i][j] = true;
					bfs(i, j);
					count.add(cnt);
				}
			}
		}

		Collections.sort(count);
		sb.append(count.size()).append("\n");
		for (int i : count) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	// 해당 세대의 상하좌우 탐색
	public static void bfs(int x, int y) {
		// 해당값을 queue에 저장
		q.offer(new Point(x, y));
		
		// 값이 존재하지 않므면 while 탈출
		while (!q.isEmpty()) {
			// queue에 저장된 값을 꺼내옴, poll 메서드는 값이 없으면 null 반환
			Point curr = q.poll();

			int xx = curr.x;
			int yy = curr.y;

			for (int i = 0; i < 4; i++) {
				int CalX = xx + topBottom[i];
				int CalY = yy + rightLeft[i];

				// 다음 방문 위치가 범위 안이고, 미방문 상태이며 아파트일 때만 탐색
				if (CalX >= 0 && CalY >= 0 && CalX < N && CalY < N) {
					if (!visited[CalX][CalY] && map[CalX][CalY] == 1) {
						q.offer(new Point(CalX, CalY));
						visited[CalX][CalY] = true;
						cnt++;
					}
				}
			}
		}
	}

	// 좌표 입력을 위한 클래스
	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
