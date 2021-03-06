package main.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_9_4153 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0 && r == 0) {
				break;
			}
			//주어진 조건에서 각 입력은 변의 길이를 의미한다 라고만 나와있기 때문에 빗변, 밑변, 대변인지 알수 없음..
			if((h*h + w*w) == r*r) {
				sb.append("right").append("\n");
			} else if((h*h + r*r) == w*w){
				sb.append("right").append("\n");
			} else if((r*r + w*w) == h*h) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}
		System.out.println(sb);
	}
}
