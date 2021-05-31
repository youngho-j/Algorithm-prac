package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreadthFirstSearch_g_16236_1 {
	/*
	 * 1. N = 공간의 크기 (2 <= N <= 20)
	 * 2. 지도의 크기 N,N (한칸에는 최대 1마리의 물고기 존재)
	 * 3. 상어, 물고기의 크기는 모두 자연수
	 * 
	 * 4. 지도 표시 정보
	 * 4-1. 상어 
	 * 		위치 - 숫자 9로 표시
	 * 		크기 - 처음 크기는 2
	 * 4-2. 물고기
	 * 		크기 - 1 ~ 6 칸에 있는 물고기의 크기
	 * 4-3. 빈칸 - 0으로 표시
	 * 
	 * 5. 이동 
	 * 5-1. 아기 상어 자신보다 큰 물고기가 있는 칸을 지날 수 없음
	 * 		(처음 아기상어의 크기는 2 이므로, 3이상은 지날 수 없음)
	 * 5-2. 아기 상어 자신과 같은 크기의 물고기 먹을 수 없으나, 지나갈수는 있음
	 * 		(처음 아기상어의 크기는 2 이므로, 2 크기의 물고기 칸으로 이동은 가능)
	 * 5-3. 자신의 크기보다 작은 물고기만 먹을 수 있음
	 * 		(처음 아익상어의 크기는 2 이므로, 1 크기의 물고기만 먹을 수 있음)
	 * 
	 * 6. 크기 증가 조건 - 상어가 먹은 물고기 수 == 상어의 크기 인경우 크기++;
	 * 
	 * 7. 물고기 먹는 조건
	 * 7-1. 가장 이동거리가 짧은 물고기를 먹는다. 
	 * 		(상어의 좌표에서 가장 이동거리가 짧아야함)
	 * 7-2. 이동거리가 같은 경우 가장 위쪽에 있는 물고기, 가장 위쪽에 있는 물고기가 여러마리일 경우 가장 왼쪽에 있는 물고기를 먹음
	 * 		(상어가 1,1 좌표에 존재하고 크기가 1인 물고기가 0,0 / 0,2에 존재시 0,0 물고기 부터 먹음)
	 * 
	 * 8. 물고기를 먹으면 빈칸이 되고, 상어는 먹은 물고기 위치로 이동
	 * 
	 * 9. 먹을 수 있는 물고기가 없으면 중단
	 *
	 * 
	 * 동작순서
	 * 
	 * 1. 입력(지도 크기, 지도 내 물고기, 상어, 빈공간 위치) 
	 * 2. 상어 키우기
	 * 2-1. 상어의 위치를 파악
	 * 2-2. 해당 위치부터 상하좌우로 이동하며 먹을 수 있거나, 지나갈 수 있는 곳 파악
	 * 2-3. 가장 가까운 먹이를 먹을 수 있도록 정렬
	 * 2-4. 이동과 동시에 먹이를 먹음
	 * 2-5. 2-1부터 다시 시작 
	 * 3. 출력 
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