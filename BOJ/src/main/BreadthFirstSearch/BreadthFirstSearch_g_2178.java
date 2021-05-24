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
		// ť�� �߰��� ��ǥ �湮ó��(���ǿ� ��߰� ���� ��� ī�����϶�� ������ �ֹǷ�)
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Location location = queue.poll();
			int x = location.x;
			int y = location.y;
			
			//�ش� ��ǥ ���� �����¿�� �̵������� �� �ľ�
			for(int i = 0 ; i < 4 ; i++) {
				int xx = x + moveX[i];
				int yy = y + moveY[i];
				
				// �̵��� �������� Ȯ��
				if(checkLocation(xx, yy)) {
					queue.add(new Location(xx, yy));
					//�߰��� ��ǥ�� �Ÿ� = ���� ��ǥ + 1
					visited[xx][yy] = visited[x][y] + 1;
				}
			}
		}
	}


	public static boolean checkLocation(int x, int y) {
		// �ش� �̷��� �������� ����� �ʰ�,
		if(x >= 0 && y >= 0 && x < N && y < M) {
			// �湮������ ����, �̵������� ��ǥ�� ���
			if(map[x][y] == 1 && visited[x][y] == 0) {
				return true;
			}
		}
		return false;
	}
}

//��ǥ�� �����ϴ� Ŭ����
class Location {
	int x, y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
