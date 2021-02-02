package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Recursive_3_prac {
	static char[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		printStar(0, 0, N, false);
		
		for(int i = 0 ; i < N ; i++) {
			bw.write(arr[i]);
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static void printStar(int x, int y, int N, boolean blank) {
		if(blank) {
			for(int i = x ; i < x + N ; i++) {
				for(int j = y ; j < y + N ; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(N == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int size = N/3;
		int count = 0;
		
		for(int i = x ; i < x + N ; i += size) {
			for(int j = y ; j <y + N ; j += size) {
				count++;
				if(count == 5) {
					printStar(i, j, size, true);
				} else {
					printStar(i, j, size, false);
				}
			}
		}
		return;
	}
}
