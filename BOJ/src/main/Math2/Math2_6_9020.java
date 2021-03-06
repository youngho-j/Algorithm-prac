package main.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math2_6_9020 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[10001];
		
		prime[0] = prime[1] = true;
		
		for(int j = 2 ; j <= Math.sqrt(10000) ; j++) {
			if(prime[j]) {
				continue;
			}
			for(int k = j * j ; k <= 10000 ; k += j) {
				prime[k] =true;
			}
		}
		
		for(int i = 0 ; i < testCase ; i++) {
			int n = Integer.parseInt(br.readLine());
			
			//n까지의 소수를 모두 구함, 규칙상 작은수가 앞에 출력되야하므로 절반을 나누어 검사
			//작은값이 크면 클수록 큰값이 작아짐 -> 차이가 점점 작아진다.
			//n-작은값이 소수일경우 출력
			for(int l = (n/2) ; l > 1 ; l--) {
				if(prime[l]) {
					continue;
				}
				if(!prime[n-l]) {
					sb.append(l).append(" ").append((n-l)).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
/*
 * 참고 : 규칙을 찾을때는 암산하지말고 일단 노트에 끄적여보기
 * 에라토스테네스의 체 응용 
 * 시도 1. testCase 횟수만큼 해당 자연수 n 소수를 찾는 체를 돌림 -> 테스트케이스마다 for문을 실행하니 속도가 느림..
 * 시도 2. 골드바흐의 추측범위에 해당하는 10000까지 전체 소수를 먼저 찾음 -> testCase에서 범위만 설정하여 출력  
 */
