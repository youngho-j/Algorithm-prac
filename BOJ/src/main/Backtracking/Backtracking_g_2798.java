package main.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_g_2798 {
	
	static int N;
	static int M;
	static int result;
	
	static int[] card;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		search(card, N, M);
		System.out.println(result);
		
	}
	
	public static void search(int[] arr, int N, int M) {
		for(int i = 0 ; i < N - 2 ; i++) {
			if(arr[i] > M) continue;
			for(int j = i + 1 ; j < N - 1 ; j++) {
				if(arr[i] + arr[j] > M) continue;
				for(int k = j + 1 ; k < N ; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					if(M == temp) {
						result = temp;
						return;
					}
					if(result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}
		return;
	}
}
