package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming_1_1003 {
	
	/*
	 * 계산한 결과를 저장하는 배열 
	 * arr[1][0]; -> N이 1일때 0이 나온 횟수 
	 * arr[1][1]; -> N이 1일때 1이 나온 횟수
	 */
	public static Integer[][] arr = new Integer[41][2];	
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		//N이 0일때 0, 1 호출 횟수
		arr[0][0] = 1;
		arr[0][1] = 0;
		
		//N이 1일때 0, 1 호출 횟수
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(arr[N][0] + " " + arr[N][1]).append("\n");
		}
		System.out.println(sb);
	}
	public static Integer[] fibonacci(int N) {
//		값이 비어 있을 경우 즉, 탐색하지 않은 경우
		if(arr[N][0] == null || arr[N][1] == null) {
//			N에 대한 0과 1 호출 횟수를 재귀를 통해 각각 더해줌
			arr[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			arr[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
//		N에 대한 0과 1의 호출 횟수를 담은 arr[N] 리턴
		return arr[N];
	}
}
