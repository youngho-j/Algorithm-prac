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
	// �迭 ũ��, ������ �����
	private static int N;
	private static int cnt;
	// ������ ����� �迭, �湮 ���� üũ�� �迭
	private static int[][] map;
	private static boolean[][] visited;

	// ���� �̵� �迭, �¿� �̵� �迭
	private static int[] topBottom = { -1, 1, 0, 0 };
	private static int[] rightLeft = { 0, 0, -1, 1 };

	// ���� ��, ���� �� ���� �� ����� ���� �迭
	private static List<Integer> count;

	// ������ ã�Ƴ��� ���� �迭
	private static Queue<Point> q = new LinkedList<Point>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		// ������ ���� ��� ���Ⱑ �������, charAt �޼ҵ� ��� �� -'0'�� ���� int������ ����ȯ
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		// �ʱ�ȭ
		cnt = 0;

		count = new ArrayList<Integer>();

		// ��ü Ž��
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// map �迭�� ���� 1�̰�, �湮���� �ʾ��� ��� ��, visited �迭�� ���� true�� ���(! ����Ͽ� false�� true) 
				if (map[i][j] == 1 && !visited[i][j]) {
					// ������ ù �����̹Ƿ� +1 �� Ž��
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

	// �ش� ������ �����¿� Ž��
	public static void bfs(int x, int y) {
		// �ش簪�� queue�� ����
		q.offer(new Point(x, y));
		
		// ���� �������� �ʹǸ� while Ż��
		while (!q.isEmpty()) {
			// queue�� ����� ���� ������, poll �޼���� ���� ������ null ��ȯ
			Point curr = q.poll();

			int xx = curr.x;
			int yy = curr.y;

			for (int i = 0; i < 4; i++) {
				int CalX = xx + topBottom[i];
				int CalY = yy + rightLeft[i];

				// ���� �湮 ��ġ�� ���� ���̰�, �̹湮 �����̸� ����Ʈ�� ���� Ž��
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

	// ��ǥ �Է��� ���� Ŭ����
	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
