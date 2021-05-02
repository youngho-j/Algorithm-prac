package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_15684 {
	
	// 세로선 개수(열), 가로선 개수, 세로선 마다 가로선을 놓을 수 있는 위치의 개수(행)
	static int N, M, H;
	static int[][] ladder;
	static int ans;
	static boolean isCheck;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
		
		ladder = new int[H+1][N+1];
		
		int a, b;
		while(M --> 0) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				// 오른쪽 이동시 1, 왼쪽 이동시 2
				ladder[a][b] = 1;
				ladder[a][b+1] = 2;
		}
		
		//사다리 가로선 놓는 경우의 수(한번도 안놓고 성공시 ~ 최대 3번까지)
		for(int i = 0 ; i <= 3 ; i++) {
			// 새로 놓은 가로 사다리 개수
			ans = i;
			addLadder(1, 0, i);
			if(isCheck) {
				break;
			}
		}
		
		// 조건이 참이면 ans, 거짓인경우 -1 출력
		System.out.println(isCheck ? ans : -1);
		
	}
	//시작 세로선, 선택된 개수, 놓은 가로선의 경우의 수
	static void addLadder(int row, int cnt, int len) {
		// i번 세로 선의 결과가 i번일 경우 즉시 종료!
		if(isCheck) {
			return;
		}
		// 사다리 추가 개수와 경우의 수 일치시 조작이 잘 되었는지 검사
		if(cnt == len) {
			if(isPossible()) {
				isCheck = true;
			}
			return;
		}
		for(int i = row ; i < H+1 ; i++) {
			// 사다리를 놓을때 N번째 라인에서 놓을 경우 N+1라인이 필요 
			// 따라서 N번에 사다리를 놓기 위해서는 N-1에서 사다리를 놓아야함 
			// 즉, j는 < N 범위까지만 놓아야 배열초과오류가 나지 않음 
			for(int j = 1 ; j < N ; j++) {
				if(ladder[i][j] == 0 && ladder[i][j+1] == 0) {
					// 사다리 놓기
					ladder[i][j]=1;
					ladder[i][j+1]=2;
					addLadder(i,cnt+1, len);
					ladder[i][j]=0;
					ladder[i][j+1]=0;
				}
			}
		}
	}
	
	
	// i 사다리가 i값으로 내려오는지 검사 
	static boolean isPossible() {
		// 1번 세로선 부터 확인하면서 진행
		for(int i = 1 ; i <= N ; i++) {
			// 1번 세로선 확인후 다음 세로선으로 이동하므로(가로방향)
			int row = i;
			// 맨위부터 시작하므로 1이 시작점
			int col = 1;
			// 시작점부터 내려오면서 진행
			for(int j = 0 ; j < H ; j++) {
				// 해당지점의 값이 1이면 오른쪽으로 이동(row 값 추가)
				if(ladder[col][row] == 1) {
					row++;
				// 해당지점의 값이 2이면 왼쪽으로 이동(row 값 감소)
				} else if(ladder[col][row] == 2) {
					row--;
				}
				//좌우측 이동할 수 없으므로 세로(열)로 내려감
				col++;
			}
			// 출발지점 i와 도착지점 row가 같지 않으면
			if(row != i) {
				return false;
			}
		}
		return true;
	}
}
// 참고 - https://gwanhyeon.github.io/Samsung-20210422-ladder-fake/
// 문제 참고 - https://covenant.tistory.com/224