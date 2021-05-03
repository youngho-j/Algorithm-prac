package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_15684_1 {
	// 세로선, 놓아진 가로선, 가로선을 놓을 수 있는 위치의 개수
	static int n, m, h;
	// 사다리를 저장할 배열
	static int[][] ladder;
	
	static int result;
	static boolean isOk;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		ladder= new int[h+1][n+1];
		
		//가로선의 정보
		int a, b;
		while(m --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ladder[a][b] = 1;
			ladder[a][b+1] = 2;
		}
		
		// 출력시 정답이 3보다 크거나 불가능한 경우 -1 출력
		for(int i = 0 ; i <= 3 ; i++) {
			result = i;
			dfs(1, 0, i);
			if(isOk) {
				break;
			}
		}
		System.out.println(isOk? result:-1);
	}
	// 시작 선, 그어진 선의 개수,추가된 선의 개수
	static void dfs(int x, int pick, int cnt) {
		if(isOk) {
			return;
		}
		// 사다리를 놓았을때 원하는 결과가 나오는지 체크
		if(pick == cnt) {
			if(check()) {
				isOk = true;		
			}
			return;
		}
		//사다리 추가하기 
		for(int i = x ; i < h+1 ; i++) {
			for(int j = 1 ; j < n ; j++) {
				if(ladder[i][j] == 0 && ladder[i][j+1] == 0) {
					ladder[i][j] = 1;
					ladder[i][j+1] = 2;
					dfs(x, pick+1, cnt);
					ladder[i][j] = 0;
					ladder[i][j+1] = 0;					
				}
			}
		}
	}
	// i번째 사다리의 결과가 i번 나오는지 검사 
	static boolean check() {
		// 1번 사다리 부터 검사 ~ n번사다리까지
		for(int i = 1 ; i <= n ; i++) {
			//i번째 사다리 1번 위치부터 시작
			int mx = 1;
			// i번째 사다리 
			int my = i;
			// i번째 사다리 시작점 부터 내려가면서 진행
			for(int j = 0 ; j < h ; j++) {
				// 1일경우 오른쪽으로 이동
				if(ladder[mx][my] == 1) {
					my++;
				} else if(ladder[mx][my] == 2) {
					my--;
				}
				mx++;
			}
			//출발지점 i와 도착지점 my가 같지 않을 경우 
			if(my != i) {
				return false;
			}
		}
		return true;
	}
}
