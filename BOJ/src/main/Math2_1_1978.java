package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math2_1_1978 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int result = 0;
		
		for(int i = 0; i < count ; i++) {
			//�Ҽ� �Ǻ�
			boolean isPrime = true;
			
			int num = Integer.parseInt(st.nextToken()); 
			if(num == 1) {
				continue;
			}
			// 1�� ������ ����� �ǹǷ� 2���� ����, Math.sqrt -> �ش� �Ķ������ ��Ʈ ���ϱ�, �����ϰ�� NaN ��ȯ Ex) ��Ʈ 25 -> 5  
			for(int j = 2 ; j <= Math.sqrt(num) ; j++) {
				// ������ ��������� �Ҽ��� �ƴ�
				if(num % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				result++;
			}
		}
		System.out.println(result);
	}
}
/*
 * 
 * ���� :
 * �Ҽ� - ���� ������ 2������ �� 
 * '1�� �ڱ� �ڽ����ιۿ� ������ �������� �ʰ� �ڱ� �ڽ��� ������ ������ ���� ��'
 * �Ҽ� �Ǻ� -> 1�� �ڱ� �ڽ� ���� ����� ������. -> ������ (2 ~ N-1) ������ ���� �������� ����� �ƴϿ����Ѵ�. [���� ��� - �ð����⵵ O(N)]
 * �Ǻ��Ϸ��� ������ ������ �̻��� ���� ���� ��� ������ �˻��� �� �� ����� ���� ����� ���ų�, ����� �ƴѰ�� �ۿ� �����Ƿ� 
 * �Ǻ��Ϸ��� ������ �����ٱ����� �˻��ϸ��
 * 
 * ���⼭ �������� ��Ʈ ���� ������ �����ϸ� �ɵ� ���������� �������� '������ �����ϸ� �ش���ڰ� �Ǵ��� ������ ���Ͻÿ�'�� ������
 * ������ ���⼭�� ����� ������ ���ϹǷ�, ��Ʈ ���ڷ� ���.. 
 * 
 */
