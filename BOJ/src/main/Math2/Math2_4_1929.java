package main.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_4_1929 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		//해당 범위까지 소수를 판별할 값을 담는 배열 선언
		boolean[] primeArr = new boolean[N+1];
		// 0, 1은 소수가 아니므로 true로 초기화
		primeArr[0] = primeArr[1] = true;
		// 곱으로 나타낼경우 해당 자연수N의 루트값을 기준으로 대칭을 이루므로 √N보다 작은 값들만 구해도됨
		for(int i = 2 ; i <= Math.sqrt(N); i++) {
			//해당 배열의 값이 true 즉, 소수가 아니면 아래 코드를 실행하지 않고 넘김
			if(primeArr[i]) {
				continue;
			}
			//배수 제외, i*i 미만은 이미 처리 j의 시작값을 i*i로 최적화
			for(int j = i * i ; j <= N ; j += i) {
				primeArr[j] = true;
			}
		}
		//출력
		for(int k = M ; k <= N ; k++) {
			if(!primeArr[k]) {
				sb.append(k).append("\n");
			}
		}
		System.out.println(sb);
	}
}
/*
 * 참고 : 에라토스테네스의 체
 * 대부분의 소수문제는 이 코드로 처리 가능!
 */
