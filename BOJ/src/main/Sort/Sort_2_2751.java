package main.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort_2_2751 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
//		Dual pivot quick sort 시간복잡도 O(n²) / 단일 피벗 퀵 정렬보다 약간 빠름
//		→ 오른쪽 왼쪽 각 하나씩 피벗을 잡고 구역을 나눔(오른쪽이 왼쪽보다 작을 경우 스왑)
//		→  < 왼쪽 피벗 | 왼쪽 피벗 | 왼쪽 피벗 <= && <= 오른쪽 피벗 | 오른쪽 피벗 | 오른쪽 피벗 < 
//		→ 재귀를 통해 정렬
//		정렬할 배열의 길이가  QUICKSORT_THRESHOLD 상수보다 작은 경우 퀵 정렬이 합병 정렬보다 우선
//	    private static final int QUICKSORT_THRESHOLD = 286;
//		정렬할 배열의 길이가 INSERTION_SORT_THRESHOLD 상수보다 작을 경우 삽입 정렬이 퀵 정렬보다 우선
//	    private static final int INSERTION_SORT_THRESHOLD = 47;

		Arrays.sort(arr);
		
		for(int i = 0 ; i < arr.length ; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}
}
