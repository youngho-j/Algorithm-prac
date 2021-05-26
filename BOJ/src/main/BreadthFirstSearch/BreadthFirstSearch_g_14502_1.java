package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreadthFirstSearch_g_14502_1 {
	//������ ũ�� - ��, �� 
	private static int N, M;
	
	//����
	private static int[][] map;
	
	//���̷��� ǥ�ð��� ����
	private static int[][] infectedMap;
	
	private static final int ZONE = 0; 
	private static final int WALL = 1; 
	private static final int VIRUS = 2; 
	
	// ���������� �ִ밪�� ���ϱ� ���� ����
	private static int safeZone = Integer.MIN_VALUE;
	// 0. ������ �Է¹���
	// 1. ���� �����(3������)
	// 1-1. ���� 3�� �� ������ ��� 2������ �̵�
	// 1-2. ���� 3�� �� ������ ���Ѱ�� �ٽ� 1������ �̵�
	// 2. �� �������� ���̷����� �۶߸���.
	// 2-1. ���̷����� �۶߸����� �����迭�� �����Ѵ�.
	// 2-2. ���̷��� ��ǥ�� ť������
	// 2-3. ���̷����z ��Ʈ��
	// 3. ���̷����� ���� �������� ���������� ī���� �Ѵ�
	// 4. ���������� �ִ�ũ�⸦ ����Ѵ�.
	
	
	public static void main(String[] args) throws IOException {
		// 0. �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		infectedMap = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. ���� �����.
		buildWall(0);
		
		// 4. ���������� �ִ� ũ�� ����Ѵ�. 
		System.out.println(safeZone);
	}
	// 1. ���� �����.
	public static void buildWall(int count) {
		// 1-1. ���� 3�� �� ������ ���
		if(count == 3) {
			spreadVirus();
			return;
		}
		// 1-2. ���� 3�� �� ������ ���Ѱ�� �ٽ� 1������ �̵�
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == ZONE) {
					map[i][j] = WALL;
					buildWall(count + 1);
					map[i][j] = ZONE;
				}
			}
		}
	}
	// 2. �� �������� ���̷����� �۶߸���.
	public static void spreadVirus() {
		Queue<Dot2> que = new LinkedList<Dot2>();
		int[] upDown = {-1,1,0,0};
		int[] leftRigth = {0,0,-1,1};
		// 2-1. ���̷����� �۶߸����� �����迭�� �����Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				infectedMap[i][j] = map[i][j];
			}
		}
		// 2-2. ���̷��� ��ǥ�� ť������
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(infectedMap[i][j] == 2) {
					que.add(new Dot2(i, j));
				}
			}
		}
		//2-3. ���̷����� ��Ʈ��
		while(!que.isEmpty()) {
			Dot2 dot2 = que.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int xx = dot2.x + upDown[i];
				int yy = dot2.y + leftRigth[i];
				if(xx >= 0 && yy >= 0 && xx < N && yy < M) {
					if(infectedMap[xx][yy] == 0) {
						que.add(new Dot2(xx, yy));
						infectedMap[xx][yy] = VIRUS;
					}
				}
			}
		}
		// 3. ���̷����� ���� �������� ���������� ī���� �Ѵ�
		countingSafeZone();
	}
	
	// 3. ���̷����� ���� �������� ���������� ī���� �Ѵ�
	public static void countingSafeZone() {
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(infectedMap[i][j] == 0) {
					count++;
				}
			}
		}
		safeZone = Math.max(count, safeZone);
	}
}

// ��ǥ ���� Ŭ����
class Dot2 {
	int x, y;
	
	public Dot2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}