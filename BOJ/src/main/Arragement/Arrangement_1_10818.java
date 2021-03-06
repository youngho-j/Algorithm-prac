package main.Arragement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Arrangement_1_10818 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>(a);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
		int min = 0;
		int max = 0;
		
		for(int i = 0 ; i < a ; i++) {
			list.add(i, Integer.parseInt(st.nextToken()));
			if(i > 0) {
				if(list.get(i) > max) {
					max = list.get(i);
				} else if(list.get(i) < min){
					min = list.get(i);					
				}
				System.out.println(i + "번째 최소 : " + min + " 최대 : " + max);
			} else {
				min = list.get(i);
				max = list.get(i);
				System.out.println(i + "번째 최소 : " + min + " 최대 : " + max);
			}
		}
		System.out.println(min + " " + max);
	}
}

/*
 * 원인 : 해당 값을 비교한 뒤에 값을 넣어줘어야했는데 배열의 전값을 넣어서 비교시 잘못된 값을 변수에 넣음
 * 참고사항 : 굳이 배열에 담지 않더라도 문제 풀 수 있을듯 
 * 최소 최대값을 초기화 시킨 뒤에 StringTokenizer에 값이 존재하는지 확인하는 hasMoreToken으로 불린값 출력하면 가능
 */
