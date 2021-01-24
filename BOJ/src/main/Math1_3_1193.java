package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_3_1193 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���ϰ��� �ϴ� ����
		int x = Integer.parseInt(br.readLine());
		// ĭ ������ ����� ���� (ó�� �밢���� 1/1 1���� �����Ƿ� �ʱⰪ�� 1��)
		int count = 1;
		// ĭ ������ ���� ��
		int sum = 0;
		
		// ��� �ݺ��ؾ����� �𸣹Ƿ� while
		while(true) {
			if(x <= count + sum) {
				// �밢���� ������ ¦���ϰ�� Ȧ���ϰ�� 
				if(count % 2 == 1) {
					// �밢���� ���� Ȧ�� > �и� ���ں��� ū ������ ���� (���� : ����)
					// ��������� ���� > ���ڴ� �����ϹǷ�, x - �������� / �и� + ���� = ī��Ʈ + 1
					System.out.println(((count+1)-(x-sum)) + "/" + (x-sum));
					break;
				} else {
					System.out.println((x-sum) + "/" + ((count+1)-(x-sum)));					
					break;
				}
			} else { 
				// x���� count + sum���� ū��� ���� �밢���� ������ ���� ���� ���ϱ� ���� 
				sum += count;
				count++;
			}
		}		
	}
}
/*
 *  Ǯ�̰��� :
 *  �õ� 1 : ó�� ������ �Ҷ��� ���߹迭�� �����Ͽ��� > ��ġ�� ������ �־����� �ش� ���� ��� �������� �𸣰ھ ������� ����ġ
 *  �õ� 2 : ���κ��� �����ϴ� �� Ȧ��>¦�� ���� ������ +1 ¦��>Ȧ�� +4 �̰� ������ ������.. ��������
 *  �õ� 3 : �밢������ ������ ��� Ȧ�������ϰ�� ������� ���ϴ� ���� ����, ¦������ ������� ���� �� ����.. ��ġ������ ���� ��ã�Ƽ� �ٽ� ����ġ
 *  �õ� 4 : �밢�� ���� ���� +1 ��Ģ ã��, �׷��� ���� �ȿͼ� ��Ʈ ����.. 
 *  �õ� 5 : �밢���� ���� �и��� �� ¦��, ������ Ȧ�� / �� Ȧ��, ���� ¦�� 
 *  
 *  �ٸ� ��� �ڵ带 ���� �ǰ� �����ϰ� Ǯ���͵��� ���ֺ��µ� �� Ǯ�� Ǯ���� ��Ģ�� ã�°� ���絥 �Ф� 
 *  ��Ʈ ���̵� Ǯ �� �ֵ��� �� ����ؾ߰ڴ�.
 *  
 *  
 *    
 *  
 */
