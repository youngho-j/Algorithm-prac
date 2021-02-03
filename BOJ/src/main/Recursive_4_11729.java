package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_4_11729 {	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//원반의 수
		int N = Integer.parseInt(br.readLine());
		//총 이동 횟수 출력
		sb.append((int)(Math.pow(2, N) - 1)).append("\n");
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(sb);
	}
	public static void hanoi(int N, int start, int via, int end) {
		//원반수가 1 일때 (종료조건)
		if(N == 1) {
			sb.append(start + " " + end + "\n");
			System.out.println(start + " " + end + "테스트");
			return;
		}
		// N번째 블록을 제외한 블록을 A -> B로 이동
		hanoi(N-1, start, end, via);
		// N번째 원판을 A -> C로 이동
		sb.append(start + " " + end + "\n");
		System.out.println(start + " " + end + "테스트");
		// N번째 블록을 제외한 블록을 B -> C 이동
		hanoi(N-1, via, start, end);
	}
}
