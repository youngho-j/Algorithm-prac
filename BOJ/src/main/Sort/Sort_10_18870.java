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
		
		//�������� ���� �迭, ���ĵ� ���� ���� �迭 ����
		Long[] arr = new Long[N];
		Long[] copy = new Long[N];
		
		// �迭�� ���� �����
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			copy[i] = arr[i];
		}
		// �迭�� �����Ͽ� ���� ���� ���ڰ� 0 �ε��� ��ġ�� �̵��ϵ�����
		Arrays.sort(copy);
		
		// �ߺ��� ���� ���� ���� �����Ƿ� hashmap�� �����Ͽ� ���� ������������ 
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		int cnt = 0;
		// �ߺ��� ���� �ƴҰ�츸 map�� ����
		for(int i = 0 ; i < N ; i++) {
			if(map.get(copy[i]) == null) {
				map.put(copy[i], cnt++);
			}
		}
		// ���� �迭�� ���� Ű�� ����Ͽ� ����� ���� StringBuilder�� ����� 
		for(int i = 0 ; i < N ; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		
		System.out.println(sb);
	}
}
