package main.For;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class For_8_11022 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int a = Integer.parseInt(br.readLine());

		int temp1 = 0;
		int temp2 = 0;
		
		for(int i = 1 ; i <= a ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			sb.append("Case #" + i + ": " + temp1 + " + " + temp2 + " = "+ (temp1+temp2)  +"\n");
		}
		br.close();
		System.out.println(sb);
	}
}
