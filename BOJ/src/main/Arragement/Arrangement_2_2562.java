package main.Arragement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arrangement_2_2562 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int max = 0;
		int count = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) {
				max = arr[i];
				//배열의 첫 시작은 0이므로 순서를 나타낼때 +1을 해야함
				count = i+1;
			}
		}
		System.out.println(max + "\n" + count);
	}
}

/*
 * 참고사항 :  배열의 시작번호는 0부터 시작!
 */
