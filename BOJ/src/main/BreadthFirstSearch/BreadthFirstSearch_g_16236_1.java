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

public class BreadthFirstSearch_g_16236_1 {
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
	 * 
	 * ���ۼ���
	 * 
	 * 1. �Է�(���� ũ��, ���� �� �����, ���, ����� ��ġ) 
	 * 2. ��� Ű���
	 * 2-1. ����� ��ġ�� �ľ�
	 * 2-2. �ش� ��ġ���� �����¿�� �̵��ϸ� ���� �� �ְų�, ������ �� �ִ� �� �ľ�
	 * 2-3. ���� ����� ���̸� ���� �� �ֵ��� ����
	 * 2-4. �̵��� ���ÿ� ���̸� ����
	 * 2-5. 2-1���� �ٽ� ���� 
	 * 3. ��� 
	*/
	
	private static int N;
	// ��� �ʱ� ������
	private static int size = 2;
	// �� ���̸� ���� Ƚ��
	private static int eaten = 0;
	// ���� �迭
	private static int[][] map;
	// �湮 �迭
	private static boolean[][] isVisit;
	
	//�� ���� ������ ���� Ŭ���� 
	private static Fishs babyShark;
	//���� �迭
	private static ArrayList<Fishs> feed = new ArrayList<Fishs>();
	
	//���� �¿� �̵��� ���� �迭
	private static int[] upDown = {-1, 1, 0, 0};
	private static int[] leftRight = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		map = new int[N][N];
		isVisit = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// ����� ��ġ�� ������ ���� �� �ش� ���� �� �������� ǥ��
				if(map[i][j] == 9) {
					babyShark = new Fishs(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		
		growShark();
		
		System.out.println(babyShark.distance);
	}
	
	public static void growShark() {
		//����� ����Ǵ� ��ġ�� ����� ť
		Queue<Fishs> qu = new LinkedList<Fishs>();
		// ����� ��ġ Ȯ��
		qu.add(babyShark);
		isVisit[babyShark.x][babyShark.y] = true;
		
		while(true) {
			while(!qu.isEmpty()) {
				Fishs shark = qu.poll();
				int dis = shark.distance;
				//��� �ֺ� ���� �� �ִ� ����� Ž��
				for(int i = 0 ; i < 4 ; i++) {
					int xx = shark.x + upDown[i];
					int yy = shark.y + leftRight[i];
					// �������� ����� �ʰ� �湮�� ���� �ʾҴ� ���
					if((xx >= 0 && yy >= 0 && xx < N && yy < N) && !isVisit[xx][yy]) {
						//���� �� �ִ� ����� �߰�
						if(map[xx][yy] < 2 && map[xx][yy] != 0) {
							qu.add(new Fishs(xx, yy, dis + 1));
							isVisit[xx][yy] = true;
							feed.add(new Fishs(xx, yy, dis + 1));
						}
						//�̵��� ����(����� ���ų� ������ΰ��)
						if(map[xx][yy] == size || map[xx][yy] == 0) {
							qu.add(new Fishs(xx, yy, dis + 1));
							isVisit[xx][yy] = true;
						}
					}
				}
			}
			if(!feed.isEmpty()) {
				//����� �Ա�
				eatFish();
				//���� ����� ��ġ�� ����ǹǷ� ����� �̵� ���� ť�� �湮 �迭�� �ʱ�ȭ
				qu.clear();
				isVisit = new boolean[N][N];
				//����� ���� �� ��ġ ��� �̵� ť�� �߰� �� �湮 ���·� ����
				qu.add(babyShark);
				isVisit[babyShark.x][babyShark.y] = true;
			} else {
				return;
			}
		}
	}
	public static void eatFish() {
		//����⸦ �Ա� �� ���ǰ� ��ġ�ؾ������� ���� �迭�� �� �Ǵ� �� ���� �ʿ�
		Collections.sort(feed, new Comparator<Fishs>() {
			@Override
			public int compare(Fishs o1, Fishs o2) {
				//�̵� �Ÿ��� ���� ���
				if(o1.distance == o2.distance) {
					//���� ���ο� ������ ���
					if(o1.x == o2.x) {
						// ������ �ִ� ����⸦ ���� ���� �� �ֵ��� ����
						if(o1.y > o2.y) {
							return 1;
						} else {
							return -1;
						}
					//���� ���ο� �������� ���� ���
					} else {
						// �� ���� ���ο� �ִ� ����⸦ ���� ���� �� �ֵ��� ����
						if(o1.x > o2.x) {
							return 1;
						} else {
							return -1;
						}
					}
				//�̵� �Ÿ��� o1�� ū���
				} else if(o1.distance > o2.distance) {
					//�������� ����
					return 1;
				// �׿��� ���
				} else {
					//�迭 ����
					return -1;					
				}
			};
		});
		//������ ��ģ �� ���� �켱 ������ ���� ����⸦ ������
		Fishs first = feed.get(0);
		
		//������ ��ġ�� �̵�
		babyShark.x = first.x;
		babyShark.y = first.y;
		//���� �ð� �߰� 
		babyShark.distance += first.distance;
		
		//���̸� ���� �� ��� ������ ���� üũ
		if(++eaten == size) {
			size++;
			eaten = 0;
		}
		
		// ���� �ڸ��� ��������� ó��
		map[first.x][first.y] = 0;
		
		// ���̸� �Ա����� �̵��� �ڸ����� �ٽ� ��ǥ�� ���ؾ��ϹǷ� �迭 �ʱ�ȭ 
		feed.clear();
	}
}

class Fishs {
	int x, y, distance;

	public Fishs(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}	
}