package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicPrograming_2_9184 {
//	재귀함수 조건 중  <= 0, > 20 이므로 0~20에 대한 값만 저장해두면 됨
	public static int[][][] memo = new int[21][21][21];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
//			입력받은 수가 모두 -1일때 종료
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a, b, c)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int w(int a, int b, int c) {
//		체크해주는 조건이 없을 경우 입력되는 수의 범위가 -50 ~ 50이기 때문에 0 ~ 20으로 설정되어있는 배열의 범위보다 크므로 배열초과오류발생
		if(check(a, b, c) && memo[a][b][c] != 0) {
			return memo[a][b][c];
		}
//		입력받은 값이 <= 0 이면 무조건 1 리턴
		if(a <= 0 || b <= 0 || c <= 0 ) {
			return 1;			
		}
//		입력받은 값이 > 20 이면 무조건 memo[20][20][20]에 대한 값을 리턴
		if(a > 20 || b > 20 || c > 20) {
			return memo[20][20][20] = w(20, 20, 20);
		}
		if(a < b && b < c) {
			return memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		return memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
//	배열의 범위를 넘어서는 경우를 체크, 각 변수가 0 ~ 20 사이에 들어와야함
	public static boolean check(int a, int b, int c) {
		return  a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
	}
}
