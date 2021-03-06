package main.Arrangement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arrangement_5_1546 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//���� ������ ����
		int count = Integer.parseInt(br.readLine());
		
		//���� ���������� �ֱ� ���� �迭
		int[] subArr = new int[count];
		
		//�迭�� �ֱ����� ����
		int a = 0;
		
		//�ִ� ������ ���ϱ� ���� ����
		int max = 0;
		
		int sum = 0;
		
		//������ ���� ����
		st = new StringTokenizer(br.readLine(), " ");		
		
		do {
			subArr[a] = Integer.parseInt(st.nextToken());
			//�ִ� ������ ���ϱ� ����
			if(max < subArr[a]) {
				max = subArr[a];
			}
			sum += subArr[a];
			a++;
		} while (st.hasMoreTokens());
		// a �ʱ�ȭ
		a = 0;
		Double avg = (double)sum/max*100/count;
		System.out.println(avg);
	}
}

/*
 * ���ǻ��� - ����ȯ�� ū Ÿ�Կ��� ���� Ÿ������ ��ȯ�� ���� ������ �ս� ���� ����(�������� ���� ū ���, Ÿ���� Ư���� �ս�)!
 * byte >> short/char >> int >> long >> float >> double / double���� ���� ŭ
 * 
 */
// ó�� �õ�!
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		//���� ������ ����
//		int count = Integer.parseInt(br.readLine());
//		
//		//���� ���������� �ֱ� ���� ����
//		Double[] subArr = new Double[count];
//		
//		//�迭�� �ֱ����� ����
//		int a = 0;
//		
//		//�ִ� ������ ���ϱ� ���� ����
//		Double max = 0.0;
//		
//		Double sum = 0.0;
//		
//		//������ ���� ����
//		st = new StringTokenizer(br.readLine(), " ");		
//		
//		do {
//			subArr[a] = Double.parseDouble(st.nextToken());
//			//�ִ� ������ ���ϱ� ����
//			if(max < subArr[a]) {
//				max = subArr[a];
//			}
//			a++;
//		} while (st.hasMoreTokens());
//		a = 0;
//		
//		
//		// ���� ����
//		for(int i = 0 ; i < subArr.length ; i++) {
//			sum += ((subArr[i]/max)*100);
//		}
//		System.out.println(sum/count);
