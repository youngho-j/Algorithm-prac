package main;

public class Function_2_4673 {
	//�־��� �� <=10000
	public static void main(String[] args) {
		int[] arr = new int[10001];
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= 10000 ; i++) {
			int n = d(i);
			if(n > 10000) {
				continue;
			}
			//�������� ����
			arr[n] += 1;
		}
		for(int j = 1 ; j < arr.length ; j++) {
			//�����ѹ��ΰ�� 
			if(arr[j] == 0) {
				sb.append(j).append("\n");
			}
		}
		System.out.println(sb);
	}
	//���� �ѹ� ���ϴ� �Լ�
	public static int d(int number) {
		// �Ķ���ͷ� �Ѿ�� ���� �������� ���ϱ�
		int sum = number;
		// ���ڸ����� ���ϱ� ���� while�� �ݺ� / �Ķ���Ͱ� 0�� �Ǹ� �ݺ�����
		while(number != 0) {
			// ���ڸ����� ����, ������ 1���ڸ� ���� ���� �ö�
			sum = sum + (number % 10);
			// ���� �ڸ����� ���ϱ� ���� ������ 10�� ��
			number = number / 10;
		}
		return sum;
	}
}
/*
 * ���� : ���ڸ� ������� �迭�� �ֱ� ���� �迭 ���� 10001�� ���� �س��� ������ �Ѵ� 10001���� �����ؼ� ����
 * StringBuilder�� ���� ������ ���ڸ� �־���ϴµ� �迭�� ���ִ� ���� �־ Ʋ��
 * 
 * ���� : ���� ������ �Ű澲�� !
 */
