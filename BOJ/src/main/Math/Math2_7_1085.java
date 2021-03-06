package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_7_1085 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int minX = Math.min(x, w-x);
		int minY = Math.min(y, h-y);
		System.out.println(Math.min(minX, minY));
	}
}
/*
 * �õ� 1. 0,0 ���� ���簢�� ��輱�� ��� �ʰ� if�� �б� -> x, y���� w, h ���ݵ� �ȵ� ��� ���� �߻�
 * �õ� 2. x, y���� w, h ���ݵ� �ȵ� ��� if�� �б� ���� �ּ� x, y �̵��Ÿ� ���� �� ���Ͽ� ���
 * �õ� 3. Math Ŭ������ min �޼ҵ� ��� [static method]
 * 
 * �õ� 2. �ڵ�
 * int minY = 0;
		int minX = 0;
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		if(y > (h/2)) {
			minY = h-y;
		} else {
			minY = y;
		}
		if(x > (w/2)) {
			minX = w-x;
		} else {
			minX = x;
		}
		if(minY > minX) {
			System.out.println(minX);
		} else {
			System.out.println(minY);			
		}
 */
