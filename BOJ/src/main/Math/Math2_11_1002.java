package main.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Math2_11_1002 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < testCase ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			BigDecimal distancePow2 = BigDecimal.valueOf(x2-x1).pow(2).add(BigDecimal.valueOf(y2-y1).pow(2));
			
			// ������ ���� ������ ���� ���� ��ġ�Ͽ� ������ ���� 
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				sb.append(-1).append("\n");
			// ���� �ܺο��� ������ �ʴ� ���
			} else if(distancePow2.compareTo(BigDecimal.valueOf(r1+r2).pow(2)) == 1) {
				sb.append(0).append("\n");				
			// ���� ���ο��� ������ �ʴ� ���
			} else if(distancePow2.compareTo(BigDecimal.valueOf(r1-r2).pow(2)) == -1) {
				sb.append(0).append("\n");								
			// ���� ���ο��� ������ ���Ҷ�
			} else if(distancePow2.compareTo(BigDecimal.valueOf(r1+r2).pow(2)) == 0) {
				sb.append(1).append("\n");												
			// ���� �ܺο��� ������ ���Ҷ�
			} else if(distancePow2.compareTo(BigDecimal.valueOf(r1-r2).pow(2)) == 0) {
				sb.append(1).append("\n");																
			// �׿� ������ ���� ���Ҷ�
			} else {
				sb.append(2).append("\n");																				
			}
		}
		System.out.println(sb);
	}
}

// double distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
// ��ǥ �񱳽� double��(float��)�� ��� �ణ�� ���� �߻� ���� 
// -> �ε� �Ҽ��� Ÿ���� �ٻ�ġ�� ó���ϱ� ������ ���� �߻��� �� �Ǽ��� ���� ���� �� ����
// ����, ��Ȯ�� ����� �Ҷ��� BigDecimal�� ���
// ���� ���� �ڵ�
//  double distancePow = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
//	if(x1 == x2 && y1 == y2 && r1 == r2) {
//		sb.append(-1).append("\n");
//	} else if(distancePow > Math.pow(r1+r2, 2)) {
//		sb.append(0).append("\n");				
//	} else if(distancePow < Math.pow(r1-r2, 2)) {
//		sb.append(0).append("\n");								
//	} else if(distancePow == Math.pow(r1+r2, 2)) {
//		sb.append(1).append("\n");												
//	} else if(distancePow == Math.pow(r1-r2, 2)) {
//		sb.append(1).append("\n");																
//	} else {
//		sb.append(2).append("\n");																				
//}

