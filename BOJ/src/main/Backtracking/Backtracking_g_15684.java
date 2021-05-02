package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_15684 {
	
	// 세로선 개수, 가로선 개수, 세로선 마다 가로선을 놓을 수 있는 위치의 개수
	static int N, M, H;
	static int[][] ladder;
	static int ans;
	static boolean finish = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
		
		ladder = new int[H+1][N+1];
		
		if(M > 0) {
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 오른쪽 이동시 1, 왼쪽 이동시 2
				ladder[a][b] = 1;
				ladder[a][b+1] = 2;
			}
		}
		
		//사다리 가로선 놓기(한번도 안놓고 성공시 ~ 최대 3번까지)
		for(int i = 0 ; i <= 3 ; i++) {
			if(finish) {
				break;
			}
			ans = i;
			addLadder(1, 0);
		}
		
		// 정답 출력시 0 ~ 3 범위까지는 출력, 못찾거나, 3보다 큰경우 -1 출력
		if(ans > -1 && ans <= 3) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
		
	}
	static void addLadder(int row, int level) {
		if(finish) {
			return;
		}
		// 사다리 추가 개수와 일치시 전체 검사
		if(ans == level) {
			if(isPossible()) {
				finish = true;
				return;
			}
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
					addLadder(i,level+1);
					ladder[i][j]=0;
					ladder[i][j+1]=0;
				}
			}
		}
	}
	
	
	// i 사다리가 i값으로 내려오는지 검사 
	static boolean isPossible() {
		for(int i = 1 ; i <= N ; i++) {
			int row = i;
			int col = 1;
			
			while(true) {
				if(col == H+1) {
					break;
				}
				if(ladder[col][row] == 1) {
					row += 1;
				} else if(ladder[col][row] == 2) {
					row -= 1;
				}
				col++;
			}
			
			if(row != i) {
				return false;
			}
		}
		return true;
	}
}
