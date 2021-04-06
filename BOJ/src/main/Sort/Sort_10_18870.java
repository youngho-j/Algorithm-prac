package main.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sort_10_18870 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new  StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		
		//원본값을 담을 배열, 정렬된 값을 담을 배열 선언
		Long[] arr = new Long[N];
		Long[] copy = new Long[N];
		
		// 배열에 값을 담아줌
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			copy[i] = arr[i];
		}
		// 배열을 정렬하여 가장 낮은 숫자가 0 인덱스 위치로 이동하도록함
		Arrays.sort(copy);
		
		// 중복된 값은 같은 값을 가지므로 hashmap을 선언하여 값을 가져오도록함 
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		int cnt = 0;
		// 중복된 값이 아닐경우만 map에 담음
		for(int i = 0 ; i < N ; i++) {
			if(map.get(copy[i]) == null) {
				map.put(copy[i], cnt++);
			}
		}
		// 원본 배열의 값을 키로 사용하여 압축된 값을 StringBuilder에 담아줌 
		for(int i = 0 ; i < N ; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		
		System.out.println(sb);
	}
}
