package main.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_4_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
/*
 * 0 ~ 3999 -> -4000 ~ -1 4000 -> 0 4001 ~ 8000 -> 1 ~ 4000
 */
		int[] list = new int[8001];
/*
 * sum = ������ min = �ּڰ� max = �ִ� most = �ֺ� middle = �߾Ӱ�
 */		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int mode = 0;
		int middle = 0;
		
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			list[num + 4000]++;
			
			if(max < num) {
				max = num;
			}
			if(min > num) {
				min = num;
			}
		}
		int count = 0;
		int mode_max = 0;
//		�ֺ� ������ ������Ű�� ���� ����
		boolean check = false;
//		�ּҰ��� �ִ밪 ���̿� ������ ���� ���� �ϹǷ� +4000�Ͽ� �� ���� ������ ã��
		for(int i = min + 4000 ; i <= max + 4000 ; i++) {
			//�Է¹��� �� �� ���
			if(list[i] > 0) {
//				�߾Ӱ� ã�� -> �ش� ���� ���� ������ count�� ���Ͽ� ��ü ������ ���ݿ� �� ��ĥ������ ���� 
				if(count < (N+1)/2) {
					count += list[i];
					middle = i - 4000;
				}
//				�ֺ� ã�� -> �ش� ���� ���� ������ mode_max ���� Ŭ ��� mode_max�� �־� �˻�
//				����, ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ���
				if(mode_max < list[i]) {
					mode_max = list[i];
					mode = i - 4000;
					check = true;
				} else if(mode_max == list[i] && check == true) {
					mode = i - 4000;
					//���ǻ� �� ��°�� ���� �� ���Ĵ� �ʿ�����Ƿ�
					check = false;
				}
			}
		}
//		������, �߾Ӱ�, �ֺ�, ���� �� ���
		System.out.println((int)Math.round((double)sum/N));
		System.out.println(middle);
		System.out.println(mode);
		System.out.println(max - min);
	}
}
