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
//		Timsort - �պ������� �־��� ���� ���������� �ּ��� ��츦 «���� �˰��� 
//		�ð����⵵ O(n) ~ O(nlogn) �� ����
		Collections.sort((List<Integer>) arr);
		
		arr.forEach(str -> sb.append(str + "\n"));
		
		System.out.println(sb);
	}
}
// �޼ҵ� forEach�� for each�� ���� 