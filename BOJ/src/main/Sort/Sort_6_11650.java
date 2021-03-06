package main.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sort_6_11650 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
//		익명 객체
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
//				기본적으로 o1에는 i+1번째 인덱스값 o2에는 i번째 인덱스 값이 들어감
//				오름차순 - 작은 값이 우선순위가 높다.
//				내림차순 - 큰 값이 우선순위가 높다.
				
//				o1가 o2보다 우선 순위가 높다 -> 음수
//				o1와 o2의 우선 순위가 같다 -> 0
//				o1가 o2보다 우선 순위가 낮다 -> 양수
				
//				x축 값이 같으면
				if(o1[0] == o2[0]) {
//					y축 오름차순 정렬 - 작은값이 왼쪽으로 
//					=> o1 < o2 -> o1 - o2 < 0;  
//					return o1[1] - o2[1];

//					y축 내림차순 정렬 - 큰값이 왼쪽으로
//					=> 오름차순과 반대이므로 -1을 곱해줌
//					return (o1[1] - o2[1])*(-1);
					
//					compare(int[] o1, int[] o2) - 오름차순 정렬
//					return Integer.compare(o1[1], o2[1]);
					
//					compare(int[] o2, int[] o1) - 내림차순 정렬
					return Integer.compare(o2[1], o1[1]);
				} else {
//					return o1[0] - o2[0];
					return Integer.compare(o1[0], o2[0]);
				}
			}
		});
		
		for(int i = 0 ; i < N ; i++) {
			sb.append(arr[i][0] + " " + arr[i][1] + "\n");
		}
		System.out.println(sb);
	}
}
