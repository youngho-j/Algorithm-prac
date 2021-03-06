package main.For;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class For_11_10871 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int temp = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(X > temp) {
				sb.append(temp).append(" ");
			}
		}
		System.out.println(sb);
	}
}
/*
 * ���� : �������� �� �� �־���. �迭��ŭ ���ϱ� ���� N���� �־�����ߴµ� X���� �־ �����߻� / ���� ArrayList�� �� �ʿ� ������.
 */
