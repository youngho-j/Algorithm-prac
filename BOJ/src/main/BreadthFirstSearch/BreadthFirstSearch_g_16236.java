package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreadthFirstSearch_g_16236 {
	
	private static int N;
	
	private static int[][] sea;
	
	private static boolean[][] visited;
	
	private static Fish babyShark;
	private static int size = 2;
	private static int eaten = 0;
	
	private static int answer;
	private static ArrayList<Fish> feed = new ArrayList<Fish>();
	
	private static int[] upDown = {-1, 1, 0, 0};
	private static int[] leftRight = {0, 0, -1, 1};
	
	private static final int ZONE = 0;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. N = ������ ũ�� (2 <= N <= 20)
		 * 2. ������ ũ�� N,N (��ĭ���� �ִ� 1������ ����� ����)
		 * 3. ���, ������� ũ��� ��� �ڿ���
		 * 
		 * 4. ���� ǥ�� ����
		 * 4-1. ��� 
		 * 		��ġ - ���� 9�� ǥ��
		 * 		ũ�� - ó�� ũ��� 2
		 * 4-2. �����
		 * 		ũ�� - 1 ~ 6 ĭ�� �ִ� ������� ũ��
		 * 4-3. ��ĭ - 0���� ǥ��
		 * 
		 * 5. �̵� 
		 * 5-1. �Ʊ� ��� �ڽź��� ū ����Ⱑ �ִ� ĭ�� ���� �� ����
		 * 		(ó�� �Ʊ����� ũ��� 2 �̹Ƿ�, 3�̻��� ���� �� ����)
		 * 5-2. �Ʊ� ��� �ڽŰ� ���� ũ���� ����� ���� �� ������, ���������� ����
		 * 		(ó�� �Ʊ����� ũ��� 2 �̹Ƿ�, 2 ũ���� ����� ĭ���� �̵��� ����)
		 * 5-3. �ڽ��� ũ�⺸�� ���� ����⸸ ���� �� ����
		 * 		(ó�� ���ͻ���� ũ��� 2 �̹Ƿ�, 1 ũ���� ����⸸ ���� �� ����)
		 * 
		 * 6. ũ�� ���� ���� - �� ���� ����� �� == ����� ũ�� �ΰ�� ũ��++;
		 * 
		 * 7. ����� �Դ� ����
		 * 7-1. ���� �̵��Ÿ��� ª�� ����⸦ �Դ´�. 
		 * 		(����� ��ǥ���� ���� �̵��Ÿ��� ª�ƾ���)
		 * 7-2. �̵��Ÿ��� ���� ��� ���� ���ʿ� �ִ� �����, ���� ���ʿ� �ִ� ����Ⱑ ���������� ��� ���� ���ʿ� �ִ� ����⸦ ����
		 * 		(�� 1,1 ��ǥ�� �����ϰ� ũ�Ⱑ 1�� ����Ⱑ 0,0 / 0,2�� ����� 0,0 ����� ���� ����)
		 * 
		 * 8. ����⸦ ������ ��ĭ�� �ǰ�, ���� ���� ����� ��ġ�� �̵�
		 * 
		 * 9. ���� �� �ִ� ����Ⱑ ������ �ߴ�
		 * 
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		sea = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				
				if(sea[i][j] == 9) {
					babyShark = new Fish(i, j, 0);
					sea[i][j] = 0;
				}
			}
		}
		
		growShark();
		
		System.out.println(answer);
	}
	
	public static void growShark() {
		// �̵��� ���� �迭
		Queue<Fish> que = new LinkedList<Fish>();
		// ��� ��ġ, �̵��ð� �߰�
		que.add(babyShark);
		visited[babyShark.x][babyShark.y] = true;
		// �ݺ�
		while(true) {
			while(!que.isEmpty()) {
				Fish fish = que.poll();
				int time  = fish.time;
				
				for(int i = 0 ; i < 4 ; i++) {
					int xx = fish.x + upDown[i];
					int yy = fish.y + leftRight[i];
					// ���� �ȿ� �����ϰ�, �̵� �� �� �ִ� ���(false ��, �湮 �ϱ����ΰ��)
					if((xx >= 0 && yy >= 0 && xx < N && yy < N) && !visited[xx][yy]) {
						//���� �� �ִ� ���
						if(sea[xx][yy] < size && sea[xx][yy] != 0) {
							que.add(new Fish(xx, yy, time + 1));
							visited[xx][yy] = true;
							// ���� �迭�� �߰�
							feed.add(new Fish(xx, yy, time + 1));
						}
						//���� �� ���� ���(������ ���� or ��ĭ)
						if(sea[xx][yy] == size || sea[xx][yy] == ZONE) {
							que.add(new Fish(xx, yy, time + 1));
							visited[xx][yy] = true;
						}
					}
				}
			}
			// ���� �� �ִ� ����� �����
			if(!feed.isEmpty()) {
				//�̵��� �� �Ļ�
				eat();
				// �̵��� �ڿ��� �Ʊ����� ��ǥ�� ����ǹǷ� �ʱ�ȭ �� 
				que.clear();
				visited = new boolean[N][N];
				// �ٽ� �̵� ť�� �߰�
				que.add(babyShark);
				visited[babyShark.x][babyShark.y] = true;
			} else {
				return;
			}			
		}
	}
	// �̵� �� �Ļ� ����
	public static void eat() {
		// ���� �� �켱���� ����(���� - ���� ���� �켱, ���� ���Ͻ� ���� �켱)
		Collections.sort(feed, new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				//�̵� �Ÿ� ���� �� 
				if(o1.time == o2.time) {
					// ���� ���ο� �����
					if(o1.x == o2.x) {
						// ���ʿ� �ִ� ����Ⱑ �տ������� ����
						if(o1.y > o2.y) {
							return 1;
						// �ƴѰ�� ����
						} else {
							return -1;
						}
					// ���� ���ο� �������� ���� ���
					} else {
						// �� �������� ������ ����Ⱑ �տ������� ����
						if(o1.x > o2.x) {
							return 1;
						// �ƴѰ�� ���� 
						} else {
							return -1;
						}
					}
				// �̵��Ÿ��� ���̳� ��� ���� �̵��Ÿ��� ������ ������ ����
				} else if(o1.time > o2.time) {
					return 1;
				// �ƴѰ�� ���� 
				} else {
					return -1;
				}
			};
		});
		// �켱������ �����ϴ� ����� �Ѹ��� ���� ��������
		Fish feed1 = feed.get(0);
		
		// ��� �̵�
		babyShark.x = feed1.x;
		babyShark.y = feed1.y;
		// ��� ������� ���� �������� ������ ����(�̵��� �Ļ�� ���ÿ� �̷�����Ƿ� ++eaten)
		if(++eaten == size) {
			size++;
			// ������ Ŀ�� �� ��ȭ�� �ǹǷ� 0���� �ʱ�ȭ
			eaten = 0;
		}
		
		//����� ���� �ð� �߰�
		answer += feed1.time;
		//���� �ڸ��� ����� ó��
		sea[feed1.x][feed1.y] = ZONE;
		
		// �̵��� �ڸ����� �ٽ� ��ǥ�� ���ؾ��ϹǷ� ���� �迭 �ʱ�ȭ
		feed.clear();
	}
}

class Fish {
	int x;
	int y;
	int time;
	
	public Fish(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}