package main.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepthFirstSearch_g_2667 {

	private static int N, count;

	private static int[][] map;
	private static boolean[][] visited;

	private static int[] moveUD = { -1, 1, 0, 0 };
	private static int[] moveLR = { 0, 0, -1, 1 };
	private static List<Integer> apt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		count = 0;
		apt = new ArrayList<Integer>();
		// ±íÀÌ ¿ì¼± Å½»ö
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[j][i] == 1 && !visited[j][i]) {
					count = 1;
					dfs(j, i);
					apt.add(count);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		Collections.sort(apt);
		sb.append(apt.size()).append("\n");
		for (int i : apt) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < moveLR.length; i++) {
			int CalX = x + moveUD[i];
			int CalY = y + moveLR[i];

			if (CalX >= 0 && CalY >= 0 && CalX < N & CalY < N) {
				if (map[CalX][CalY] == 1 && !visited[CalX][CalY]) {
					dfs(CalX, CalY);
					count++;
				}
			}
		}
	}
}
