package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Sort_1_2750 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		increase(arr);
//		Ãâ·Â
		for(int i = 0 ; i < arr.length ; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}
	public static void increase(int[] arr) {
		int temp = 0;
		int idx = 0;
		for(int i = 1 ; i < arr.length ; i++) {
			idx = i-1;
			while(idx != -1) {
				if(arr[idx] > arr[idx+1]) {
					temp = arr[idx+1];
					arr[idx+1] = arr[idx];
					arr[idx] = temp;
				}
				idx--;
			}
		}
	}
}
