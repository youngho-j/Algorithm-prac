package main.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_3_7568 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
//		몸무게 키 순위를 담을 배열
		int[][] arr = new int[3][N];
//		몸무게와 키를 각 열 0,1 위치에 담아줌
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 2 ; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
//		몸무게와 키 각 열별로 비교
		for(int i = 0 ; i < N-1 ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				if(arr[0][i] > arr[0][j] && arr[1][i] > arr[1][j]) {
					arr[2][j] += 1;
				} else if(arr[0][i] < arr[0][j] && arr[1][i] < arr[1][j]) {
					arr[2][i] += 1;
				}
			}
		}
//		비교하여 나온 값에 +1하여 순서 출력
		for(int i = 0 ; i < N ; i++) {
			sb.append(arr[2][i] + 1).append(" ");
		}
		System.out.println(sb);
	}
}
