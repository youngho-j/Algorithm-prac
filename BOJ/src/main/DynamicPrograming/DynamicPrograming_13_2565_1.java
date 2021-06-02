package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class DynamicPrograming_13_2565_1 {
	/*
		1. �Է�
		2. ������ a ���� ����
		3. ���� ���� ������ ã��(���)
		4. ���
	*/
	
	private static int N;
	private static int max = Integer.MIN_VALUE;
	
	private static int[][] wire;
	private static Integer[] count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		wire = new int[N][N];
		count = new Integer[N];
		
		StringTokenizer st;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(max, recur(i));
		}
		System.out.println(N - max);
	}
	
	public static int recur(int N) {
		if(count[N] == null) {
			// �ش� ��ǥ(N,0 / N,1)�� �ٸ� �����ϰ� �����ٵ��� ���� ���ϴ� ��찡 �ּ� ���� ���̹Ƿ� 1�� �ʱ�ȭ
			count[N] = 1;
			for(int i = N + 1 ; i < count.length ; i++) {
				if(wire[N][1] < wire[i][1]) {
					//  �ش� ��ǥ(N,0 / N,1)�� �ٸ� ����� ���� �ش� ��ǥ�� �� + ���� ��ǥ�� ����� �� �ִ� ����� ���� ��
					count[N] = Math.max(count[N], recur(i) + 1);
				}
			}
		}
		return count[N];
	}
}
