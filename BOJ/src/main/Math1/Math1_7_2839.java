package main.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_7_2839 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sugar = Integer.parseInt(br.readLine());
		// ���� �ִ� ��
		int temp1 = 5000;
		// 5kg ������ ���ƾ� �� ���� ������ ��� ����
		for(int i = 0 ; i <= (sugar/5) ; i++) {
			int remaining = sugar - (5*i);
			if(remaining % 3 == 0) {
				if((i + (remaining/3)) < temp1) {
					temp1 = i + (remaining/3);					
				}
			} 
		}
		//5kg + 3kg ������ �ȵɰ��
		if(temp1 == 5000) {
			temp1 = -1;					
		}
		System.out.println(temp1);
	}
}
/*
	�õ� 1. if�� �б�� �ذ� -> ����
	�õ� 2. for���� ���� �ּҺ����� ���ϱ� ���� 5�� ���� �� 3kg�� ä��� ��� else�� ��ġ ������ Ʋ�� 
	
	������� : ��Ģã��(�������� ����)
	"�� �Ҽ��� ������ ǥ�� ������ ��� ������, 
	��� ���� 1�� �� ������ ���ϴ� ��ŭ �󸶵��� ���� ������ �Ҽ��� ������ ������ �� �ִ�."
	-> ���� "2���� ū ��� ¦���� �� �Ҽ��� ������ ǥ�������ϴ�." (���� �������� ����)
	
	�ϴ� ��ǻ�ͷ� 10^18 ������ ���� ���� �������� ���� ������� ������,
	�������� ���� �������� ������ ������ �� ���� �������� ������ ����� ���� �ƴϴ�.
	�׷��� ��ǻ� ���̶�� ����� �ִ�.
	
	�׷��� ������ 8 �̻��� ������ 3�� 5�� �������� ���ϴ� ���� 0�� �����ٰ� �� ���̴�.
	Reference : https://st-lab.tistory.com/72?category=841870
	
*/
// �õ� 1. �ڵ�
//if(sugar % 5 != 0) {
//	temp1 = sugar/5;
//	if((sugar % 5) % 3 != 0) {
//		temp1 = -1;
//	} else {
//		temp1 += (sugar % 5) / 3;
//	}
//} else {
//	
//}

//�õ� 2. �ڵ�
//int temp1 = 5000;
//for(int i = 0 ; i <= (sugar/5) ; i++) {
//	int remaining = sugar - (5*i);
//	if(remaining % 3 == 0) {
//		if((i + (remaining/3)) < temp1) {
//			temp1 = i + (remaining/3);					
//		}
//	} else {
//		if(temp1 == 5000) {
//			temp1 = -1;					
//		}
//	}
//}
//System.out.println(temp1);