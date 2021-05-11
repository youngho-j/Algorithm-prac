package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BreadthFirstSearch_g_2667 {
	// �迭 ũ��, ������ �����
	private static int N;
	private static int cnt;
	// ������ ����� �迭, �湮 ���� üũ�� �迭
	private static int[][] map;
	private static boolean[][] visited;
	
	// ���� �̵� �迭, �¿� �̵� �迭
	private static int[] topBottom = {-1, 1, 0, 0};
	private static int[] rightLeft = {0, 0, -1, 1};
	
	// ���� ��, ���� �� ���� �� ����� ���� �迭
	private static List<Integer> count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		// ������ ���� ��� ���Ⱑ �������, charAt �޼ҵ� ��� �� -'0'�� ���� int������ ����ȯ
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		cnt = 0;
		
		count = new ArrayList<Integer>();
		
		// ��ü Ž��
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				// map �迭�� ���� 1�̰�, visited �迭�� ���� true�� ���(! ����Ͽ� false�� true) 
				if(map[i][j] == 1 && !visited[i][j]) {
					// ������ ù �����̹Ƿ� +1 �� Ž��
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
	// �ش� ������ �����¿� Ž��
	public static void bfs(int x, int y) {
		// �湮�� �ش� ���� false���� true�� ����, ���ǿ��� �ɷ����Ե�
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int calX = x + topBottom[i];
			int calY = y + rightLeft[i];
			// map �����ȿ��� 
			if(calX >= 0 && calY >= 0 && calX < N && calY < N) {
				if(map[calX][calY] == 1 && !visited[calX][calY]) {
					bfs(calX, calY);
					cnt++;
				}
			}
		}
	}
}
