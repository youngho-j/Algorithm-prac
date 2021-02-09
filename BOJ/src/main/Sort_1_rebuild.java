package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_1_rebuild {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//		절댓값이 1,000보다 작거나 같은 정수, 중복X를 담을 배열
//		인덱스           정수
//		0 ~ 999     -> -1000 ~ -1
//		1000        -> 0
//		1001 ~ 2000 -> 1 ~ 1000
		boolean[] list = new boolean[2001];
		
//		해당 숫자의 인덱스를 true로 변경 
		for(int i = 0 ; i < N ; i++) {
			list[Integer.parseInt(br.readLine()) + 1000] = true;
		}
//		입력된 숫자를 오름차순으로 저장
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i]) {
				sb.append((i - 1000)+ "\n");				
			}
		}
		System.out.println(sb);
	}
}
