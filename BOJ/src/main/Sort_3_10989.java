package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_3_10989 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//		�־��� ���� 10000���� �۰ų� ���� �� �̹Ƿ�
		int[] counting = new int[10001];
//		�ش� �ε����� �� �����Ͽ� �迭�� ����
		for(int i = 0 ; i < N ; i++) {
			counting[Integer.parseInt(br.readLine())]++;
		}
		br.close();
//		�迭�� ũ�⸸ŭ ���鼭(0�� �ڿ���x) ���� ���ں��� stringbuilder�� ����
		for(int i = 1 ; i < 10001 ; i++) {
			while(counting[i] > 0) {
				sb.append(i + "\n");
				counting[i]--;
			}
		}
		System.out.println(sb);
	}
}
