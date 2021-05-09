package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BruteForce_g_15686 {
	// ���� ũ��, ���� �ش�ȭ ġŲ�� ��, ���� ���� ġŲ �Ÿ� �� 
	private static int N, M, minimum = Integer.MAX_VALUE;
	
	// ���� 
	private static int[][] map;
	
	// ������ ġŲ���� Ȯ���� �迭
	private static boolean[] check;
	
	// ������ ǥ�õ� ���� ġŲ������ ����� �迭
	private static ArrayList<Location> home = new ArrayList<>();
	private static ArrayList<Location> chicken = new ArrayList<>();
	
	// ������ ġŲ���� ���� �迭
	private static ArrayList<Location> selectedChicken = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new Location(i, j));
				} else if(map[i][j] == 2) {
					chicken.add(new Location(i, j));					
				}
			}
		}
		//������ ������ ġŲ�� ��ŭ �迭 ũ�� ����
		check = new boolean[chicken.size()];
		
		dfs(0, 0);
		
		System.out.println(minimum);
	}
	
	private static void dfs(int start, int pick) {
		if(pick == M) {
			// �ּҰŸ� ���
			int sum = 0;
			for(int i = 0 ; i < home.size() ; i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0 ; j < selectedChicken.size() ; j++) {
					int distance = Math.abs(home.get(i).x - selectedChicken.get(j).x) + Math.abs(home.get(i).y - selectedChicken.get(j).y);
					if(min > distance) {
						min = distance;
					}
				}
				// ���õ� ġŲ������ �ּҰŸ��� ��
				sum += min;
			}
			if(sum < minimum) {
				minimum = sum;
			}
		} else {
			// M ��ŭ ���õ��� �ʾ��� ���(�� ���õǾ�� �ϴ� ���)
			// ���� �� ���� �ִ� ġŲ������ ��� ���鼭
			for(int i = start ; i < chicken.size() ; i++) {
				// ���õ��� �ʾ��� ���
				if(!check[i]) {
					// �ش� ġŲ���� ������ �� 
					check[i] = true;
					// ���õ� ġŲ���� �迭�� ����
					selectedChicken.add(chicken.get(i));
					dfs(i+1, pick + 1);
					selectedChicken.remove(selectedChicken.size()-1);
					check[i] = false;
				}
			}
		}
	}
	// ��ǥ�� ����ֱ� ���� Ŭ����
	public static class Location {
		//��ǥ
		int x, y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
