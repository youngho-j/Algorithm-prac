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
	// 상어 초기 사이즈
	private static int size = 2;
	// 상어가 먹이를 먹은 횟수
	private static int eaten = 0;
	// 지도 배열
	private static int[][] map;
	// 방문 배열
	private static boolean[][] isVisit;
	
	//상어에 대한 정보를 담은 클래스 
	private static Fishs babyShark;
	//먹이 배열
	private static ArrayList<Fishs> feed = new ArrayList<Fishs>();
	
	//상하 좌우 이동을 위한 배열
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
				// 상어의 위치를 변수에 담은 뒤 해당 공간 빈 공간으로 표시
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
		//상어의 변경되는 위치를 담아줄 큐
		Queue<Fishs> qu = new LinkedList<Fishs>();
		// 상어의 위치 확인
		qu.add(babyShark);
		isVisit[babyShark.x][babyShark.y] = true;
		
		while(true) {
			while(!qu.isEmpty()) {
				Fishs shark = qu.poll();
				int dis = shark.distance;
				//상어 주변 먹을 수 있는 물고기 탐색
				for(int i = 0 ; i < 4 ; i++) {
					int xx = shark.x + upDown[i];
					int yy = shark.y + leftRight[i];
					// 지도에서 벗어나지 않고 방문을 하지 않았던 경우
					if((xx >= 0 && yy >= 0 && xx < N && yy < N) && !isVisit[xx][yy]) {
						//먹을 수 있는 물고기 발견
						if(map[xx][yy] < 2 && map[xx][yy] != 0) {
							qu.add(new Fishs(xx, yy, dis + 1));
							isVisit[xx][yy] = true;
							feed.add(new Fishs(xx, yy, dis + 1));
						}
						//이동만 가능(사이즈가 같거나 빈공간인경우)
						if(map[xx][yy] == size || map[xx][yy] == 0) {
							qu.add(new Fishs(xx, yy, dis + 1));
							isVisit[xx][yy] = true;
						}
					}
				}
			}
			if(!feed.isEmpty()) {
				//물고기 먹기
				eatFish();
				//먹은 상어의 위치가 변경되므로 상어의 이동 관련 큐와 방문 배열을 초기화
				qu.clear();
				isVisit = new boolean[N][N];
				//물고기 먹은 뒤 위치 상어 이동 큐에 추가 후 방문 상태로 변경
				qu.add(babyShark);
				isVisit[babyShark.x][babyShark.y] = true;
			} else {
				return;
			}
		}
	}
	public static void eatFish() {
		//물고기를 먹기 전 조건과 일치해야하으로 먹이 배열을 역 또는 순 정렬 필요
		Collections.sort(feed, new Comparator<Fishs>() {
			@Override
			public int compare(Fishs o1, Fishs o2) {
				//이동 거리가 같을 경우
				if(o1.distance == o2.distance) {
					//같은 라인에 존재할 경우
					if(o1.x == o2.x) {
						// 좌측에 있는 물고기를 먼저 먹을 수 있도록 정렬
						if(o1.y > o2.y) {
							return 1;
						} else {
							return -1;
						}
					//같은 라인에 존재하지 않을 경우
					} else {
						// 더 높은 라인에 있는 물고기를 먼저 먹을 수 있도록 정렬
						if(o1.x > o2.x) {
							return 1;
						} else {
							return -1;
						}
					}
				//이동 거리가 o1이 큰경우
				} else if(o1.distance > o2.distance) {
					//오름차순 정렬
					return 1;
				// 그외의 경우
				} else {
					//배열 유지
					return -1;					
				}
			};
		});
		//정렬을 마친 뒤 가장 우선 순위가 높은 물고기를 가져옴
		Fishs first = feed.get(0);
		
		//먹이의 위치로 이동
		babyShark.x = first.x;
		babyShark.y = first.y;
		//먹은 시간 추가 
		babyShark.distance += first.distance;
		
		//먹이를 먹은 뒤 상어 사이즈 조건 체크
		if(++eaten == size) {
			size++;
			eaten = 0;
		}
		
		// 먹은 자리를 빈공간으로 처리
		map[first.x][first.y] = 0;
		
		// 먹이를 먹기위해 이동한 자리부터 다시 좌표를 구해야하므로 배열 초기화 
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