package main.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort_2_collections {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i++) {
			 arr.add(Integer.parseInt(br.readLine()));
		}
//		Timsort - 합병정렬의 최악의 경우와 삽입정렬의 최선의 경우를 짬뽕한 알고리즘 
//		시간복잡도 O(n) ~ O(nlogn) 을 보장
		Collections.sort((List<Integer>) arr);
		
		arr.forEach(str -> sb.append(str + "\n"));
		
		System.out.println(sb);
	}
}
// 메소드 forEach와 for each문 차이 