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
 * 원인 : 변수값을 잘 못 넣었음. 배열만큼 비교하기 위해 N값을 넣었어야했는데 X값을 넣어서 오류발생 / 굳이 ArrayList를 쓸 필요 없었음.
 */
