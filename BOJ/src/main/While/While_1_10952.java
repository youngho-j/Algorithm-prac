package main.While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class While_1_10952 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = 0;
		int b = 0;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a != 0 && b != 0 ) {
				sb.append(a+b).append("\n");				
			} else {
				System.out.println(sb);
				break;
			}
		}
	}
}
