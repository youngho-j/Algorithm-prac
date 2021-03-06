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
				System.out.println(i + "��° �ּ� : " + min + " �ִ� : " + max);
			} else {
				min = list.get(i);
				max = list.get(i);
				System.out.println(i + "��° �ּ� : " + min + " �ִ� : " + max);
			}
		}
		System.out.println(min + " " + max);
	}
}

/*
 * ���� : �ش� ���� ���� �ڿ� ���� �־������ߴµ� �迭�� ������ �־ �񱳽� �߸��� ���� ������ ����
 * ������� : ���� �迭�� ���� �ʴ��� ���� Ǯ �� ������ 
 * �ּ� �ִ밪�� �ʱ�ȭ ��Ų �ڿ� StringTokenizer�� ���� �����ϴ��� Ȯ���ϴ� hasMoreToken���� �Ҹ��� ����ϸ� ����
 */
