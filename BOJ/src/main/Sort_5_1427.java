package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Sort_5_1427 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = br.readLine();
		
		Integer[] arr = new Integer[num.length()];
		
		int N = Integer.parseInt(num);
		int count = num.length()-1;
//		배열에 넣기
		while(N != 0) {
			arr[count] = N%10;
			count--;
			N/=10;
		}
//		Comparator 객체 내림차순을 위해 전달
//		Comparator로 비교시 Integer를 사용해야함.
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = 0; i < num.length() ; i++) {
			sb.append(arr[i]);
		}
		sb.append("\n");
		System.out.println(sb);
	}
}
