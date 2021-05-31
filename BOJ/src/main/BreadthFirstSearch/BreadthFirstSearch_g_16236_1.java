package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private static int answer;
	
	private static int[][] map;
	private static boolean[][] isVisit;
	
	private static Fishs babyShark;
	
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
				if(map[i][j] == 9) {
					babyShark = new Fishs(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		
	}
}

class Fishs {
	int x, y, location;

	public Fishs(int x, int y, int location) {
		this.x = x;
		this.y = y;
		this.location = location;
	}	
}