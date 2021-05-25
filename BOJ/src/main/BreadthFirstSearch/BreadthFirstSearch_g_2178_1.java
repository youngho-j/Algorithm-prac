package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreadthFirstSearch_g_2178_1 {
	//����, ����
	private static int N, M;
	//�̷θ� ��Ÿ���� �迭
	private static int[][] map;
	//�������� �̵� �Ÿ��� �����ϴ� �迭
	private static int[][] route;
	
	//������ ��ǥ���� �����¿� �̵��� ���� �迭
	private static int[] upDown = {-1, 1, 0, 0};
	private static int[] leftRight = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		route = new int[N][M];
		String str = "";
		
		for(int i = 0 ; i < N ; i++) {
			str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(route[N-1][M-1]);
	}
	
	public static void bfs() {
		Queue<Dot> que = new LinkedList<Dot>();
		que.add(new Dot(0, 0));
		route[0][0] = 1;
		// ť�� ���̻� ���� �������� ���� �� ����
		while(!que.isEmpty()) {
			Dot dot = que.poll();
			int x = dot.x;
			int y = dot.y;
			for(int i = 0 ; i < 4 ; i++) {
				int xx = x + upDown[i];
				int yy = y + leftRight[i];
				if(checkDot(xx, yy)) {
					que.add(new Dot(xx, yy));
					route[xx][yy] = route[x][y] + 1;
				}
			}
		}
	}
	
	// ������ ���� ������ �̵��� �� �ִ� ĭ���� Ȯ�� 
	public static boolean checkDot(int x, int y) {
		if(x >= 0 && y >= 0 && x < N && y < M) {
			if(map[x][y] == 1 && route[x][y] == 0) {
				return true;
			}
		}
		return false;
	}
}

// ��ǥ ���� Ŭ����
class Dot {
	int x, y;

	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}
