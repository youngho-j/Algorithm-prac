package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_2_2292 {
	public static void main(String[] args) throws IOException{
//		������ �� : 1 - 1 [1]
//		������ �� : 2 - 2 ~ 7 [6]
//		������ �� : 3 - 8 ~ 19 [12]
//		������ �� : 4 - 20 ~ 37 [18]
//		������ �� : 5 - 38 ~ 61 [24] 
//		������ �� : 6 - 62 ~ 91 [30]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �־��� �� ��ȣ
		int result = Integer.parseInt(br.readLine());
		// ������ �ּ� ���� ������ �ش��ϴ� ���
		int size = 1;
		// ������ �ּ� ���� ����
		int count = 0;
		
		// ���° ���� ������ �𸣹Ƿ� while(true) ���
		while(true) {
			//�־��� ���� �߾��� ���� ��� 
			if(result == 1) {
				count++;
				break;
			//�߾��� ���� �ƴѰ��
			} else {
				//1������ ���������Ƿ�
				count++;
				//�Էµ� ���ȣ�� �ش�� ��ȣ�� �´��� Ȯ���ϱ� ���� 
				size += 6*count;
				if(result <= size) {
					//���� ��� �ش� ���� �����ؾ��ϹǷ� 
					count++;
					break; 
				 }
			}
		}
		System.out.println(count);
	}
}
/*
 * ���ǻ��� : ���۰� ���� �����Ͽ���� ������ ������ �ʱ�
 * ������ ���� ��ưڴ� �������� ����, �ϴ� ������ �ִ� ���Ǻ��� �����غ��鼭 �����ϱ�.. 
 * �ð��� �������� �� �����ɸ��������� ���� �ذ��ϰ� ���� ��� ����
 */
