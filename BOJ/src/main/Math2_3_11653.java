package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_3_11653 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		//1은 소수가 아니므로 2부터 시작
		//N이 계속 i로 나눠진 몫이 들어오므로 √N 보다 정수인 N이 처리하기 더 편함 따라서 i^2 
		for(int i = 2 ; i * i <= N ; i++) {
			while(N % i == 0) {
				sb.append(i).append("\n");
				N /= i;
			}
		}
		// N이 1인 경우 아무것도 출력하지 않음, 1이 아닌경우는 출력해야하므로, 위 공식에서 남은 1이아닌 나머지N을 출력
		if(N != 1) {
			sb.append(N);
		}
		System.out.println(sb);
	}
}
/*
	
	참고 : 임의의 정수 N에 대하여 곱셈으로 분해하면 √N을 기준으로 대칭이됨.
	      Ex) 12 -> 1, 2, 3, √12(3.4641016...), 4, 6, 12
	      따라서 √N 이하의 나눠지는 수(i)를 구하게 되면 자연스럽게 대칭되는 몫을 알 수 있음 N = i * X
	      즉, i^2 이 N 이하일 때 까지만 탐색해도 된다. 
	      
	소인수 분해 - 자연수를 소인수들의 곱으로 표현 
	* 자연수 n의 약수 = 자연수 n의 인수
	* 인수 중 소수 -> 소인수
*/