package main.DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	arr -> �Է¹迭 , dp -> �� ���� �迭, N -> �ְ� ����
*/
public class DynamicPrograming_6_1932 {
	static int[][] arr;
	static int[][] dp;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		dp = new int[N][N];

//		arr ä���, dp -1�� �ʱ�ȭ(���� ���� 0 ~ 9999�̹Ƿ�)
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j <= i ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
//		dp�� �غ� �� �߰�
		for(int i = 0 ; i < N ; i++) {
			dp[N-1][i] = arr[N-1][i];
		}
		System.out.println(pathOfSum(0, 0)); 
	}

	/*
	 * ������ ������ �������� �������� ����Ϸ� ������, 
	 * ���� �غ����� ���޽� ��� �غ��� ���� ���ؾ��ϱ� ������ ó�������� �����..
	 * �Ʒ��� ���� ���� ������� ����
	 */
	public static int pathOfSum(int x, int y) {
//		�غ��� ���޽� ����� ���� �ҷ���
		if(x == N - 1) {
			return dp[x][y];
		}
//		Ž������ ���� ��� ���� ������ ���� ���� ���Ͽ� ���
		if(dp[x][y] == -1) {
			dp[x][y] = Math.max(pathOfSum(x + 1, y), pathOfSum(x + 1, y + 1)) + arr[x][y];
		}
//		���������� ���� �������� ū ���� 0,0�� �ԷµǹǷ� ����ϸ��
		return dp[x][y];
	}
}
