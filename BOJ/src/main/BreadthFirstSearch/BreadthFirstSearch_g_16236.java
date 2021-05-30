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
		// 이동을 위한 배열
		Queue<Fish> que = new LinkedList<Fish>();
		// 상어 위치, 이동시간 추가
		que.add(babyShark);
		visited[babyShark.x][babyShark.y] = true;
		// 반복
		while(true) {
			while(!que.isEmpty()) {
				Fish fish = que.poll();
				int time  = fish.time;
				
				for(int i = 0 ; i < 4 ; i++) {
					int xx = fish.x + upDown[i];
					int yy = fish.y + leftRight[i];
					// 범위 안에 존재하고, 이동 할 수 있는 경우(false 즉, 방문 하기전인경우)
					if((xx >= 0 && yy >= 0 && xx < N && yy < N) && !visited[xx][yy]) {
						//먹을 수 있는 경우
						if(sea[xx][yy] < size && sea[xx][yy] != 0) {
							que.add(new Fish(xx, yy, time + 1));
							visited[xx][yy] = true;
							// 먹이 배열에 추가
							feed.add(new Fish(xx, yy, time + 1));
						}
						//먹을 수 없는 경우(사이즈 동일 or 빈칸)
						if(sea[xx][yy] == size || sea[xx][yy] == ZONE) {
							que.add(new Fish(xx, yy, time + 1));
							visited[xx][yy] = true;
						}
					}
				}
			}
			// 먹을 수 있는 물고기 존재시
			if(!feed.isEmpty()) {
				//이동한 뒤 식사
				eat();
				// 이동한 뒤에는 아기상어의 좌표가 변경되므로 초기화 후 
				que.clear();
				visited = new boolean[N][N];
				// 다시 이동 큐에 추가
				que.add(babyShark);
				visited[babyShark.x][babyShark.y] = true;
			} else {
				return;
			}			
		}
	}
	// 이동 후 식사 시작
	public static void eat() {
		// 먹이 중 우선순위 지정(조건 - 높은 라인 우선, 라인 동일시 왼쪽 우선)
		Collections.sort(feed, new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				//이동 거리 같을 떄 
				if(o1.time == o2.time) {
					// 같은 라인에 존재시
					if(o1.x == o2.x) {
						// 왼쪽에 있는 물고기가 앞에가도록 정렬
						if(o1.y > o2.y) {
							return 1;
						// 아닌경우 유지
						} else {
							return -1;
						}
					// 같은 라인에 존재하지 않을 경우
					} else {
						// 더 놓은쪽의 라인의 물고기가 앞에가도록 정렬
						if(o1.x > o2.x) {
							return 1;
						// 아닌경우 유지 
						} else {
							return -1;
						}
					}
				// 이동거리가 차이날 경우 낮은 이동거리가 앞으로 가도록 정렬
				} else if(o1.time > o2.time) {
					return 1;
				// 아닌경우 유지 
				} else {
					return -1;
				}
			};
		});
		// 우선순위에 부합하는 물고기 한마리 정보 가져오기
		Fish feed1 = feed.get(0);
		
		// 상어 이동
		babyShark.x = feed1.x;
		babyShark.y = feed1.y;
		// 상어 사이즈와 먹은 물고기수가 같으면 성장(이동과 식사는 동시에 이루어지므로 ++eaten)
		if(++eaten == size) {
			size++;
			// 사이즈 커진 후 소화가 되므로 0으로 초기화
			eaten = 0;
		}
		
		//물고기 먹은 시간 추가
		answer += feed1.time;
		//먹은 자리는 빈공간 처리
		sea[feed1.x][feed1.y] = ZONE;
		
		// 이동한 자리부터 다시 좌표를 구해야하므로 먹이 배열 초기화
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