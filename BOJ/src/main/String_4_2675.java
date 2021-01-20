package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_4_2675 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < testCase ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int refeat = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for(int j = 0 ; j < str.length() ; j++) {
				for(int k = 0 ; k < refeat ; k++) {
					sb.append(str.charAt(j));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
