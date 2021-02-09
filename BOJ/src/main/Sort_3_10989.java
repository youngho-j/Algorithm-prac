package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_3_10989 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//		주어진 수는 10000보다 작거나 같은 수 이므로
		int[] counting = new int[10001];
//		해당 인덱스의 값 누적하여 배열에 저장
		for(int i = 0 ; i < N ; i++) {
			counting[Integer.parseInt(br.readLine())]++;
		}
		br.close();
//		배열의 크기만큼 돌면서(0은 자연수x) 작은 숫자부터 stringbuilder에 누적
		for(int i = 1 ; i < 10001 ; i++) {
			while(counting[i] > 0) {
				sb.append(i + "\n");
				counting[i]--;
			}
		}
		System.out.println(sb);
	}
}
