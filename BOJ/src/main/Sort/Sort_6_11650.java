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
//		�͸� ��ü
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
//				�⺻������ o1���� i+1��° �ε����� o2���� i��° �ε��� ���� ��
//				�������� - ���� ���� �켱������ ����.
//				�������� - ū ���� �켱������ ����.
				
//				o1�� o2���� �켱 ������ ���� -> ����
//				o1�� o2�� �켱 ������ ���� -> 0
//				o1�� o2���� �켱 ������ ���� -> ���
				
//				x�� ���� ������
				if(o1[0] == o2[0]) {
//					y�� �������� ���� - �������� �������� 
//					=> o1 < o2 -> o1 - o2 < 0;  
//					return o1[1] - o2[1];

//					y�� �������� ���� - ū���� ��������
//					=> ���������� �ݴ��̹Ƿ� -1�� ������
//					return (o1[1] - o2[1])*(-1);
					
//					compare(int[] o1, int[] o2) - �������� ����
//					return Integer.compare(o1[1], o2[1]);
					
//					compare(int[] o2, int[] o1) - �������� ����
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
