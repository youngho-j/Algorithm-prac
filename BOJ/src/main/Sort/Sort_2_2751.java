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
//		Dual pivot quick sort �ð����⵵ O(n��) / ���� �ǹ� �� ���ĺ��� �ణ ����
//		�� ������ ���� �� �ϳ��� �ǹ��� ��� ������ ����(�������� ���ʺ��� ���� ��� ����)
//		��  < ���� �ǹ� | ���� �ǹ� | ���� �ǹ� <= && <= ������ �ǹ� | ������ �ǹ� | ������ �ǹ� < 
//		�� ��͸� ���� ����
//		������ �迭�� ���̰�  QUICKSORT_THRESHOLD ������� ���� ��� �� ������ �պ� ���ĺ��� �켱
//	    private static final int QUICKSORT_THRESHOLD = 286;
//		������ �迭�� ���̰� INSERTION_SORT_THRESHOLD ������� ���� ��� ���� ������ �� ���ĺ��� �켱
//	    private static final int INSERTION_SORT_THRESHOLD = 47;

		Arrays.sort(arr);
		
		for(int i = 0 ; i < arr.length ; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}
}
