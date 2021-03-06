package main.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_4_retry {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[8001];
		int sum = 0;
		int max = -4000;
		int min = 4000;
		int mode = 0;
		int mid = 0;
		
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			
			input[num + 4000]++;
			
			sum += num;
			
			if(max < num) max = num;
			
			if(min > num) min = num;
		}
		int order = 0;
		int mode_max = 0;
		boolean check = false;
		
		for(int i = min + 4000 ; i <= max + 4000 ; i++) {
			if(input[i] > 0) {
				if(order < (N+1)/2) {
					order += input[i];
					mid = i - 4000;
				}
				if(mode_max < input[i]) {
					mode_max = input[i];
					mode = i - 4000;
					check = true;
				} else if(mode_max == input[i] && check == true) {
					mode = i - 4000;
					check = false;
				}
			}
		}
		System.out.println((int)Math.round((double)sum/N));
		System.out.println(mid);
		System.out.println(mode);
		System.out.println(max-min);
	}
}
