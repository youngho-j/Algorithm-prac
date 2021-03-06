package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_7_1085 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int minX = Math.min(x, w-x);
		int minY = Math.min(y, h-y);
		System.out.println(Math.min(minX, minY));
	}
}
/*
 * 시도 1. 0,0 축의 직사각형 경계선을 계산 않고 if문 분기 -> x, y축이 w, h 절반도 안될 경우 예외 발생
 * 시도 2. x, y축이 w, h 절반도 안될 경우 if문 분기 설정 최소 x, y 이동거리 구한 후 비교하여 출력
 * 시도 3. Math 클래스의 min 메소드 사용 [static method]
 * 
 * 시도 2. 코드
 * int minY = 0;
		int minX = 0;
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		if(y > (h/2)) {
			minY = h-y;
		} else {
			minY = y;
		}
		if(x > (w/2)) {
			minX = w-x;
		} else {
			minX = x;
		}
		if(minY > minX) {
			System.out.println(minX);
		} else {
			System.out.println(minY);			
		}
 */
