package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sort_7_11651 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
//			x좌표
			arr[i][0] = Integer.parseInt(st.nextToken());
//			y좌표
			arr[i][1] = Integer.parseInt(st.nextToken());
		}	
		/*
		 * 익명 클래스 
		 * 클래스의 선언과 객체의 생성을 동시에 하기에 한번만 사용 가능, 오직 하나의 객체만을 생성할 수 있음 
		 * 익명 클래스 사용시 상속처리 
		 * -> 인터페이스를 정의하고 인터페이스를 익명 클래스로 만들 경우 인스턴스 없이 사용 가능! 
		 * 예) comparator 인터페이스를 익명클래스로 사용! ↓ new Comparator<T>
		 * 
		 * 인터페이스명 변수명 = new 인터페이스명() {
		 * 	인터페이스의 메서드 오버라이딩
		 * }
		 * 
		 * 
		 */
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
//				y 좌표가 같은 경우
				if(o1[1] == o2[1]) {
//					x 좌표 오름차순으로 정렬
					return Integer.compare(o1[0], o2[0]);
				} else {
//				y 좌표가 다른 경우 y좌표 오름차순으로 정렬
					return Integer.compare(o1[1], o2[1]);
				}
			}
		});
		
		for(int i = 0 ; i < N ; i++) {
			sb.append(arr[i][0] + " " + arr[i][1] + "\n");
		}
		System.out.println(sb);
	}
}
