package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_8_3009 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//각 x 좌표 y 좌표 값을 담아줄 배열 
		int[] arrX = new int[4];
		int[] arrY = new int[4];
		
		// 주어진 3개의 점의 x, y 좌표를 배열에 담아줌 
		for(int i = 0 ; i < 3 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arrX[i] = Integer.parseInt(st.nextToken());
			arrY[i] = Integer.parseInt(st.nextToken());
		}
		// 축에 평행하기 때문에 3개 중 일치여부로 조건(x축에 해당 점 2개, y축 해당 점 2개는 꼭 나와야함으로 1개만 있는 좌표값을 넣어줌) 
		if((arrX[0] != arrX[1]) && (arrX[1] == arrX[2])) {
			arrX[3] = arrX[0];
		} else if((arrX[0] != arrX[1]) && (arrX[1] != arrX[2])) {
			arrX[3] = arrX[1];
		} else {
			arrX[3] = arrX[2];
		}
		
		if((arrY[0] != arrY[1]) && (arrY[1] == arrY[2])) {
			arrY[3] = arrY[0];
		} else if((arrY[0] != arrY[1]) && (arrY[1] != arrY[2])) {
			arrY[3] = arrY[1];
		} else {
			arrY[3] = arrY[2];
		}
		
		System.out.println(arrX[3] + " " + arrY[3]);
	}
}
