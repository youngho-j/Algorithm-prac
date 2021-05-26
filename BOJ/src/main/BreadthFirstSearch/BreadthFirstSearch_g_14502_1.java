package main.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreadthFirstSearch_g_14502_1 {
	//연구소 크기 - 행, 열 
	private static int N, M;
	
	//지도
	private static int[][] map;
	
	//바이러스 표시가된 지도
	private static int[][] infectedMap;
	
	private static final int ZONE = 0; 
	private static final int WALL = 1; 
	private static final int VIRUS = 2; 
	
	// 안전영역의 최대값을 구하기 위한 변수
	private static int safeZone = Integer.MIN_VALUE;
	// 0. 정보를 입력받음
	// 1. 벽을 세운다(3개까지)
	// 1-1. 벽을 3개 다 세웠을 경우 2번으로 이동
	// 1-2. 벽을 3개 다 세우지 못한경우 다시 1번으로 이동
	// 2. 다 세웠으면 바이러스를 퍼뜨린다.
	// 2-1. 바이러스를 퍼뜨리기전 지도배열을 복사한다.
	// 2-2. 바이러스 좌표를 큐에넣음
	// 2-3. 바이러스틑 퍼트림
	// 3. 바이러스가 퍼진 지도에서 안전구역을 카운팅 한다
	// 4. 안전구역의 최대크기를 출력한다.
	
	
	public static void main(String[] args) throws IOException {
		// 0. 입력
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
		// 1. 벽을 세운다.
		buildWall(0);
		
		// 4. 안전구역의 최대 크기 출력한다. 
		System.out.println(safeZone);
	}
	// 1. 벽을 세운다.
	public static void buildWall(int count) {
		// 1-1. 벽을 3개 다 세웠을 경우
		if(count == 3) {
			spreadVirus();
			return;
		}
		// 1-2. 벽을 3개 다 세우지 못한경우 다시 1번으로 이동
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
	// 2. 다 세웠으면 바이러스를 퍼뜨린다.
	public static void spreadVirus() {
		Queue<Dot2> que = new LinkedList<Dot2>();
		int[] upDown = {-1,1,0,0};
		int[] leftRigth = {0,0,-1,1};
		// 2-1. 바이러스를 퍼뜨리기전 지도배열을 복사한다.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				infectedMap[i][j] = map[i][j];
			}
		}
		// 2-2. 바이러스 좌표를 큐에넣음
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(infectedMap[i][j] == 2) {
					que.add(new Dot2(i, j));
				}
			}
		}
		//2-3. 바이러스를 퍼트림
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
		// 3. 바이러스가 퍼진 지도에서 안전구역을 카운팅 한다
		countingSafeZone();
	}
	
	// 3. 바이러스가 퍼진 지도에서 안전구역을 카운팅 한다
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

// 좌표 저장 클래스
class Dot2 {
	int x, y;
	
	public Dot2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}