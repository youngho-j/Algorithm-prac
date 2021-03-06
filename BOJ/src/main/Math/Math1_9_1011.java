package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math1_9_1011 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < testCase ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dis = y-x;
			int max = (int)Math.sqrt(dis);
			
			if(max == Math.sqrt(dis)) {
				sb.append(2 * max - 1).append("\n");
			} else if(dis <= max * max + max) {
				sb.append(2 * max).append("\n");
			} else {
				sb.append(2 * max + 1).append("\n");
			}
		}
		System.out.println(sb);
	}
}

/*
 * ���� :
 * 1. �� �۵��ñ⿡ k �Ÿ� �̵��� ���� �̵��� k-1, k, k+1 �Ÿ���ŭ�� �̵� ����
 * 2. ó�� �̵��ô� ������ 1 �̵�
 * 3. y ���� ���� ���� �̵��Ÿ��� ������ 1 �̵��ؾ��� -> ���� ���� ���� �Ÿ� �̵��� 1, 2�� ���ѵ�(0�� �̵��Ѱ� �����Ƿ� ����)
 * 
 * ���ǻ��� : Ȯ���� �ϻ꺸�ٴ� ������ ���������°� ������ ���� �ȴ�.
 * ó�� �õ��� �Ÿ��� ���Ҷ� �ش� y-x �� �ƴ� ������ ó���� ���� 1�� �Ÿ��̵��� �����Ǿ� �־� (y-1)-(x+1)�� Ǯ���µ� �̰� 
 * �Ÿ��� 1�ϰ��� ���� ���� ���� �Ÿ��̵��� �Ÿ��� 3�̻� ������ ��쵵 �־� ���� �Ÿ��̵��� 1�� ���� �ʾ� ���� ���ƾ���.. �� 
 * |dis|count|maxDis|moveDis|
*/
