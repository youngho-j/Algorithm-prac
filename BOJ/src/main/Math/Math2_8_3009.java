package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_8_3009 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�� x ��ǥ y ��ǥ ���� ����� �迭 
		int[] arrX = new int[4];
		int[] arrY = new int[4];
		
		// �־��� 3���� ���� x, y ��ǥ�� �迭�� ����� 
		for(int i = 0 ; i < 3 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arrX[i] = Integer.parseInt(st.nextToken());
			arrY[i] = Integer.parseInt(st.nextToken());
		}
		// �࿡ �����ϱ� ������ 3�� �� ��ġ���η� ����(x�࿡ �ش� �� 2��, y�� �ش� �� 2���� �� ���;������� 1���� �ִ� ��ǥ���� �־���) 
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
