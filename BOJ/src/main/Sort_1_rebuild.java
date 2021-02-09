package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_1_rebuild {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//		������ 1,000���� �۰ų� ���� ����, �ߺ�X�� ���� �迭
//		�ε���           ����
//		0 ~ 999     -> -1000 ~ -1
//		1000        -> 0
//		1001 ~ 2000 -> 1 ~ 1000
		boolean[] list = new boolean[2001];
		
//		�ش� ������ �ε����� true�� ���� 
		for(int i = 0 ; i < N ; i++) {
			list[Integer.parseInt(br.readLine()) + 1000] = true;
		}
//		�Էµ� ���ڸ� ������������ ����
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i]) {
				sb.append((i - 1000)+ "\n");				
			}
		}
		System.out.println(sb);
	}
}
