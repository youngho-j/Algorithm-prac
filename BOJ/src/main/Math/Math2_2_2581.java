package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_2_2581 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//최소값을 구하기위해 유효범위중 가장 큰 값으로 지정
		int minPrime = 10000;
		// 소수가 존재하지 않을 경우 -1을 출력과 소수의 합을 위해 0으로 초기화
		int sumPrime = 0;
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		//해당 범위를 돌면서 소수 검사
		for(int i = M ; i <= N ; i++) {
			boolean isPrime = true;
			//1은 소수가 아니므로
			if(i == 1) {
				continue;
			}
			
			for(int j = 2 ; j <= Math.sqrt(i) ; j++) {
				//약수가 존재할 경우
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			//소수일때 소수 중 최소값과 합을 구함
			if(isPrime) {
				if(minPrime > i) {
					minPrime = i;
				}
				sumPrime += i;
			}
		}
		// 소수가 없을 경우 -1, 존재할 경우 소수의 합과 최소 소수 출력
		if(sumPrime == 0) {
			System.out.println(-1);
		} else {
			sb.append(sumPrime).append("\n").append(minPrime);
			System.out.println(sb);
		}
	}
}
