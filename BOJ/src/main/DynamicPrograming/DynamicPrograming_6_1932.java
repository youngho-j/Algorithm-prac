package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	arr -> 입력배열 , dp -> 합 저장 배열, N -> 최고 깊이
*/
public class DynamicPrograming_6_1932 {
	static int[][] arr;
	static int[][] dp;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		dp = new int[N][N];

//		arr 채우기, dp -1로 초기화(정수 범위 0 ~ 9999이므로)
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j <= i ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
//		dp에 밑변 값 추가
		for(int i = 0 ; i < N ; i++) {
			dp[N-1][i] = arr[N-1][i];
		}
		System.out.println(pathOfSum(0, 0)); 
	}

	/*
	 * 원래는 위에서 내려가는 형식으로 출력하려 했으나, 
	 * 최종 밑변까지 도달시 모든 밑변의 수를 비교해야하기 때문에 처리과정이 길어짐..
	 * 아래서 위로 가능 방식으로 변경
	 */
	public static int pathOfSum(int x, int y) {
//		밑변에 도달시 저장된 값을 불러옴
		if(x == N - 1) {
			return dp[x][y];
		}
//		탐색하지 않은 경우 다음 깊이의 양쪽 값을 비교하여 출력
		if(dp[x][y] == -1) {
			dp[x][y] = Math.max(pathOfSum(x + 1, y), pathOfSum(x + 1, y + 1)) + arr[x][y];
		}
//		최종적으로 가장 누적값이 큰 값이 0,0에 입력되므로 출력하면됨
		return dp[x][y];
	}
}
