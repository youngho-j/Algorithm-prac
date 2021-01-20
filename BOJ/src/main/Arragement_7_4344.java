package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arragement_7_4344 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//�л� ��
		int stu = 0;
		//���� ��
		int sum = 0;
		// ���̽� ��
		int testCase = Integer.parseInt(br.readLine());
		//�迭 
		int[] temp;
		// �迭�� �� Ƚ�� üũ
		int c = 0;
		// ��պ��� ���� ���� ģ����
		int rs = 0;
		
		for(int i = 0 ; i < testCase ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			//�л� ��
			stu = Integer.parseInt(st.nextToken());
			//�л� ����ŭ �迭 ����
			temp = new int[stu];
			
			//�л��� ����
			while (st.hasMoreTokens()) {
				temp[c] = Integer.parseInt(st.nextToken());
				sum += temp[c];
				c++;
			}
			// ��� �Ѵ� �л� �� 
			for(int j = 0 ; j < temp.length ; j++) {
				if(temp[j] > sum/c) {
					rs++;
				}
			}
			// ��� �Ѵ� �л� ���� ��� - ����ȯ�� float, double �������
//			System.out.printf("%.3f%%\n", 100.0 * rs / c);
//			sb.append(String.format("%.3f", (double) rs / c * 100)).append("%\n");
			sb.append(String.format("%.3f%%%n", (double) rs / c * 100));
			
			
			// ���� ��� �� �ʱ�ȭ
			c = 0;
			sum = 0;
			rs = 0;
		}
		System.out.println(sb);
	}
}
/*
 * ���� : decimalFormat, Math.round ���� Ʋ��.. ��Ŭ������ ����, ����� Ʋ�Ƚ��ϴ�. �ð���� �ٽ� �ѹ� �����ҵ� / ���� ������ ���� ������ ������ �����ε�?
 *  ���� �õ��� ��Ȳ�� ���� ����� ���� : 
 *  https://dev538.tistory.com/entry/%EB%B0%B1%EC%A4%80-JAVA4344%EB%B2%88-%ED%8F%89%EA%B7%A0%EC%9D%80-%EB%84%98%EA%B2%A0%EC%A7%80
 *  
 * �˾Ƶα� : 
 * printf("��� ����", ��� ����) - ��� �� �ٹٲ� ���� \n �Ǵ� %n �߰� �ʿ�
 *   - ��¼��� %[-][0][n][.m]������
 *   �����ڸ� ������ ������ ���� ���� Ex) %d 
 *   - : ��ü �ڸ��� ������ ��� ���� ���� �� ��ĭ�� ���� ���
 *   0 : ��ü �ڸ��� ������ ��� ���� ���� �ڸ��� 0�� ���  Ex) %03d
 *   n : ����� ��ü �ڸ��� ����(������ ����).  Ex) %3d, ��ü�ڸ����� 3�� ����
 *  .m : �Ҽ��� �Ʒ� �ڸ��� ����, �߸��� �Ҽ��� �ڸ����� �ݿø��Ͽ� ǥ��.  Ex)3.2f, ��ü�ڸ����� 3�̰� �Ҽ��� ��°�ڸ��� �Ǽ�
 *  
 *   - ������ 
 *   %b : boolean �������� ��� 
 *   %d : ���� �������� ���
 *   %o : 8���� ������ �������� ���
 *   %x or %X : 16���� ������ �������� ���
 *   %f : �Ҽ��� �������� ���
 *   %c : ������������ ��� 
 *   %s : ���ڿ� �������� ���
 *   %n	: �ٹٲ� ���
 *   %e or %E : ���� ǥ������ �������� ���
 *   
 *   float �� double�� ����
 *   - ǥ�������� �Ǽ��� �󸶳� �����Ѱ��� ���� / double�� ���������� �ٰ� �� ������ ��� ����
 */
