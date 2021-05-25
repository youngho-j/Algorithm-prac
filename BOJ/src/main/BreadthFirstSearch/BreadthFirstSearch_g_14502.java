package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreadthFirstSearch_g_14502 {
	private static int N, M;
	
	private static int[][] map;
	private static int[][] virusMap;
	
	private static int[] upDown = {-1, 1, 0, 0};
	private static int[] leftRight = {0, 0, -1, 1};
	
	private static int safeZone = Integer.MIN_VALUE;
	
	
	private static final int ZONE = 0;
	private static final int WALL = 1;
	private static final int VIRUS = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		virusMap = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		buildWall(0);
		
		System.out.println(safeZone);
	}
	// �� �����
	public static void buildWall(int depth) {
		if(depth == 3) {
			infect();
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == ZONE) {
					map[i][j] = WALL;
					buildWall(depth + 1);
					map[i][j] = ZONE;
				}
			}
		}
	}
	// ���̷����� ���� ���� �����
	public static void infect() {
		Queue<Dot1> que = new LinkedList<Dot1>();
		// 3���� ���� �߰��� ������ ����
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				virusMap[i][j] = map[i][j];
			}
		}
		//���̷����� ť�� �ֱ�(�����߻� �������� Ž��)
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(virusMap[i][j] == VIRUS) {
					que.add(new Dot1(i, j));
				}
			}
		}
		while(!que.isEmpty()) {
			Dot1 dot1 = que.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int xx = dot1.x + upDown[i];
				int yy = dot1.y + leftRight[i];
				// ���� �������� �����ϰ� ������ϰ�� ���̷����� ����
				if(xx >= 0 && yy >= 0 && xx < N && yy < M) {
					if(virusMap[xx][yy] == ZONE) {
						que.add(new Dot1(xx, yy));
						virusMap[xx][yy] = VIRUS;
					}
				}
			}
		}
		safeCounting(virusMap);
	}
	// �������� ī����
	public static void safeCounting(int[][] arr) {
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(arr[i][j] == 0) {
					count++;
				}
			}
		}
		safeZone = Math.max(count, safeZone);
	}
}

// ��ǥ ���� Ŭ����
class Dot1 {
	int x, y;

	public Dot1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
