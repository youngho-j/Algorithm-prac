package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreadthFirstSearch_g_16236 {
	
	private static int N;
	
	private static int[][] sea;
	
	private static boolean[][] visited;
	
	private static Fish babyShark;
	private static int size = 2;
	private static int eaten = 0;
	
	private static int answer;
	
	private static int[] upDown = {-1, 1, 0, 0};
	private static int[] leftRight = {0, 0, -1, 1};
	
	private static final int ZONE = 0;
	
	public static void main(String[] args) throws IOException{
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
					babyShark = new Fish(j, j, 0);
					sea[i][j] = 0;
				}
			}
		}
		
		
		
		System.out.println(answer);
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